package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class eatwhereact extends AppCompatActivity {
    private int[] imageIds = {
            R.drawable.store1,R.drawable.store2,R.drawable.store3,
            R.drawable.store4,R.drawable.store5,R.drawable.store6,
            R.drawable.store7,R.drawable.store8,R.drawable.store9,
            R.drawable.store10,R.drawable.store11,R.drawable.store12,
            R.drawable.store13,R.drawable.store14
    };
    CheckBox chb1,chb2,chb3;
    GridView gridView;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eatwherexml);

        gridView = (GridView) findViewById(R.id.gridview);
        chb1=(CheckBox)findViewById(R.id.checkBox);
        chb2=(CheckBox)findViewById(R.id.checkBox2);
        chb3=(CheckBox)findViewById(R.id.checkBox3);

        chb1.setOnCheckedChangeListener(myListener);
        chb2.setOnCheckedChangeListener(myListener);
        chb3.setOnCheckedChangeListener(myListener);


        // 建立自訂的 Adapter
        adapter=new MyAdapter(this);

        // 設定 GridView 的資料來源
        gridView.setAdapter(adapter);

        // 建立 GridView 的 ItemClick 事件
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(eatwhereact.this,store.class);

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
            gridView.setAdapter(adapter);
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
            if(chb2.isChecked())
            {
                if(position==11||position==12)
                {
                    iv.setImageResource(imageIds[position]);
                    iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    iv.setLayoutParams(new GridView.LayoutParams(780, 240));
                }
            }
            if(chb3.isChecked())
            {
                if(position==5)
                {
                    iv.setImageResource(imageIds[position]);
                    iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    iv.setLayoutParams(new GridView.LayoutParams(780, 240));
                }
            }
            if (chb1.isChecked())
            {
                if(position!=11&&position!=12&&position!=5)
                {
                    iv.setImageResource(imageIds[position]);
                    iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    iv.setLayoutParams(new GridView.LayoutParams(780, 240));
                }
            }
            if (!chb1.isChecked()&&!chb2.isChecked()&&!chb3.isChecked())
            {
                iv.setImageResource(imageIds[position]);
                iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
                iv.setLayoutParams(new GridView.LayoutParams(780, 240));
            }
            return iv;
        }
    }

}
