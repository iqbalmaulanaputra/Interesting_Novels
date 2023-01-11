package com.example.interesting_novels;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class tentag extends AppCompatActivity {
    DrawerLayout drawerLayout;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tentang);
        drawerLayout =findViewById(R.id.drawer_layer2);
}
    public void ClickMenu(View view){
        TampilanActivity.openDrawer(drawerLayout);
    }
    public void Clickhome(View view){
        TampilanActivity.redirectActivity(this,TampilanActivity.class);
    }
    public void ClickLogo(View view){
        TampilanActivity.closeDrawer(drawerLayout);
    }

    public void ClickTentang(View view){
        recreate();
    }
    public void ClickLogout(View view){
        TampilanActivity.logout(this);
    }
    @Override
    protected void onPause() {
        super.onPause();
        TampilanActivity.closeDrawer(drawerLayout);
}
}
