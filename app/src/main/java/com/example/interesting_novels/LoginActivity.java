package com.example.interesting_novels;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {
    private EditText PassInput;
    private CheckBox ShowPass;
    EditText username ,password ;
    Button btnLogin;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
       // getSupportActionBar().hide();
        username=(EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btnLogin=(Button) findViewById(R.id.btn_1);
        PassInput = findViewById(R.id.password);
        ShowPass = findViewById(R.id.showPass);
        ShowPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ShowPass.isChecked()){
                    //Saat Checkbox dalam keadaan Checked, maka password akan di tampilkan
                    PassInput.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    //Jika tidak, maka password akan di sembuyikan
                    PassInput.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        TextView btnRegister = findViewById(R.id.txt_daftar);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perintah Intent Explicit pindah halaman ke activity_detail
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameKey=username.getText().toString();
                String passwordKey=password.getText().toString();
                if(usernameKey.equals("user@gmail.com")&& passwordKey.equals("12345678")) {
                    //jika login berhasil
                    Toast.makeText(getApplicationContext(), "Login Sukses", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, TampilanActivity.class);
                    LoginActivity.this.startActivity(intent);
                    finish();
                }else if(usernameKey.equals("admin@gmail.com")&& passwordKey.equals("12345678")){
                    //jika login berhasil
                    Toast.makeText(getApplicationContext(),"Login Sukses", Toast.LENGTH_SHORT).show();
                    Intent intent =new Intent(LoginActivity.this,tampilan1.class);
                    LoginActivity.this.startActivity(intent);
                    finish();
                }else {
                    //jika gagal
                    AlertDialog.Builder builder=new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage("Email atau Password Anda Salah!").setNegativeButton("Kembali",null).create().show();
                }

            }
        });

}
    }


