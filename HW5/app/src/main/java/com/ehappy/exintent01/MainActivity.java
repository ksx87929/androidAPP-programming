package com.ehappy.exintent01;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText web,phone ;
    Button btnweb,btncall,btncalcu,btnmycalcu,btnperson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        web = (EditText) findViewById(R.id.web);
        phone = (EditText) findViewById(R.id.phone);


        btnweb = (Button) findViewById(R.id.btnweb);
        btncall = (Button) findViewById(R.id.btnCall);
        btncalcu = (Button) findViewById(R.id.calculater);
        btnmycalcu= (Button) findViewById(R.id.mycalculater);
        btnperson= (Button) findViewById(R.id.person);


        // 取得介面元件


        // 設定 button 元件 Click 事件共用 myListener
        btnweb.setOnClickListener(myListener);
        btncall.setOnClickListener(myListener);
        btncalcu.setOnClickListener(myListener);
        btnmycalcu.setOnClickListener(myListener);
        btnperson.setOnClickListener(myListener);
        // 檢查授權
        requestPermission();
    }

    // 檢查授權
    private void requestPermission() {
        if (Build.VERSION.SDK_INT >= 23) {  // Androis 6.0 以上
            // 判斷是否已取得授權
            int hasPermission = ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
            if (hasPermission != PackageManager.PERMISSION_GRANTED) {  // 未取得授權
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE}, 1);
            }
        }
        // 如果裝置版本是 Androis 6.0 以下，
        // 或是裝置版本是6.0（包含）以上，使用者已經授權
        // 允許執行程式
    }
    // 使用者完成授權的選擇以後，會呼叫 onRequestPermissionsResult 方法
    //     第一個參數：請求授權代碼
    //     第二個參數：請求的授權名稱
    //     第三個參數：使用者選擇授權的結果
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {  //按 拒絕 鈕
                Toast.makeText(this, "未取得授權！", Toast.LENGTH_SHORT).show();
                finish();  //結束應用程式
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    // 定義 onClick() 方法
    private Button.OnClickListener myListener = new Button.OnClickListener() {
        public void onClick(View v)
        {
            switch (v.getId())
            {
                case R.id.btnweb:
                {
                    Uri uri = Uri.parse(web.getText().toString());
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                    break;
                }
                case R.id.calculater:
                {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName("com.android.calculator2","com.android.calculator2.Calculator" ));
                    startActivity(intent);
                    break;
                }
                case R.id.btnCall:
                {
                    Uri uri = Uri.parse("tel:"+phone.getText().toString());
                    Intent intent = new Intent(Intent.ACTION_CALL, uri);
                    //  確認 CALL_PHONE 權限是否已授權
                    if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED)
                    {
                        startActivity(intent);
                    }
                    break;
                }
                case R.id.mycalculater:
                {
                    Intent intent=new Intent();
                    intent.setClass(MainActivity.this,mycalculater.class);
                    intent.setComponent(new ComponentName("com.example.myapplication1","com.example.myapplication1.MainActivity" ));
                    startActivity(intent);
                    break;
                }
                case R.id.person:
                {
                    Intent intent=new Intent();
                    //intent.setClass(MainActivity.this,myperson.class);
                    intent.setComponent(new ComponentName("com.ehappy.excheckbox01","com.ehappy.excheckbox01.MainActivity" ));
                    startActivity(intent);
                    break;
                }
            }
        }
    };
}
