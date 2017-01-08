package com.example.kimanikogi.study;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Others extends AppCompatActivity {
private  String [] title={"Qroup Assignments","Upload ","view TimeTble","Revision Questions","Scan"};
    private  String [] mesg={"View Done Group work","Upload Your groups ass","view Exam TimeTble","Revise with these quick sample question","Scan Documents"};
    private  String [] id={"1","2","3","4","5"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others);


        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for (int i = 0; i <= 4; i++) {
            HashMap<String, String> hash = new HashMap<String, String>();
            hash.put("coun", title[i]);
            hash.put("cap",mesg[i]);
            hash.put("id",id[i]);
            aList.add(hash);
        }
        //keys used in the hashmap
        String[] from = {"coun","cap","id"};

        //ids of textviews in layoutview
        int[] to = {R.id.textView1,R.id.textView2,R.id.textView3};

        SimpleAdapter adapt = new SimpleAdapter(getBaseContext(), aList, R.layout.listitem, from, to);

        ListView list = (ListView)findViewById(R.id.list);

        list.setAdapter(adapt);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView idtxt=(TextView)view.findViewById(R.id.textView3);
                TextView t=(TextView)view.findViewById(R.id.textView1) ;
           int n=Integer.valueOf(idtxt.getText().toString())      ;
                 if(n==1){

                     Intent two=new Intent(Others.this, ViewAss.class);
                     startActivity(two);

                 }
                else if(n==2){
                     Intent two=new Intent(Others.this, File.class);
                     startActivity(two);

                 }
                 else if(n==3){

                     Intent two=new Intent(Others.this, timetable.class);
                     startActivity(two);
                 }
                 else if(n==4){

                     Intent two=new Intent(Others.this, quiz.class);
                     startActivity(two);


                 }
                 else if(n==5){

                     Intent two=new Intent(Others.this, Extras.class);
                     startActivity(two);


                 }
            }
        });
    }
}
