package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button gowhere,eatwhere;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        gowhere=(Button)findViewById(R.id.gowhere);
        eatwhere=(Button)findViewById(R.id.eatwhere);

        gowhere.setOnClickListener(myListener);
        eatwhere.setOnClickListener(myListener);
    }

    private Button.OnClickListener myListener = new Button.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            switch (v.getId())
            {
                case R.id.gowhere:
                {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this,gowhereact.class);
                    startActivity(intent);
                    break;
                }
                case R.id.eatwhere:
                {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this,eatwhereact.class);
                    startActivity(intent);
                    break;
                }
            }
        }
    };
}
