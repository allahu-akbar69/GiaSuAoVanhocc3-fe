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
import org.json.JSONObject;

public class SignupActivity extends AppCompatActivity {
    private FirebaseAuthHelper firebaseAuthHelper;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize Firebase Auth Helper
        firebaseAuthHelper = new FirebaseAuthHelper(this);
        firebaseAuthHelper.setAuthCallback(new FirebaseAuthHelper.AuthCallback() {
            @Override
            public void onSuccess(String token, String userId, String email, String name, String provider) {
                runOnUiThread(() -> {
                    Toast.makeText(SignupActivity.this, "Đăng ký " + provider + " thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignupActivity.this, MainActivity.class));
                    finish();
                });
            }

            @Override
            public void onError(String error) {
                runOnUiThread(() -> {
                    Toast.makeText(SignupActivity.this, "Lỗi đăng ký: " + error, Toast.LENGTH_SHORT).show();
                });
            }
        });

        Button btnSignup = findViewById(R.id.btnCreateAccount);
        TextView tvLogin = findViewById(R.id.tvGoLogin);
        ImageButton btnBack = findViewById(R.id.btnBackSignup);
        EditText edtName = findViewById(R.id.edtName);
        EditText edtEmail = findViewById(R.id.edtEmailSignup);
        EditText edtPassword = findViewById(R.id.edtPasswordSignup);
        
        // Social signup buttons
        ImageView btnGoogle = findViewById(R.id.btnGoogleSignup);
        ImageView btnFacebook = findViewById(R.id.btnFacebookSignup);

        btnSignup.setOnClickListener(v -> {
            String name = edtName.getText().toString().trim();
            String email = edtEmail.getText().toString().trim();
            String password = edtPassword.getText().toString();
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }
            new Thread(() -> {
                try {
                    JSONObject body = new JSONObject();
                    body.put("name", name);
                    body.put("email", email);
                    body.put("password", password);
                    JSONObject resp = ApiClient.postJson("/auth/signup", body);
                    String token = resp.optString("token", null);
                    if (token != null) {
                        SessionManager.saveToken(this, token);
                    }
                    runOnUiThread(() -> {
                        Toast.makeText(this, "Tạo tài khoản thành công", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(this, MainActivity.class));
                    });
                } catch (Exception e) {
                    runOnUiThread(() -> Toast.makeText(this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show());
                }
            }).start();
        });
        tvLogin.setOnClickListener(v -> startActivity(new Intent(this, LoginActivity.class)));
        btnBack.setOnClickListener(v -> finish());
        
        // Social signup button click listeners
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


