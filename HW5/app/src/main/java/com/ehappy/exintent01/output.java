package com.ehappy.exintent01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class output extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.output);

        TextView txtShow = (TextView) findViewById(R.id.txtShow);
        Button btnHome = (Button) findViewById(R.id.btnHome);

        // 設定 button 的 Listener
        btnHome.setOnClickListener(btnHomeListener);

        // 取得 bundle
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        String row1 = bundle.getString("A");
        String row2 = bundle.getString("B");
        String row3 = bundle.getString("C");
        String row4 = bundle.getString("D");
        String row5 = bundle.getString("E");
        String row6 = bundle.getString("F");

        String s = "姓名：" + row1 + "\n" +
                "學號：" + row2 + "\n" +
                "學院：" + row3 + "\n" +
                "系級：" + row5 + "\n" +
                "年級：" + row4 + "\n" +
                "系隊：" + row6 + "\n";
        txtShow.setText(s);
    }

    private Button.OnClickListener btnHomeListener = new Button.OnClickListener() {
        public void onClick(View v) {
            finish();
        }
    };
}
