package com.boston.mindreader.trial;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Random;

public class TextPlay extends Activity implements View.OnClickListener{
    Button chkCmd;
    ToggleButton passTog;
    EditText input;
    TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_play);
        initializer();
    }
    private void initializer(){
        chkCmd=(Button)findViewById(R.id.btnResults);
        passTog=(ToggleButton) findViewById(R.id.tbtnPassword);
        input=(EditText) findViewById(R.id.etCommands);
        display=(TextView) findViewById(R.id.tvResults);
        passTog.setOnClickListener(this);
        chkCmd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnResults:
                String check=input.getEditableText().toString();
                display.setText(check);
                if(check.contentEquals("left")){
                    display.setGravity(Gravity.LEFT);
                }else if(check.contentEquals("center")){
                    display.setGravity(Gravity.CENTER);
                }else if(check.contains("random")){
                    Random crazy = new Random();
                    display.setText("Random Play");
                    display.setTextSize(crazy.nextInt(75));
                    display.setTextColor(Color.rgb(crazy.nextInt(265),crazy.nextInt(265),crazy.nextInt(265)));
                    switch (crazy.nextInt(3)){
                        case 0:
                            display.setGravity(Gravity.LEFT);
                            break;
                        case 1:
                            display.setGravity(Gravity.CENTER);
                            break;
                        case 2:
                            display.setGravity(Gravity.RIGHT);
                            break;
                    }
                }else if(check.contentEquals("right")){
                    display.setGravity(Gravity.RIGHT);
                }else {
                    display.setText("Invalid");
                    display.setGravity(Gravity.CENTER);
                    display.setTextColor(Color.RED);
                }

                break;

            case R.id.tbtnPassword:
                if(passTog.isChecked()){
                    input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    passTog.setText("SHOW");
                }else{
                    input.setInputType(InputType.TYPE_CLASS_TEXT);
                    passTog.setText("HIDE");
                }
                break;
        }
    }
}
