package com.example.permisos;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int CODIGO_RESPUESTA = 200;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verificarPermisos();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void verificarPermisos(){
        int permisoSMS = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);
        if (permisoSMS == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "Permiso SMS está activado", Toast.LENGTH_SHORT).show();
        }else{
            requestPermissions(new String[]{
                    Manifest.permission.SEND_SMS
            }, CODIGO_RESPUESTA);
        }
    }
}