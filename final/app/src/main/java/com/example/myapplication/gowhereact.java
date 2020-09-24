package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class gowhereact extends AppCompatActivity {
    private int[] imageIds = {
            R.drawable.acctraction1,R.drawable.acctraction2,R.drawable.acctraction3,
            R.drawable.acctraction4,R.drawable.acctraction5,R.drawable.acctraction6,
            R.drawable.acctraction7,R.drawable.acctraction8,R.drawable.acctraction9,
            R.drawable.acctraction10
    };
    CheckBox achb1,achb2,achb3;
    GridView gridView;
    MyAdapter aadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gowherexml);

        gridView = (GridView) findViewById(R.id.gridview);
        achb1=(CheckBox)findViewById(R.id.achb1);
        achb2=(CheckBox)findViewById(R.id.achb2);
        achb3=(CheckBox)findViewById(R.id.achb3);

        achb1.setOnCheckedChangeListener(myListener);
        achb2.setOnCheckedChangeListener(myListener);
        achb3.setOnCheckedChangeListener(myListener);
        // 建立自訂的 Adapter
        aadapter=new MyAdapter(this);

        // 設定 GridView 的資料來源
        gridView.setAdapter(aadapter);

        // 建立 GridView 的 ItemClick 事件
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(gowhereact.this,acctraction.class);

                Bundle bundle=new Bundle();
                bundle.putInt("A",position);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
    private CheckBox.OnCheckedChangeListener myListener=new CheckBox.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            gridView.setAdapter(aadapter);
        }
    };
    class MyAdapter extends BaseAdapter {
        private Context mContext;
        public MyAdapter(Context c){
            mContext=c;
        }
        @Override
        public int getCount(){
            return imageIds.length; // 圖片共有多少張

        }
        @Override
        public Object getItem(int position){
            return position;
        }
        @Override
        public long getItemId(int position){
            return position; // 目前圖片索引
        }

        // 定義 GridView 顯示的圖片
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            ImageView iv = new ImageView(mContext);
            if(achb1.isChecked())
            {
                if(position==0||position==1||position==2||position==3||position==7||position==8)
                {
                    iv.setImageResource(imageIds[position]);
                    iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    iv.setLayoutParams(new GridView.LayoutParams(780, 240));
                }
            }
            if(achb3.isChecked())
            {
                if(position==4||position==5||position==6||position==9)
                {
                    iv.setImageResource(imageIds[position]);
                    iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    iv.setLayoutParams(new GridView.LayoutParams(780, 240));
                }
            }
            if (achb2.isChecked()) {

            }
            if (!achb1.isChecked()&&!achb2.isChecked()&&!achb3.isChecked())
            {
                iv.setImageResource(imageIds[position]);
                iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
                iv.setLayoutParams(new GridView.LayoutParams(780, 240));
            }
            return iv;
        }
    }
}
