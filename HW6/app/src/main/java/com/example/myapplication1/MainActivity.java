package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import java.math.*;

public class MainActivity extends AppCompatActivity
{
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,
            btn16,btn17,btn18,btn19,btn20,btn21,btn22,btn23,btn24,btn25,btn26,btn27,btn28,btn29,btn30;
    private TextView txt;
    BigDecimal num=new BigDecimal("0"),memnum=new BigDecimal("0"),tmpnum=new BigDecimal("0");
    int[] state={0,0,0,0,0,0,0,0,0};
    int CE=0;
    String temp="",neg="-";
    double flonum;
    BigDecimal trans;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txt=(TextView)findViewById(R.id.num);
        btn1=(Button)findViewById(R.id.button1);btn2=(Button)findViewById(R.id.button2);btn3=(Button)findViewById(R.id.button3);
        btn4=(Button)findViewById(R.id.button4);btn5=(Button)findViewById(R.id.button5);btn6=(Button)findViewById(R.id.button6);
        btn7=(Button)findViewById(R.id.button7);btn8=(Button)findViewById(R.id.button8);btn9=(Button)findViewById(R.id.button9);
        btn10=(Button)findViewById(R.id.button10);btn11=(Button)findViewById(R.id.button11);btn12=(Button)findViewById(R.id.button12);
        btn13=(Button)findViewById(R.id.button13);btn14=(Button)findViewById(R.id.button14);btn15=(Button)findViewById(R.id.button15);
        btn16=(Button)findViewById(R.id.button16);btn17=(Button)findViewById(R.id.button17);btn18=(Button)findViewById(R.id.button18);
        btn19=(Button)findViewById(R.id.button19);btn20=(Button)findViewById(R.id.button20);btn21=(Button)findViewById(R.id.button21);
        btn22=(Button)findViewById(R.id.button22);btn23=(Button)findViewById(R.id.button23);btn24=(Button)findViewById(R.id.button24);
        btn25=(Button)findViewById(R.id.button25);btn26=(Button)findViewById(R.id.button26);btn27=(Button)findViewById(R.id.button27);
        btn28=(Button)findViewById(R.id.button28);btn29=(Button)findViewById(R.id.button29);btn30=(Button)findViewById(R.id.button30);

        btn7.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(state[4]==1&&state[0]==0&&state[1]==0&&state[2]==0&&state[3]==0)
                    tmpnum=new BigDecimal("0");
                if(temp.equals("0")||state[4]==1)
                    temp="9";
                else
                    temp+="9";
                state[4]=0;
                txt.setText(temp);
                AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.property_scale_size);
                set.setTarget(v);
                set.start();
            }
        });
        btn8.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(state[4]==1&&state[0]==0&&state[1]==0&&state[2]==0&&state[3]==0)
                    tmpnum=new BigDecimal("0");
                if(temp.equals("0")||state[4]==1)
                    temp="8";
                else
                    temp+="8";
                state[4]=0;
                txt.setText(temp);
                AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.property_scale_size);
                set.setTarget(v);
                set.start();
            }
        });
        btn9.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(state[4]==1&&state[0]==0&&state[1]==0&&state[2]==0&&state[3]==0)
                    tmpnum=new BigDecimal("0");
                if(temp.equals("0")||state[4]==1)
                    temp="7";
                else
                    temp+="7";
                state[4]=0;
                txt.setText(temp);
                AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.property_scale_size);
                set.setTarget(v);
                set.start();
            }
        });
        btn12.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(state[4]==1&&state[0]==0&&state[1]==0&&state[2]==0&&state[3]==0)
                    tmpnum=new BigDecimal("0");
                if(temp.equals("0")||state[4]==1)
                    temp="6";
                else
                    temp+="6";
                state[4]=0;
                txt.setText(temp);
                Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.tween_slide_in_from_buttom);
                v.startAnimation(anim);
            }
        });
        btn13.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(state[4]==1&&state[0]==0&&state[1]==0&&state[2]==0&&state[3]==0)
                    tmpnum=new BigDecimal("0");
                if(temp.equals("0")||state[4]==1)
                    temp="5";
                else
                    temp+="5";
                state[4]=0;
                txt.setText(temp);
                Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.tween_slide_in_from_buttom);
                v.startAnimation(anim);
            }
        });
        btn14.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(state[4]==1&&state[0]==0&&state[1]==0&&state[2]==0&&state[3]==0)
                    tmpnum=new BigDecimal("0");
                if(temp.equals("0")||state[4]==1)
                    temp="4";
                else
                    temp+="4";
                state[4]=0;
                txt.setText(temp);
                Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.tween_slide_in_from_buttom);
                v.startAnimation(anim);
            }
        });
        btn17.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(state[4]==1&&state[0]==0&&state[1]==0&&state[2]==0&&state[3]==0)
                    tmpnum=new BigDecimal("0");
                if(temp.equals("0")||state[4]==1)
                    temp="3";
                else
                    temp+="3";
                state[4]=0;
                txt.setText(temp);
                Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.tween_rotate_fadeout);
                v.startAnimation(anim);
            }
        });
        btn18.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(state[4]==1&&state[0]==0&&state[1]==0&&state[2]==0&&state[3]==0)
                    tmpnum=new BigDecimal("0");
                if(temp.equals("0")||state[4]==1)
                    temp="2";
                else
                    temp+="2";
                state[4]=0;
                txt.setText(temp);
                Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.tween_rotate_fadeout);
                v.startAnimation(anim);
            }
        });
        btn19.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(state[4]==1&&state[0]==0&&state[1]==0&&state[2]==0&&state[3]==0)
                    tmpnum=new BigDecimal("0");
                if(temp.equals("0")||state[4]==1)
                    temp="1";
                else
                    temp+="1";
                state[4]=0;
                txt.setText(temp);
                Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.tween_rotate_fadeout);
                v.startAnimation(anim);
            }
        });
        btn23.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(state[4]==1&&state[0]==0&&state[1]==0&&state[2]==0&&state[3]==0)
                    tmpnum=new BigDecimal("0");
                if(!temp.equals("") && !temp.equals("0"))
                    temp+="0";
                else if(temp.equals("")||state[4]==1)
                    temp="0";
                state[4]=0;
                txt.setText(temp);
                Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.tween_rotate_fadeout);
                v.startAnimation(anim);
            }
        });

        //+
        btn16.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(state[0]==0&&state[1]==0&&state[2]==0&&state[3]==0&&state[4]==0)
                {
                    trans=new BigDecimal(temp);
                    tmpnum = tmpnum.add(trans);
                }
                else if (state[0]==1&&state[4]==0)
                {
                    trans=new BigDecimal(temp);
                    tmpnum = tmpnum.add(trans);
                    state[0]=0;
                }
                else if(state[1]==1&&state[4]==0)
                {
                    trans=new BigDecimal(temp);
                    tmpnum = tmpnum.subtract(trans);
                    state[1]=0;
                }
                else if(state[2]==1&&state[4]==0)
                {
                    trans=new BigDecimal(temp);
                    tmpnum = tmpnum.multiply(trans);
                    state[2]=0;
                }
                else if(state[3]==1&&state[4]==0)
                {
                    trans=new BigDecimal(temp);
                    tmpnum = tmpnum.divide(trans,10,RoundingMode.UP);
                    state[3]=0;
                }
                temp="0";
                state[0]=1;
                Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.tween_rotate_fadeout);
                v.startAnimation(anim);
            }
        });
        //-
        btn11.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(state[0]==0&&state[1]==0&&state[2]==0&&state[3]==0&&state[4]==0)
                {
                    trans=new BigDecimal(temp);
                    tmpnum = tmpnum.add(trans);
                }
                else if (state[0]==1&&state[4]==0)
                {
                    trans=new BigDecimal(temp);
                    tmpnum = tmpnum.add(trans);
                    state[0]=0;
                }
                else if(state[1]==1&&state[4]==0)
                {
                    trans=new BigDecimal(temp);
                    tmpnum = tmpnum.subtract(trans);
                    state[1]=0;
                }
                else if(state[2]==1&&state[4]==0)
                {
                    trans=new BigDecimal(temp);
                    tmpnum = tmpnum.multiply(trans);
                    state[2]=0;
                }
                else if(state[3]==1&&state[4]==0)
                {
                    trans=new BigDecimal(temp);
                    tmpnum = tmpnum.divide(trans,10,RoundingMode.UP);
                    state[3]=0;
                }
                temp="0";
                state[1]=1;
                Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.tween_slide_in_from_buttom);
                v.startAnimation(anim);
            }
        });
        //*
        btn6.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(state[0]==0&&state[1]==0&&state[2]==0&&state[3]==0&&state[4]==0)
                {
                    trans=new BigDecimal(temp);
                    tmpnum = tmpnum.add(trans);
                }
                else if (state[0]==1&&state[4]==0)
                {
                    trans=new BigDecimal(temp);
                    tmpnum = tmpnum.add(trans);
                    state[0]=0;
                }
                else if(state[1]==1&&state[4]==0)
                {
                    trans=new BigDecimal(temp);
                    tmpnum = tmpnum.subtract(trans);
                    state[1]=0;
                }
                else if(state[2]==1&&state[4]==0)
                {
                    trans=new BigDecimal(temp);
                    tmpnum = tmpnum.multiply(trans);
                    state[2]=0;
                }
                else if(state[3]==1&&state[4]==0)
                {
                    trans=new BigDecimal(temp);
                    tmpnum = tmpnum.divide(trans,10,RoundingMode.UP);
                    state[3]=0;
                }
                temp="0";
                state[2]=1;
                AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.property_scale_size);
                set.setTarget(v);
                set.start();
            }
        });
        //div
        btn1.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(state[0]==0&&state[1]==0&&state[2]==0&&state[3]==0&&state[4]==0)
                {
                    trans=new BigDecimal(temp);
                    tmpnum = tmpnum.add(trans);
                }
                else if (state[0]==1&&state[4]==0)
                {
                    trans=new BigDecimal(temp);
                    tmpnum = tmpnum.add(trans);
                    state[0]=0;
                }
                else if(state[1]==1&&state[4]==0)
                {
                    trans=new BigDecimal(temp);
                    tmpnum = tmpnum.subtract(trans);
                    state[1]=0;
                }
                else if(state[2]==1&&state[4]==0)
                {
                    trans=new BigDecimal(temp);
                    tmpnum = tmpnum.multiply(trans);
                    state[2]=0;
                }
                else if(state[3]==1&&state[4]==0)
                {
                    trans=new BigDecimal(temp);
                    tmpnum = tmpnum.divide(trans,10,RoundingMode.UP);
                    state[3]=0;
                }
                temp="0";
                state[3]=1;
                AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.property_scale_size);
                set.setTarget(v);
                set.start();
            }
        });
        //DELETE
        btn2.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                temp = temp.substring(0,temp.length()-1);
                txt.setText(temp);
                AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.property_scale_size);
                set.setTarget(v);
                set.start();
            }
        });
        //CE
        btn4.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(CE!=1)
                    temp="0";
                else
                {
                    tmpnum=new BigDecimal("0");
                    temp="0";
                }
                CE=0;
                txt.setText(temp);
                AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.property_scale_size);
                set.setTarget(v);
                set.start();
            }
        });
        //C
        btn3.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                tmpnum=new BigDecimal("0");
                temp="0";
                txt.setText(temp);
                AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.property_scale_size);
                set.setTarget(v);
                set.start();
            }
        });
        //+-
        btn24.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(!temp.equals("0") && !temp.equals(""))
                    temp=neg+temp;
                txt.setText(temp);
                Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.tween_rotate_fadeout);
                v.startAnimation(anim);
            }
        });
        //1/x
        btn25.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(temp.equals("0") || temp.equals(""))
                    txt.setText("undefined");
                else
                {
                    BigDecimal one = new BigDecimal("1");
                    trans = new BigDecimal(temp);
                    trans=one.divide(trans,10,RoundingMode.UP);
                    temp=trans.toString();
                    if(temp.contains("."))
                    {
                        for(int i=temp.length()-1;i>=0;i--)
                        {
                            if(temp.charAt(i)=='0')
                            {
                                temp = temp.substring(0,temp.length()-1);
                            }
                            else if(temp.charAt(i)=='.')
                            {
                                temp = temp.substring(0,temp.length()-1);
                                break;
                            }
                            else
                                break;
                        }
                    }
                    txt.setText(temp);
                }
                Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.tween_rotate_fadeout);
                v.startAnimation(anim);
            }
        });
        //x^3
        btn20.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                trans=new BigDecimal(temp);
                trans=trans.multiply(trans);
                trans=trans.multiply(trans);
                temp=trans.toString();
                if(temp.contains("."))
                {
                    for(int i=temp.length()-1;i>=0;i--)
                    {
                        if(temp.charAt(i)=='0')
                        {
                            temp = temp.substring(0,temp.length()-1);
                        }
                        else if(temp.charAt(i)=='.')
                        {
                            temp = temp.substring(0,temp.length()-1);
                            break;
                        }
                        else
                            break;
                    }
                }
                txt.setText(temp);
                Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.tween_rotate_fadeout);
                v.startAnimation(anim);
            }
        });
        //x^2
        btn15.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                trans=new BigDecimal(temp);
                trans=trans.multiply(trans);
                temp=trans.toString();
                if(temp.contains("."))
                {
                    for(int i=temp.length()-1;i>=0;i--)
                    {
                        if(temp.charAt(i)=='0')
                        {
                            temp = temp.substring(0,temp.length()-1);
                        }
                        else if(temp.charAt(i)=='.')
                        {
                            temp = temp.substring(0,temp.length()-1);
                            break;
                        }
                        else
                            break;
                    }
                }
                txt.setText(temp);
                Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.tween_slide_in_from_buttom);
                v.startAnimation(anim);
            }
        });
        //squr(x)
        btn10.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                flonum=Double.parseDouble(temp);
                flonum=Math.sqrt(flonum);
                temp=String.valueOf(flonum);
                txt.setText(temp);
                AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.property_scale_size);
                set.setTarget(v);
                set.start();
            }
        });
        //%
        btn5.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                BigDecimal zero = new BigDecimal("0");
                if(tmpnum.compareTo(zero)==0)
                    temp="0";
                else
                {
                    BigDecimal hundred=new BigDecimal("100");
                    trans = new BigDecimal(temp);
                    trans=trans.divide(hundred,10,RoundingMode.UP);
                    temp=trans.toString();
                    if(temp.contains("."))
                    {
                        for(int i=temp.length()-1;i>=0;i--)
                        {
                            if(temp.charAt(i)=='0')
                            {
                                temp = temp.substring(0,temp.length()-1);
                            }
                            else if(temp.charAt(i)=='.')
                            {
                                temp = temp.substring(0,temp.length()-1);
                                break;
                            }
                            else
                                break;
                        }
                    }
                }
                txt.setText(temp);
                AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.property_scale_size);
                set.setTarget(v);
                set.start();
            }
        });
        //MC
        btn26.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                memnum=new BigDecimal("0");
                AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.property_scale_size);
                set.setTarget(v);
                set.start();
            }
        });
        //MR
        btn27.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                temp=memnum.toString();
                tmpnum=memnum;
                txt.setText(temp);
                AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.property_scale_size);
                set.setTarget(v);
                set.start();
            }
        });
        //M+
        btn28.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                trans=new BigDecimal(temp);
                memnum=memnum.add(trans);
                AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.property_scale_size);
                set.setTarget(v);
                set.start();
            }
        });
        //M-
        btn29.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                trans=new BigDecimal(temp);
                memnum=memnum.subtract(trans);
                AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.property_scale_size);
                set.setTarget(v);
                set.start();
            }
        });
        //MS
        btn30.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                memnum=new BigDecimal(temp);
                AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.property_scale_size);
                set.setTarget(v);
                set.start();
            }
        });
        //.
        btn22.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(!temp.contains("."))
                    temp+=".";
                Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.tween_rotate_fadeout);
                v.startAnimation(anim);
            }

        });
        //=
        btn21.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                CE=1;
                trans=new BigDecimal(temp);
                if(state[0]==1)
                {
                    tmpnum = tmpnum.add(trans);
                    temp=tmpnum.toString();
                    state[0]=0;
                }
                else if(state[1]==1)
                {
                    tmpnum = tmpnum.subtract(trans);
                    temp=tmpnum.toString();
                    state[1]=0;
                }
                else if(state[2]==1)
                {
                    tmpnum = tmpnum.multiply(trans);
                    temp=tmpnum.toString();
                    if(temp.contains("."))
                    {
                        for(int i=temp.length()-1;i>=0;i--)
                        {
                            if(temp.charAt(i)=='0')
                            {
                                temp = temp.substring(0,temp.length()-1);
                            }
                            else if(temp.charAt(i)=='.')
                            {
                                temp = temp.substring(0,temp.length()-1);
                                break;
                            }
                            else
                                break;
                        }
                    }
                    state[2]=0;
                }
                else if(state[3]==1)
                {
                    tmpnum = tmpnum.divide(trans,10,RoundingMode.UP);
                    temp=tmpnum.toString();
                    if(temp.contains("."))
                    {
                        for(int i=temp.length()-1;i>=0;i--)
                        {
                            if(temp.charAt(i)=='0')
                            {
                                temp = temp.substring(0,temp.length()-1);
                            }
                            else if(temp.charAt(i)=='.')
                            {
                                temp = temp.substring(0,temp.length()-1);
                                break;
                            }
                            else
                                break;
                        }
                    }
                    state[3]=0;
                }
                txt.setText(temp);
                state[4]=1;
                Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.tween_rotate_fadeout);
                v.startAnimation(anim);
            }
        });

    }


}
