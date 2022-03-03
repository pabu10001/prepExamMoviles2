package com.example.notificacionbasica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button botonNotificacion;
    NotificationCompat.Builder notificacion;

    private static final String CHANNEL_ID = "Notificaion";
    private static final int NOTIFICACION_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonNotificacion = findViewById(R.id.btnNotificacion);

        botonNotificacion.setOnClickListener(v -> {
            createNotificationChannel();
            createNotificacion();

        });
    }

    public void createNotificacion(){
        notificacion = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID);
        notificacion.setSmallIcon(R.drawable.ic_baseline_whatshot_24);
        notificacion.setContentTitle("Notificacion Propia");
        notificacion.setContentText("Voy a sacar un 10 en el examen");
        notificacion.setColor(Color.RED);
        notificacion.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        notificacion.setVibrate(new long[]{1000, 1000});
        notificacion.setDefaults(Notification.DEFAULT_SOUND);
        NotificationManagerCompat notificationManagerCompat =
                NotificationManagerCompat.from(getApplicationContext());
        notificationManagerCompat.notify(NOTIFICACION_ID,notificacion.build());
    }

    private void createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "Notificacion";
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}