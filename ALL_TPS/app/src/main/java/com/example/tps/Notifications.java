package com.example.tps;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class Notifications extends AppCompatActivity {
    Button b1, b2, b3, b5, b6, b7;
    public static final String CHANNEL_ID = "x_channelId";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications);
        initializeButtons();

        longMessage();
        shortMessage();
        notification();
        alertOneOption();
        alertTwoOptions();
        alertAdvancedTwoOptions();


    }

    private void alertAdvancedTwoOptions() {
        b6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog.Builder adb = new
                        AlertDialog.Builder(Notifications.this);
                adb.setMessage("Message");
                adb.setPositiveButton("OUI",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int
                                    arg1) {
                                Toast.makeText(Notifications.this, "clic sur OK", Toast.LENGTH_LONG).show();
                            }
                        });
                adb.setNegativeButton("NON",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int
                                    arg1) {
                                // finish();
                                Toast.makeText(Notifications.this, "clic sur  Non donc finish", Toast.LENGTH_LONG).show();
                            }
                        });
                AlertDialog alert = adb.create();
                alert.show();
            }
        });
    }

    private void alertTwoOptions() {
        b6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog.Builder adb = new
                        AlertDialog.Builder(Notifications.this);
                adb.setMessage("Message");
                adb.setPositiveButton("OUI",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int
                                    arg1) {
                                Toast.makeText(Notifications.this, "clic sur OK", Toast.LENGTH_LONG).show();
                            }
                        });
                adb.setNegativeButton("NON",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int
                                    arg1) {
                                // finish();
                                Toast.makeText(Notifications.this, "clic sur Non donc finish", Toast.LENGTH_LONG).show();
                            }
                        });
                AlertDialog alert = adb.create();
                alert.show();
            }
        });
    }

    private void alertOneOption() {
        b5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog.Builder adb = new
                        AlertDialog.Builder(Notifications.this);
                adb.setMessage("Message");
                adb.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int
                                    arg1) {
                                Toast.makeText(Notifications.this, "clic sur OK", Toast.LENGTH_LONG).show();
                            }
                        });
                AlertDialog alert = adb.create();
                alert.show();
            }
        });
    }

    private void notification() {
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SendNotification();
            }
        });
    }

    private void shortMessage() {
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(Notifications.this, "Message short", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void longMessage() {
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(Notifications.this, "Message long", Toast.LENGTH_LONG).show();
            }
        });
    }


    private void initializeButtons() {
        //Link Buttons with the view
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
    }

    private void SendNotification() {
        // check this video for more explanation https://www.youtube.com/watch?v=uzQiBUJhq24&ab_channel=%D9%85.%D8%AC%D8%B9%D9%81%D8%B1%D9%85%D8%AD%D9%85%D8%AF%D8%A7%D9%84%D8%A3%D8%BA%D8%A7
        // create notification channel

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "CHANNEL display name",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            channel.setDescription("my channel description");
            NotificationManager nm = getSystemService(NotificationManager.class);
            nm.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new
                NotificationCompat.Builder(getBaseContext(), CHANNEL_ID);
        builder
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.notificfication_icon)
                .setTicker("Formation Android")
                .setContentTitle("Notification")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentText("bonjour mes collegues je suis heureux d'etre avec vous :).")
                .setContentInfo("INFO");

        NotificationManagerCompat nm = NotificationManagerCompat.from(this);

        nm.notify(10, builder.build());// while you see compiler error just run it works
    }
}
