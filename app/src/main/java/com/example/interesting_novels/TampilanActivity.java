package com.example.interesting_novels;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


public class TampilanActivity extends AppCompatActivity {
    ListView listView;

    String[] names ={"Perahu Kertas","Ruang Sunyi","Ayah","Tentang Rasa","Senja","Surat Tentang kita","Laut Tengah","179 Hari"};
   int[] imageId={R.drawable.novels, R.drawable.novel, R.drawable.novel1, R.drawable.novel2, R.drawable.novel3, R.drawable.novel4,
           R.drawable.novel5, R.drawable.novel6};
    DrawerLayout drawerLayout;
    ArrayAdapter<String>arrayAdapter;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tampilan);
       //getSupportActionBar().hide();
        drawerLayout =findViewById(R.id.drawer_layer);

        listView=findViewById(R.id.listView);
        arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);
        listView.setAdapter(arrayAdapter);

        CustomAdapter customAdapter= new CustomAdapter();
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent= new Intent(getApplicationContext(),LisdataActivity.class);
                intent.putExtra("name", names[i]);
                intent.putExtra("image",imageId[i]);
                startActivity(intent);
            }
        });
}

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return imageId.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1= getLayoutInflater().inflate(R.layout.list_item,null);

            TextView name=view1.findViewById(R.id.novel);
            ImageView image=view1.findViewById(R.id.images1);

            name.setText(names[i]);
            image.setImageResource(imageId[i]);

            return view1;
        }
    }
    public void ClickMenu(View view){
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void Clickhome(View view){
        recreate();
    }
    public void ClickTentang(View view){
        redirectActivity(this,tentag.class);
    }

    public void ClickLogout(View view){
        logout(this);
    }

    public static void logout(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Logout");
        builder.setMessage("Yakin Mau Keluar?");
        builder.setPositiveButton("Iya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                activity.finishActivity(0);
                System.exit(0);
            }
        });
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
             //   dialogInterface.dismiss();
            }
        });
        builder.show();
    }
    public static void redirectActivity(Activity activity, Class aClass){
        Intent intent=new Intent(activity,aClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }
    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
}
