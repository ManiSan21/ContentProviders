package com.example.mani.contentproviders;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ImagenActivity extends AppCompatActivity {

    private ImageView ivImagen;
    private String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen);

        Bundle bundle = getIntent().getExtras();
        nombre = bundle.getString("nombre");
        ivImagen = (ImageView)findViewById(R.id.ivImagen);

        mostrarImagen(nombre);
    }

    public void mostrarImagen(String name){
        Bitmap bp;
        if(!name.equals("")){
            bp = BitmapFactory.decodeFile(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath() + "/Screenshots/" + name);
            ivImagen.setImageBitmap(bp);
        }
    }
}
