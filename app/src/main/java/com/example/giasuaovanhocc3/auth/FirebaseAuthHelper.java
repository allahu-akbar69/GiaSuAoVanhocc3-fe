package com.example.giasuaovanhocc3.auth;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.giasuaovanhocc3.network.ApiClient;
import com.example.giasuaovanhocc3.network.SessionManager;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import org.json.JSONObject;

import java.util.Arrays;

public class FirebaseAuthHelper {
    private static final int RC_SIGN_IN = 9001;
    private static final String TAG = "FirebaseAuthHelper";
    
    private Context context;
    private FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;
    private CallbackManager mCallbackManager;
    private AuthCallback authCallback;
    
    public interface AuthCallback {
        void onSuccess(String token, String userId, String email, String name, String provider);
        void onError(String error);
    }
    
    public FirebaseAuthHelper(Context context) {
        this.context = context;
        mAuth = FirebaseAuth.getInstance();
        setupGoogleSignIn();
        setupFacebookSignIn();
    }
    
    private void setupGoogleSignIn() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("112688423925-62v1or9da3lmnkb71f9vos3s5vlqcu95.apps.googleusercontent.com") // Replace with your actual web client ID
                .requestEmail()
                .build();
        
        mGoogleSignInClient = GoogleSignIn.getClient(context, gso);
    }
    
    private void setupFacebookSignIn() {
        mCallbackManager = CallbackManager.Factory.create();
        
        LoginManager.getInstance().registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                handleFacebookAccessToken(loginResult.getAccessToken());
            }
            
            @Override
            public void onCancel() {
                if (authCallback != null) {
                    authCallback.onError("Facebook login cancelled");
                }
            }
            
            @Override
            public void onError(FacebookException error) {
                if (authCallback != null) {
                    authCallback.onError("Facebook login error: " + error.getMessage());
                }
            }
        });
    }
    
    public void setAuthCallback(AuthCallback callback) {
        this.authCallback = callback;
    }
    
    public Intent getGoogleSignInIntent() {
        return mGoogleSignInClient.getSignInIntent();
    }
    
    public void signInWithGoogle() {
        signInWithGoogle(false);
    }

    public void signInWithGoogle(boolean forceAccountPicker) {
        if (forceAccountPicker) {
            mGoogleSignInClient.signOut().addOnCompleteListener(task -> {
                Intent signInIntent = getGoogleSignInIntent();
                if (context instanceof android.app.Activity) {
                    ((android.app.Activity) context).startActivityForResult(signInIntent, RC_SIGN_IN);
                }
            });
            return;
        }
        Intent signInIntent = getGoogleSignInIntent();
        if (context instanceof android.app.Activity) {
            ((android.app.Activity) context).startActivityForResult(signInIntent, RC_SIGN_IN);
        }
    }
    
    public void signInWithFacebook() {
        LoginManager.getInstance().logInWithReadPermissions(
                (android.app.Activity) context,
                Arrays.asList("email", "public_profile")
        );
    }
    
    public void handleGoogleSignInResult(Intent data) {
        try {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            GoogleSignInAccount account = task.getResult(ApiException.class);
            if (account != null) {
                firebaseAuthWithGoogle(account.getIdToken());
            }
        } catch (ApiException e) {
            if (authCallback != null) {
                authCallback.onError("Google sign in failed: " + e.getMessage());
            }
        }
    }
    
    public void handleFacebookCallbackResult(int requestCode, int resultCode, Intent data) {
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }
    
    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener((android.app.Activity) context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            if (user != null) {
                                handleAuthSuccess(user, "google");
                            }
                        } else {
                            if (authCallback != null) {
                                authCallback.onError("Google authentication failed: " + task.getException().getMessage());
                            }
                        }
                    }
                });
    }
    
    private void handleFacebookAccessToken(AccessToken token) {
        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener((android.app.Activity) context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            if (user != null) {
                                handleAuthSuccess(user, "facebook");
                            }
                        } else {
                            if (authCallback != null) {
                                authCallback.onError("Facebook authentication failed: " + task.getException().getMessage());
                            }
                        }
                    }
                });
    }
    
    private void handleAuthSuccess(FirebaseUser user, String provider) {
        String userId = user.getUid();
        String email = user.getEmail();
        String name = user.getDisplayName();
        
        // Create a custom token for your backend
        String customToken = createCustomToken(userId, email, name, provider);
        
        // Save to session
        SessionManager.saveToken(context, customToken);
        
        // Send user data to your backend
        sendUserDataToBackend(userId, email, name, provider);
        
        if (authCallback != null) {
            authCallback.onSuccess(customToken, userId, email, name, provider);
        }
    }
    
    private String createCustomToken(String userId, String email, String name, String provider) {
        // Create a simple token format - you might want to use JWT or your own token format
        return "firebase_" + provider + "_" + userId + "_" + System.currentTimeMillis();
    }
    
    private void sendUserDataToBackend(String userId, String email, String name, String provider) {
        new Thread(() -> {
            try {
                JSONObject body = new JSONObject();
                body.put("firebase_uid", userId);
                body.put("email", email);
                body.put("name", name);
                body.put("provider", provider);
                
                // Add provider-specific IDs
                if ("google".equals(provider)) {
                    body.put("google_id", userId);
                } else if ("facebook".equals(provider)) {
                    body.put("facebook_id", userId);
                }
                
                // Call your backend API to save/update user data
                JSONObject response = ApiClient.postJson("/auth/firebase-login", body);
                
            } catch (Exception e) {
                // Handle error silently or log it
                e.printStackTrace();
            }
        }).start();
    }
    
    public void signOut() {
        mAuth.signOut();
        mGoogleSignInClient.signOut();
        LoginManager.getInstance().logOut();
        SessionManager.clear(context);
    }
    
    public FirebaseUser getCurrentUser() {
        return mAuth.getCurrentUser();
    }
    
    public boolean isSignedIn() {
        return mAuth.getCurrentUser() != null;
    }
}
