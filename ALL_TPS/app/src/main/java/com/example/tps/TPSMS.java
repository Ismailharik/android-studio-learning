package com.example.tps;

import android.app.AlertDialog;
import android.content.ContentProviderClient;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TPSMS extends AppCompatActivity implements OnClickListener {
    EditText edittext1; Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tp_sms);
        edittext1 = (EditText) findViewById(R.id.editText1);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
    }
    @Override
    public void onClick(View arg0) {
        String number = edittext1.getText().toString();
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(
                "tel:0706764587",
                null,
                "sms message ANDROID",
                null,
                null
        );
        showMessage("Status", "message send seccussfuly");
    }

    private void showMessage(String title, String message) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }


}
