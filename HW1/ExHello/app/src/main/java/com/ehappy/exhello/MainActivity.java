package com.ehappy.exhello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button mybutton1;
    Button mybutton2;
    TextView mytext;
    int count=0;
    String Scount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mytext = findViewById(R.id.textview);
        mybutton1 = findViewById(R.id.button2);
        mybutton2 =findViewById(R.id.button3);
    }

   public void C1(View v)
    {
        //mytext.setText("= =");
        count=count+1;
        Scount=Integer.toString(count);
        mytext.setText(Scount);
    }
    public void C2(View v)
    {
        String sV = Integer.toString(0);
        mytext.setText(sV);
        count=0;
    }
}
