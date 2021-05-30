package com.example.mydiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class RegistrationActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText RegEmail, RegPass;
    private Button RegBtn;
    private TextView RegQuestion;
    private FirebaseAuth mAuth;

    private ProgressDialog loader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_registration);
//
//        toolbar = findViewById(R.id.loginToolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("Registration");

        mAuth = FirebaseAuth.getInstance();
        loader = new ProgressDialog(this);

        RegEmail = findViewById(R.id.RegistrationEmail);
        RegPass = findViewById(R.id.RegistrationPassword);
        RegBtn = findViewById(R.id.RegistrationButton);
        RegQuestion = findViewById(R.id.RegistrationPageQuestion);

        RegQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        RegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = RegEmail.getText().toString().trim();
                String password = RegPass.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    RegEmail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    RegPass.setError("Password is required");
                }else{
                    loader.setMessage("Registration is in progress");
                    loader.setCanceledOnTouchOutside(false);
                    loader.show();
                    mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){
                                Intent intent = new Intent(RegistrationActivity.this,HomeActivity.class);
                                startActivity(intent);

                                loader.dismiss();
                            }else {
                                String error = task.getException().toString();
                                Toast.makeText(RegistrationActivity.this,"Registration failed"+error,Toast.LENGTH_SHORT).show();
                                loader.dismiss();
                            }

                        }
                    });
                }


            }
        });
    }


}