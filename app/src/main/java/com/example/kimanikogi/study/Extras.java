package com.example.kimanikogi.study;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Extras extends AppCompatActivity {

    final int CAMERA_CAPTURE = 1;
    private Uri picUri;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private GridView grid;
    private List<String> listOfImagesPath;

    public static final String GridViewDemo_ImagePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Study/";

    ImageView img;
    Button btn;
    Button clear;
    Button detect;
   TextView textt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extras);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Toast.makeText(Extras.this, "This Option is still underdevelopment thus may not work well on some device\n" , Toast.LENGTH_LONG).show();
        btn=(Button)findViewById(R.id.capture);
        clear=(Button)findViewById(R.id.clear);
        detect=(Button)findViewById(R.id.detect);

         img=(ImageView) findViewById(R.id.image);
         textt=(TextView) findViewById(R.id.text);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
//use standard intent to capture an image
                    Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//we will handle the returned data in onActivityResult
                    startActivityForResult(captureIntent, CAMERA_CAPTURE);
                } catch(ActivityNotFoundException anfe){
//display an error message
                    String errorMessage = "Whoops - your device doesn't support capturing images!";
                    // Toast toast = Toast.makeText(this.MainActivity, errorMessage, LENGTH_SHORT);
                    //  toast.show();
                    Toast.makeText(Extras.this, "GridView Item: " +errorMessage, Toast.LENGTH_LONG).show();
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textt.setText("");
                img.setImageBitmap(null);
            }
        });
detect.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        if(thePic!=null) {
            detectText(thePic);
        }else {
            Toast.makeText(Extras.this, "Capture the document first" , Toast.LENGTH_LONG).show();
        }
    }
});
    }
    public void detectText(Bitmap thePic) {
      //  Bitmap textBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat);
        Bitmap textBitmap = thePic;
        TextRecognizer textRecognizer = new TextRecognizer.Builder(this).build();

        if (!textRecognizer.isOperational()) {
            new AlertDialog.Builder(this)
                    .setMessage("Text recognizer could not be set up on your device :(")
                    .show();
            return;
        }

        Frame frame = new Frame.Builder().setBitmap(textBitmap).build();
        SparseArray<TextBlock> text = textRecognizer.detect(frame);

        for (int i = 0; i < text.size(); ++i) {
            TextBlock item = text.valueAt(i);
            if (item != null && item.getValue() != null) {
                textt.setText(item.getValue());
                //text.setText(item.getValue());
            }
            else if(item == null||item.getValue() == null){
                Toast.makeText(Extras.this,"JFG",Toast.LENGTH_SHORT).show();
//                new AlertDialog.Builder(this)
//                        .setMessage("Text recognizer could not find text try to focus :(")
//                        .show();
            }
        }
    }
    Bitmap thePic;
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
//user is returning from capturing an image using the camera
            if(requestCode == CAMERA_CAPTURE){
                Bundle extras = data.getExtras();
                 thePic = extras.getParcelable("data");
                String imgcurTime = dateFormat.format(new Date());
                File imageDirectory = new File(GridViewDemo_ImagePath);
                imageDirectory.mkdirs();
                String _path = GridViewDemo_ImagePath + imgcurTime+".jpg";
                  img.setImageBitmap(thePic);


               /* try {

                    FileOutputStream out = new FileOutputStream(_path);
                    thePic.compress(Bitmap.CompressFormat.JPEG, 90, out);
                    out.close();

                } catch (FileNotFoundException e) {
                    e.getMessage();

                } catch (IOException e) {
                    e.printStackTrace();

                }*/
               // listOfImagesPath = null;
              //  listOfImagesPath = RetriveCapturedImagePath();
               // if(listOfImagesPath!=null){
               //     grid.setAdapter(new ImageListAdapter(this,listOfImagesPath));
               // }
            }
        }
    }
    public  void calldetect(){
        detectText(thePic);

    }


}
