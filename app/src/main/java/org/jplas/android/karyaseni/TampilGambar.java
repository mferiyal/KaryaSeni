package org.jplas.android.karyaseni;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class TampilGambar extends AppCompatActivity {

    ImageView imgplaceholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_gambar);
        imgplaceholder = findViewById(R.id.imgplaceholder);
        Intent intent = getIntent();
        //intent.getExtras();
        Bitmap imageBitmap = (Bitmap) intent.getExtras().get("data");
        imgplaceholder.setImageBitmap(imageBitmap);
    }
}
