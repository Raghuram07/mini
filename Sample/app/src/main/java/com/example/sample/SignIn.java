package com.example.sample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sample.databinding.ActivitySignInBinding;
import com.example.sample.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {


    ActivitySignInBinding binding;  //What is binding..?
    ProgressDialog progressDialog;
    FirebaseAuth myAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //Bundle containing previous frozen state.

        binding =ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //The content view point to the id of layout in the file activity.xml
        myAuth=FirebaseAuth.getInstance();
        progressDialog =new ProgressDialog(SignIn.this);
        progressDialog.setTitle("Logging in");
        progressDialog.setMessage("Please wait...");


        binding.LoginButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignIn.this,"login clicked", Toast.LENGTH_SHORT).show();
                progressDialog.show();
                myAuth.signInWithEmailAndPassword(binding.etemailId.getText().toString(),binding.etPassword.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressDialog.dismiss();
                                if(task.isSuccessful())
                                {
                                    Intent intent=new Intent(SignIn.this,Home.class);
                                    startActivity(intent);
                                }
                                else
                                {
                                    Toast.makeText(SignIn.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
       // if(myAuth.getCurrentUser()!=null)
       // {
       //     Intent intent=new Intent(SignIn.this,Home.class);
       //     startActivity(intent);
       // }
        Button button= (Button) findViewById(R.id.Btn_signUp);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(SignIn.this,SignUp.class));
            }
        });

    }
}