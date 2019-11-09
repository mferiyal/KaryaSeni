package org.jplas.android.karyaseni;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    Button buttonambilgambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        buttonambilgambar = findViewById(R.id.btn_ambil_gambar);
        buttonambilgambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isDeviceSupportCamera()){
                    Toast.makeText(getApplicationContext(), "Camera di device anda tidak tersedia ", Toast.LENGTH_LONG).show();
                }else{
                    captureImage();
                }
            }
        });




    }
    private boolean isDeviceSupportCamera(){
        if(getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            //this device has a camera
            return true;
        }else {
            return false;
        }
    }

    private void captureImage() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //Intent cameraIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        //cameraIntent.setType("image/*");

        if (takePictureIntent.resolveActivity(getPackageManager()) != null)
        {
            startActivityForResult(takePictureIntent, 100);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
//            Uri returnUri;
//            returnUri = data.getData();
            Intent intent = new Intent(this, TampilGambar.class);
            //intent.putExtra("imageuri",returnUri.toString());
            intent.putExtras(extras);
            startActivity(intent);
        }
    }
}
