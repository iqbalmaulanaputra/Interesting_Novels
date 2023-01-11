package com.example.interesting_novels;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class update extends AppCompatActivity {
    DrawerLayout drawerLayout;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);
        drawerLayout =findViewById(R.id.drawer_layer3);
    }
    public void ClickMenu(View view){
        tampilan1.openDrawer(drawerLayout);
    }
    public void ClickLogo(View view){
        tampilan1.closeDrawer(drawerLayout);
    }
    public void Clickhome(View view){
        tampilan1.redirectActivity(this,tampilan1.class);
    }
    public void ClickUpdate(View view){
        recreate();
    }
    public void ClickLogout(View view){
        tampilan1.logout(this);
    }
}
