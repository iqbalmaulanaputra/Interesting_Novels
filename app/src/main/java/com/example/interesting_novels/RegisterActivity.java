package com.example.interesting_novels;

import static com.example.interesting_novels.R.id.txt_login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    Spinner s;
    String[] Gender={"PILIH","Laki-Laki","Perempuan"};
    private EditText PassInput1;
    private CheckBox ShowPass1;
    private EditText PassInput2;
    private CheckBox ShowPass2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
       // getSupportActionBar().hide();

        s=(Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item
                ,Gender);
        s.setAdapter(adapter);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int index= s.getSelectedItemPosition();
                Toast.makeText(getBaseContext(),"You have selected item 1: "+Gender[index],
                        Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        PassInput1 = findViewById(R.id.password1);
        ShowPass1 = findViewById(R.id.showPassword1);
        PassInput2 = findViewById(R.id.pass2);
        ShowPass2 = findViewById(R.id.showPass2);

        Button btnREGISTER = findViewById(R.id.btn_2);
        btnREGISTER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, TampilanActivity.class));
            }

        });

        TextView btnRegister = findViewById(R.id.txt_login);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perintah Intent Explicit pindah halaman ke activity_detail
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
        ShowPass1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ShowPass1.isChecked()){
                    //Saat Checkbox dalam keadaan Checked, maka password akan di tampilkan
                    PassInput1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    //Jika tidak, maka password akan di sembuyikan
                    PassInput1.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        ShowPass2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ShowPass2.isChecked()){
                    //Saat Checkbox dalam keadaan Checked, maka password akan di tampilkan
                    PassInput2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    //Jika tidak, maka password akan di sembuyikan
                    PassInput2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }
}
