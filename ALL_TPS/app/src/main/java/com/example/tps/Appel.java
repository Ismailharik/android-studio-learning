package com.example.tps;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class Appel extends AppCompatActivity implements OnClickListener {

    EditText edittext1;
    Button button1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tp_appel);
        edittext1 = findViewById(R.id.editText1);
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        String number = edittext1.getText().toString();
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + number));
//        if (ActivityCompat.checkSelfPermission(this,
//                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//            return;
//        }
        startActivity(callIntent);
    }
}
