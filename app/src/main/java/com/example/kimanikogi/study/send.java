package com.example.kimanikogi.study;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class send extends AppCompatActivity {
    EditText em;
    EditText me;
    EditText na;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        Button bm = (Button) findViewById(R.id.btnm);
        em = (EditText) findViewById(R.id.email);
        me = (EditText) findViewById(R.id.message);
        na = (EditText) findViewById(R.id.name);
        bm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSMSessage();
            }
        });
    }


    protected void sendSMSessage() {
        if(TextUtils.isEmpty(me.getText())){
            Toast.makeText(this, "Enter Messege", Toast.LENGTH_SHORT).show();
        }
        try {
        Log.i("Send SMS", "");
        String phoneno = "0714406984";

        String mess = em.getText().toString();
        String mes = me.getText().toString();
        String nam = na.getText().toString();
        String fm ="From :"+ mess + "  \n Name :"+nam+" \n   said :" + mes;

            SmsManager smsManager = SmsManager.getDefault();

            smsManager.sendTextMessage(phoneno, null, fm, null, null);
            //smsManager2.sendTextMessage (phoneno, null, "i used", null, null);
            Toast.makeText(getApplicationContext(), "Sms Sent", Toast.LENGTH_SHORT).show();
            em.setText(null);
            me.setText(null);
            na.setText(null);

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Sms failed", Toast.LENGTH_SHORT).show();
        }
    }
}