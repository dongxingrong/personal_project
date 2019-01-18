package com.example.administrator.testproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Camera2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera2);

        getSupportFragmentManager().beginTransaction().add(R.id.contentFrame, CameraFragment.newInstance()).commit();
    }
}
