package com.example.kimanikogi.study;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class about extends AppCompatActivity {
Button n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        TextView t2=(TextView)findViewById(R.id.link);
        t2.setMovementMethod(LinkMovementMethod.getInstance());
        n=(Button)findViewById(R.id.btnc);
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent two=new Intent(about.this, send.class);
                startActivity(two);
            }
        });

    }
}
