package com.ehappy.excheckbox01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    String row1="",row2="",row3="",row4="",row5="",row6="",college="",Class="";
    private TextView txtResult;
    private EditText name,number;
    private RadioButton rad1,rad2,rad3,rad4;
    private RadioGroup radGroupBalls;
    private CheckBox chkBasketBall,chkFootBall,chkBaseBall,chkVolley,chkTableTennis,chkBadminton;
    private Spinner spnclass,spncollege;
    private Context context=this;
    ArrayAdapter<CharSequence> adapterClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText) findViewById(R.id.editTextname);
        number=(EditText) findViewById(R.id.editTextnumber);

        spncollege=(Spinner) findViewById(R.id.spncollege);
        // 建立ArrayAdapter
        ArrayAdapter<CharSequence> adaptercollege = ArrayAdapter.createFromResource(
                this, R.array.college,android.R.layout.simple_spinner_item);
        // 設定Spinner顯示的格式
        adaptercollege.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 設定Spinner的資料來源
        spncollege.setAdapter(adaptercollege);
        // 設定 spnPrefer 元件 ItemSelected 事件的 listener 為  spnPreferListener
        spncollege.setOnItemSelectedListener(spncollegeListener);

        spnclass =(Spinner) findViewById(R.id.spnclass);
        // 建立ArrayAdapter
        adapterClass = ArrayAdapter.createFromResource(this, R.array.STClass,android.R.layout.simple_spinner_item);
        // 設定Spinner顯示的格式
        adapterClass.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 設定Spinner的資料來源
        spnclass.setAdapter(adapterClass);
        // 設定 spnPrefer 元件 ItemSelected 事件的 listener 為  spnPreferListener
        spnclass.setOnItemSelectedListener(spnclassListener);

        // 取得介面元件的 id
        txtResult=(TextView) findViewById(R.id.txtResult);
        chkBasketBall = (CheckBox) findViewById(R.id.chkBasketBall);
        chkFootBall = (CheckBox) findViewById(R.id.chkFootBall);
        chkBaseBall = (CheckBox) findViewById(R.id.chkBaseBall);
        chkVolley=(CheckBox)findViewById(R.id.chkVolley);
        chkBadminton=(CheckBox)findViewById(R.id.chkBadminton);
        chkTableTennis=(CheckBox)findViewById(R.id.chkTableTennis);
        // 設定 CheckBox 元件 CheckedChange 事件的 listener 為 myListener
        chkBasketBall.setOnCheckedChangeListener(myListener);
        chkFootBall.setOnCheckedChangeListener(myListener);
        chkBaseBall.setOnCheckedChangeListener(myListener);
        chkVolley.setOnCheckedChangeListener(myListener);
        chkTableTennis.setOnCheckedChangeListener(myListener);
        chkBadminton.setOnCheckedChangeListener(myListener);

        radGroupBalls=(RadioGroup) findViewById(R.id.radGroupBalls);
        rad1 = (RadioButton) findViewById(R.id.rad1);
        rad2 = (RadioButton) findViewById(R.id.rad2);
        rad3 = (RadioButton) findViewById(R.id.rad3);
        rad4 = (RadioButton) findViewById(R.id.rad4);
        // 設定 radGroupBalls 元件 CheckedChange 事件的 listener 為 radGroupBallsListener
        radGroupBalls.setOnCheckedChangeListener(radGroupBallsListener);

    }
    private Spinner.OnItemSelectedListener spncollegeListener=
            new Spinner.OnItemSelectedListener(){
                @Override
                public void onItemSelected(AdapterView<?> parent, View v,
                                           int position, long id) {
                    college=parent.getSelectedItem().toString();
                    int pos=spncollege.getSelectedItemPosition();
                    if(pos==1)
                    {
                        adapterClass=ArrayAdapter.createFromResource(
                                context, R.array.OTHERClass,android.R.layout.simple_spinner_item);
                        spnclass.setAdapter(adapterClass);
                        spnclass.setOnItemSelectedListener(spnclassListener);
                    }
                    else
                    {
                        adapterClass=ArrayAdapter.createFromResource(
                                context, R.array.STClass,android.R.layout.simple_spinner_item);
                        spnclass.setAdapter(adapterClass);
                        spnclass.setOnItemSelectedListener(spnclassListener);
                    }
                    row3=college;
                    if(row3!=""&&row4!=""&&row5!=""&&row6!="")
                    {
                        if(name.getText().toString()!=""&&number.getText().toString()!="")
                        {
                            row1=name.getText().toString();
                            row2=number.getText().toString();
                            txtResult.setText(row1+" "+row2+" "+row3+"學院 "+row4+"系 "+row5+" "+row6);
                        }
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    // TODO Auto-generated method stub
                }
            };
    private Spinner.OnItemSelectedListener spnclassListener=
            new Spinner.OnItemSelectedListener(){
                @Override
                public void onItemSelected(AdapterView<?> parent, View v,
                                           int position, long id) {
                    Class=parent.getSelectedItem().toString();
                    row4=Class;
                    if(row3!=""&&row4!=""&&row5!=""&&row6!="")
                    {
                        if(name.getText().toString()!=""&&number.getText().toString()!="")
                        {
                            row1=name.getText().toString();
                            row2=number.getText().toString();
                            txtResult.setText(row1+" "+row2+" "+row3+"學院 "+row4+"系 "+row5+" "+row6);
                        }
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    // TODO Auto-generated method stub
                }
            };
    private RadioGroup.OnCheckedChangeListener radGroupBallsListener=
            new RadioGroup.OnCheckedChangeListener(){
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    int  p = group.indexOfChild((RadioButton) findViewById(checkedId));	// 選項的索引值
                    int count = group.getChildCount(); // 清單總共有多少項

                    if (checkedId == R.id.rad1)
                        row5 = rad1.getText() + "年級";
                    else if (checkedId == R.id.rad2)
                        row5 = rad2.getText() + "年級";
                    else if (checkedId == R.id.rad3)
                        row5 = rad3.getText() + "年級";
                    else if(checkedId==R.id.rad4)
                        row5 = rad4.getText() + "年級";
                    if(row3!=""&&row4!=""&&row5!=""&&row6!="")
                    {
                        row1=name.getText().toString();
                        row2=number.getText().toString();
                        if(row1!=""&&row2!="")
                            txtResult.setText(row1+" "+row2+" "+row3+"學院 "+row4+"系 "+row5+" "+row6);
                    }
                }
            };

    //  定義  onCheckedChanged 方法
    private CheckBox.OnCheckedChangeListener myListener=new CheckBox.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            int n=0;        // 記錄共選了多少項
            String sel="";  // 所有的選項結果
            String s1="",s2="",s3="",s4="",s5="",s6="";  // 單一選項的結果
            if(chkBasketBall.isChecked()){
                n++;
                s1=chkBasketBall.getText().toString() + " ";
            }else{
                s1="";
            }
            if(chkFootBall.isChecked()){
                n++;
                s2=chkFootBall.getText().toString() + " ";
            }else{
                s2="";
            }
            if(chkBaseBall.isChecked()){
                n++;
                s3=chkBaseBall.getText().toString() + " ";
            }else{
                s3="";
            }
            if(chkVolley.isChecked()){
                n++;
                s4=chkVolley.getText().toString() + " ";
            }else{
                s4="";
            }
            if(chkBadminton.isChecked()) {
                n++;
                s5=chkBadminton.getText().toString()+" ";
            }else {
                s5="";
            }
            if(chkTableTennis.isChecked()) {
                n++;
                s6=chkTableTennis.getText().toString()+" ";
            }else {
                s6="";
            }
            row6="參加了"+s1+s2+s3+s4+"系隊";
            if(row3!=""&&row4!=""&&row5!=""&&row6!="")
            {
                if(name.getText().toString()!=""&&number.getText().toString()!="")
                {
                    row1=name.getText().toString();
                    row2=number.getText().toString();
                    txtResult.setText(row1+" "+row2+" "+row3+"學院 "+row4+"系 "+row5+" "+row6);
                }
            }
        }
    };
}
