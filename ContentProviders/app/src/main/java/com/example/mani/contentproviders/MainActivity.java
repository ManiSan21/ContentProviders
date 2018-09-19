package com.example.mani.contentproviders;

import android.content.Intent;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private ListView lvlistaImagenes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvlistaImagenes = (ListView)findViewById(R.id.lvListaImagenes);
        obtenerArchivos();
        lvlistaImagenes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nombre = lvlistaImagenes.getItemAtPosition(position).toString();
                mandarImagen(nombre);
            }
        });
    }

    public void obtenerArchivos(){
        File folder = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Screenshots");
        File[] listOfFiles = folder.listFiles();
        if(listOfFiles != null)
        {
            String[] myArray;

            myArray = new String[listOfFiles.length];

            for (int x = 0; x < myArray.length; x++)
                if (listOfFiles[x].isFile())
                    myArray[x] = listOfFiles[x].getName();

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myArray);
            lvlistaImagenes.setAdapter(adapter);
        }
    }

    public void mandarImagen(String nombre){
        Intent intent = new Intent(this, ImagenActivity.class);
        intent.putExtra("nombre", nombre);
        startActivity(intent);
    }
}
