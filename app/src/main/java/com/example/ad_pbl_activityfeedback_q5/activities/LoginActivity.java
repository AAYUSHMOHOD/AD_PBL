package com.example.ad_pbl_activityfeedback_q5.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ad_pbl_activityfeedback_q5.R;
import com.example.ad_pbl_activityfeedback_q5.models.User;
import com.example.ad_pbl_activityfeedback_q5.utils.FirebaseHelper;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private Button loginButton;
    private TextView registerTextView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        emailEditText = findViewById(R.id.email_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        loginButton = findViewById(R.id.login_button);
        registerTextView = findViewById(R.id.register_text_view);
        progressBar = findViewById(R.id.progress_bar);

        // Setup login button
        loginButton.setOnClickListener(v -> attemptLogin());

        // Setup register text view
        registerTextView.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    private void attemptLogin() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        // Validate inputs
        if (email.isEmpty()) {
            emailEditText.setError("Email is required");
            emailEditText.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            passwordEditText.setError("Password is required");
            passwordEditText.requestFocus();
            return;
        }

        // Show progress
        progressBar.setVisibility(View.VISIBLE);
        loginButton.setEnabled(false);

        // Attempt login
        FirebaseHelper.loginUser(email, password, task -> {
            progressBar.setVisibility(View.GONE);
            loginButton.setEnabled(true);

            if (task.isSuccessful()) {
                // Get user details and navigate
                FirebaseHelper.getCurrentUser(user -> {
                    if (user != null) {
                        navigateBasedOnRole(user);
                    } else {
                        Toast.makeText(LoginActivity.this,
                                "Error retrieving user data", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                Toast.makeText(LoginActivity.this,
                        "Login failed: " + task.getException().getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void navigateBasedOnRole(User user) {
        Intent intent;
        if (user.isProfessor()) {
            intent = new Intent(LoginActivity.this, ProfessorDashboardActivity.class);
        } else {
            intent = new Intent(LoginActivity.this, StudentDashboardActivity.class);
        }
        intent.putExtra("userId", user.getUserId());
        intent.putExtra("userName", user.getName());
        startActivity(intent);
        finish();
    }
}