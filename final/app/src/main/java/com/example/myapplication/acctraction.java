package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class acctraction extends AppCompatActivity {
    Double[] longitudes={120.454537,120.452038, 120.465724, 120.450922, 120.292796,
            120.480338,120.510460, 120.454669, 120.448463, 120.551107};
    Double[] latitudes={23.485703,23.485945,23.483556, 23.475000,23.473279,
            23.553204,23.583440,23.487284,23.512581,23.586841};
    String[] acommentlist={"4.2","4.1","4.2","4.3","4.1","4.2","3.9","4.0","3.7","3.8"};
    String[] alist={"檜意森活村 Hinoki Village","阿里山森林鐵路車庫園區","嘉義公園","文化公園","國立故宮博物院南部院區",
            "旺萊山鳳梨文化園區","老楊方城市觀光工廠","沉睡森林主題公園","月桃故事館","梅子元氣館"};
    String[] aaddresslist={"嘉義市東區林森東路1號","嘉義市東區林森西路2號","嘉義市東區啟明路264號","嘉義市東區興中街","嘉義縣太保市故宮大道888號",
            "嘉義縣民雄鄉三興村陳厝寮1-3號","嘉義縣大林鎮大埔美園區五路3號","嘉義市東區共和路239號","嘉義市東區保忠一街359 號","嘉義縣梅山鄉台3線440號"};
    String[] phonelist={"052761601","052779843","052744019","no","053620777",
            "052720696","052950520","no","052766399","052620800"};
    String[] weblist={"https://www.hinokivillage.com.tw/",
            "https://afrch.forest.gov.tw/",
            "https://www.chiayi.gov.tw/Default.aspx",
            "no",
            "https://south.npm.gov.tw/index.aspx",
            "http://www.pineapplehill.com.tw/about.php",
            "https://www.tkfood.com.tw/",
            "no",
            "https://www.sgsh.com.tw/",
            "http://www.plummyume.com.tw/",};
    int temporder=0;
    Button aweb,acall,alocation,commentbtn;
    TextView aname,aaddress,acomment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attractionxml);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        int a_num=bundle.getInt("A");
        temporder=a_num;

        commentbtn=(Button)findViewById(R.id.attcomment);
        acomment=(TextView)findViewById(R.id.acomment);
        alocation=(Button)findViewById(R.id.alocation);
        aweb=(Button)findViewById(R.id.aweb);
        acall=(Button)findViewById(R.id.acall);
        aname=(TextView)findViewById(R.id.aname);
        aaddress=(TextView)findViewById(R.id.aaddress);

        commentbtn.setOnClickListener(amylistener);
        alocation.setOnClickListener(amylistener);
        aweb.setOnClickListener(amylistener);
        acall.setOnClickListener(amylistener);
        aname.setText(alist[temporder]);
        aaddress.setText(aaddresslist[temporder]);
        acomment.setText("評價 : "+acommentlist[temporder]+" 顆星");

        requestPermission();
    }
    private void requestPermission()
    {
        if (Build.VERSION.SDK_INT >= 23)
        {  // Androis 6.0 以上
            // 判斷是否已取得授權
            int hasPermission = ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
            if (hasPermission != PackageManager.PERMISSION_GRANTED) {  // 未取得授權
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
            }
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
    {
        if (requestCode == 1)
        {
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED)
            {  //按 拒絕 鈕
                Toast.makeText(this, "未取得授權！", Toast.LENGTH_SHORT).show();
                finish();  //結束應用程式
            }
        }
        else
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
    private Button.OnClickListener amylistener = new Button.OnClickListener() {
        public void onClick(View v)
        {
            switch (v.getId())
            {
                case R.id.acall:
                {
                    if(phonelist[temporder]=="no")
                    {
                        Toast toast=Toast.makeText(acctraction.this, "此店家沒有提供連絡電話。", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.BOTTOM, 0, 0);
                        toast.show();
                    }
                    else
                    {
                        Uri uri = Uri.parse("tel:" + phonelist[temporder]);
                        Intent intentcall = new Intent(Intent.ACTION_CALL, uri);
                        //  確認 CALL_PHONE 權限是否已授權
                        if (ActivityCompat.checkSelfPermission(acctraction.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED)
                            startActivity(intentcall);
                    }
                    break;
                }
                case R.id.aweb:
                {
                    if (weblist[temporder]=="no")
                    {
                        Toast toast=Toast.makeText(acctraction.this, "此店家沒有官方網站。", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.BOTTOM, 0, 0);
                        toast.show();
                    }
                    else
                    {
                        Uri uri = Uri.parse(weblist[temporder]);
                        Intent intentweb = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intentweb);
                    }
                    break;
                }
                case R.id.alocation:
                {
                    Intent intentlocation = new Intent();
                    intentlocation.setClass(acctraction.this,MapsActivity.class);

                    Bundle bundlemap=new Bundle();
                    bundlemap.putDouble("longi",longitudes[temporder]);
                    bundlemap.putDouble("lati",latitudes[temporder]);
                    intentlocation.putExtras(bundlemap);

                    startActivity(intentlocation);
                    break;
                }
                case R.id.attcomment:
                {
                    Uri uri = Uri.parse("https://lin.ee/RdVRKF7");
                    Intent intentweb = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intentweb);
                }
            }
        }
    };
}
