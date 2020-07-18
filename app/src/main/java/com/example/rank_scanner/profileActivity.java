package com.example.rank_scanner;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class profileActivity extends AppCompatActivity {
    ImageView allDocs , back,camera2;
    private static int REQUEST_CAMERA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Objects.requireNonNull(getSupportActionBar()).hide();
        allDocs=findViewById(R.id.all_docs);
        camera2=findViewById(R.id.camera2);
        back=findViewById(R.id.backtoMain);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBack();

            }
        });
        allDocs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBack();
            }
        });
        camera2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                    showCameraPerview();
                }
                else{
                    if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
                        Toast.makeText(profileActivity.this, "Camera Permission Needed, You Nerd!", Toast.LENGTH_SHORT).show();
                    }
                    requestPermissions(new String[]{Manifest.permission.CAMERA},REQUEST_CAMERA);

                }
            }
        });
    }
    public void setBack (){
        Intent i = new Intent(profileActivity.this,MainActivity.class);
        startActivity(i);

    }
    private void showCameraPerview() {
        Intent i= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(i);
    }
}