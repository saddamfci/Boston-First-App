package com.boston.mindreader.trial;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;

public class Camera extends Activity implements View.OnClickListener{
    ImageButton ibtn;
    Button btn;
    ImageView iv;
    Intent i;
    final static int cameraData=0;
    Bitmap bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo);
        initialize();
        iv.setOnClickListener(this);
        ibtn.setOnClickListener(this);
    }
    private void initialize(){
        iv=(ImageView)findViewById(R.id.ivReturned);
        ibtn=(ImageButton)findViewById(R.id.ibtnTakePic);
        btn=(Button)findViewById(R.id.btnSetWall);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSetWall:

                break;
            case R.id.ibtnTakePic:
                i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, cameraData);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_OK){
            Bundle extras = data.getExtras();
            bmp=(Bitmap)extras.get("data");
            iv.setImageBitmap(bmp);
        }
    }
}

