package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class store extends AppCompatActivity {
    Double[] longitudes={120.477780, 120.461668, 120.478056, 120.474083, 120.463667,
                         120.465833, 120.453333, 120.463278, 120.467034, 120.467333,
                         120.459556, 120.448500, 120.444389, 120.450306};
    Double[] latitudes={23.464081,23.456268,23.463889, 23.473556,23.455944,
                        23.456083,23.469444,23.472250,23.477348,23.477167,
                        23.468306,23.483139,23.476306,23.478806};
    int[] menuimglist={R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,R.drawable.menu5,
                       R.drawable.menu6,R.drawable.menu7,R.drawable.menu8,R.drawable.menu9,R.drawable.menu10,
                       R.drawable.menu11,R.drawable.menu12,R.drawable.menu13,R.drawable.menu14};
    String[] storecommentlist={"4.0","4.2","4.1","4.3","4.3","4.2","4.2","4.7","3.7","4.5","4.4","4.0","4.1","4.2"};
    String[] storelist={"一番食堂","六年甲班","大熊滷味","翁媽媽","陳記客家牛肉麵",
                        "紅燒鴨肉飯","興加臭豆腐","幸福樹 季節廚房","八方雲集-嘉義大雅店","正統火雞肉飯",
                        "豆豆 小籠湯包、蒸餃", "新生早點","金御咖哩","林聰明沙鍋魚頭-創始總店"};
    String[] storeaddresslist={"嘉義市東區學府路312號","嘉義市東區軍輝路130號","嘉義市東區學府路311之2號","嘉義市東區小雅路","嘉義市東區軍輝路43號",
                               "嘉義縣中埔鄉和美路328號","嘉義市東區興業東路191號","嘉義市東區彌陀路327巷10號","嘉義市東區大雅路二段646號","嘉義市東區大雅路二段591號",
                               "嘉義市東區芳安路229號","嘉義市西區長榮街252號","嘉義市西區新榮路211號","嘉義市東區中正路361號"};
    String[] phonelist={"052766037","052300706","no","052758068","052393411",
                        "0933280170","052253890","052160668","052718289","052762679",
                        "052270292","052285477","052272382","052270661"};
    String[] weblist={"no","https://m.facebook.com/%E5%85%AD%E5%B9%B4%E7%94%B2%E7%8F%AD%E5%B9%B3%E5%83%B9%E7%BE%A9%E5%A4%A7%E5%88%A9%E9%BA%B5%E8%BB%8D%E8%BC%9D%E5%BA%97-142523872615499/?locale2=zh_TW","no","no","no",
                      "https://restaurant-85260.business.site/?utm_source=gmb&utm_medium=referral",
                      "https://www.facebook.com/pages/%E8%88%88%E5%8A%A0%E8%87%AD%E8%B1%86%E8%85%90/192557844121213",
                      "no",
                      "https://www.8way.com.tw/",
                      "no",
                      "https://www.facebook.com/pages/%E8%B1%86%E8%B1%86%E5%B0%8F%E7%B1%A0%E6%B9%AF%E5%8C%85/194654090576215",
                      "https://www.facebook.com/pages/%E5%B3%B0%E7%82%B8%E8%9B%8B%E9%A4%85/154233484633507",
                      "https://www.jinyucurry.com/",
                      "http://www.smartfish.com.tw/"};
    int temporder=0;
    Button web,call,location,menu,comment;
    TextView storename,storeaddress,storecomment;
    ImageView menuimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.storexml);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        int store_num=bundle.getInt("A");
        temporder=store_num;

        comment=(Button)findViewById(R.id.comment);
        storecomment=(TextView)findViewById(R.id.storecomment);
        menu=(Button)findViewById(R.id.menu);
        location=(Button)findViewById(R.id.loaction);
        web=(Button)findViewById(R.id.web);
        call=(Button)findViewById(R.id.call);
        storename=(TextView)findViewById(R.id.storename);
        storeaddress=(TextView)findViewById(R.id.storeaddress);
        menuimg=(ImageView)findViewById(R.id.menuimg);

        comment.setOnClickListener(mylistener);
        location.setOnClickListener(mylistener);
        web.setOnClickListener(mylistener);
        call.setOnClickListener(mylistener);
        storename.setText(storelist[temporder]);
        storeaddress.setText(storeaddresslist[temporder]);
        storecomment.setText("評價 : "+storecommentlist[temporder]+" 顆星");
        menu.setOnClickListener(mylistener);

        menuimg.setVisibility(View.GONE);


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
    private Button.OnClickListener mylistener = new Button.OnClickListener() {
        public void onClick(View v)
        {
            switch (v.getId())
            {
                case R.id.call:
                 {
                     if(phonelist[temporder]=="no")
                     {
                         Toast toast=Toast.makeText(store.this, "此店家沒有提供連絡電話。", Toast.LENGTH_LONG);
                         toast.setGravity(Gravity.BOTTOM, 0, 0);
                         toast.show();
                     }
                     else
                     {
                         Uri uri = Uri.parse("tel:" + phonelist[temporder]);
                         Intent intentcall = new Intent(Intent.ACTION_CALL, uri);
                         //  確認 CALL_PHONE 權限是否已授權
                         if (ActivityCompat.checkSelfPermission(store.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED)
                             startActivity(intentcall);
                     }
                    break;
                }
                case R.id.web:
                {
                    if (weblist[temporder]=="no")
                    {
                        Toast toast=Toast.makeText(store.this, "此店家沒有官方網站。", Toast.LENGTH_LONG);
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
                case R.id.loaction:
                {
                    Intent intentlocation = new Intent();
                    intentlocation.setClass(store.this,MapsActivity.class);

                    Bundle bundlemap=new Bundle();
                    bundlemap.putDouble("longi",longitudes[temporder]);
                    bundlemap.putDouble("lati",latitudes[temporder]);
                    intentlocation.putExtras(bundlemap);

                    startActivity(intentlocation);
                    break;
                }
                case R.id.menu:
                {
                    menuimg.setVisibility(View.VISIBLE);
                    menuimg.setImageResource(menuimglist[temporder]);
                }
                case  R.id.comment:
                {
                    Uri uri = Uri.parse("https://lin.ee/RdVRKF7");
                    Intent intentweb = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intentweb);
                }
            }
        }
    };

}
