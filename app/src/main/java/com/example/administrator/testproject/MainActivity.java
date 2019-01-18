package com.example.administrator.testproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_image).setOnClickListener(this);
        findViewById(R.id.btn_surface).setOnClickListener(this);
        findViewById(R.id.btn_custom).setOnClickListener(this);
        findViewById(R.id.btn_camera_surface_view).setOnClickListener(this);

        DisplayMetrics dm = getResources().getDisplayMetrics();
        int screenWidth = dm.widthPixels;
        int screenHeight = dm.heightPixels;
        Log.i("MainActivity", "size:" + screenWidth + " " + screenHeight);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_image:
                startActivity(new Intent(this, ShowImage.class));
                break;

            case R.id.btn_surface:
                startActivity(new Intent(this, ShowSurface.class));
                break;

            case R.id.btn_custom:
                startActivity(new Intent(this, ShowCustomView.class));
                break;

            case R.id.btn_camera_surface_view:
//                startActivity(new Intent(this, SurfaceCameraActivity.class));
//                startActivity(new Intent(this, Main2Activity.class));
//                startActivity(new Intent(this, CameraSurfaceViewActivity.class));
                startActivity(new Intent(this, Camera2Activity.class));
                break;
        }

    }
}
