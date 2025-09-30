package com.example.giasuaovanhocc3.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.giasuaovanhocc3.R;
import com.example.giasuaovanhocc3.auth.FirebaseAuthHelper;
import com.example.giasuaovanhocc3.network.ApiClient;
import com.example.giasuaovanhocc3.network.SessionManager;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuthHelper firebaseAuthHelper;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize Firebase Auth Helper
        // Initialize Facebook SDK before using LoginManager
        try {
            FacebookSdk.sdkInitialize(getApplicationContext());
            AppEventsLogger.activateApp(getApplication());
        } catch (Throwable t) {
            // Safe-guard: continue even if init logs an error
        }

        firebaseAuthHelper = new FirebaseAuthHelper(this);
        firebaseAuthHelper.setAuthCallback(new FirebaseAuthHelper.AuthCallback() {
            @Override
            public void onSuccess(String token, String userId, String email, String name, String provider) {
                runOnUiThread(() -> {
                    Toast.makeText(LoginActivity.this, "Đăng nhập " + provider + " thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                });
            }

            @Override
            public void onError(String error) {
                runOnUiThread(() -> {
                    Toast.makeText(LoginActivity.this, "Lỗi đăng nhập: " + error, Toast.LENGTH_SHORT).show();
                });
            }
        });

        Button btnLogin = findViewById(R.id.btnLogin);
        TextView tvSignup = findViewById(R.id.tvSignup);
        ImageButton btnBack = findViewById(R.id.btnBackLogin);
        EditText edtEmail = findViewById(R.id.edtEmail);
        EditText edtPassword = findViewById(R.id.edtPassword);
        
        // Social login buttons
        ImageView btnGoogle = findViewById(R.id.btnGoogleLogin);
        ImageView btnFacebook = findViewById(R.id.btnFacebookLogin);

        btnLogin.setOnClickListener(v -> {
            String email = edtEmail.getText().toString().trim();
            String password = edtPassword.getText().toString();
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập email và mật khẩu", Toast.LENGTH_SHORT).show();
                return;
            }
            new Thread(() -> {
                try {
                    JSONObject body = new JSONObject();
                    body.put("email", email);
                    body.put("password", password);
                    JSONObject resp = ApiClient.postJson("/auth/login", body);
                    String token = resp.optString("token", null);
                    if (token != null) {
                        SessionManager.saveToken(this, token);
                    }
                    runOnUiThread(() -> {
                        Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(this, MainActivity.class));
                    });
                } catch (Exception e) {
                    runOnUiThread(() -> Toast.makeText(this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show());
                }
            }).start();
        });
        tvSignup.setOnClickListener(v -> startActivity(new Intent(this, SignupActivity.class)));
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> onBackPressed());
        }
        
        // Social login button click listeners
        if (btnGoogle != null) {
            btnGoogle.setOnClickListener(v -> firebaseAuthHelper.signInWithGoogle(true));
        }
        
        if (btnFacebook != null) {
            btnFacebook.setOnClickListener(v -> firebaseAuthHelper.signInWithFacebook());
        }
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        
        // Handle Google Sign-In result
        if (requestCode == 9001) { // RC_SIGN_IN
            firebaseAuthHelper.handleGoogleSignInResult(data);
        }
        
        // Handle Facebook Login result
        firebaseAuthHelper.handleFacebookCallbackResult(requestCode, resultCode, data);
    }
}


