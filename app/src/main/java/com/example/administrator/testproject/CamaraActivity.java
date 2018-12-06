package com.example.administrator.testproject;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CamaraActivity extends AppCompatActivity {

    private HandlerThread mCameraThread;
    private Handler mCameraHandle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camara);
    }

    private void startCameraThread() {
        mCameraThread = new HandlerThread("CamaraThread");
        mCameraThread.start();
        mCameraHandle = new Handler(mCameraThread.getLooper());
    }

    private void setupCamera(int width, int height) {
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try {
            String[] ids = cameraManager.getCameraIdList();
            for (String id : ids) {
                CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(id);

            }

        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

    }
}
