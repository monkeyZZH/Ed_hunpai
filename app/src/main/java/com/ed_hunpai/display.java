package com.ed_hunpai;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * name:周振辉
 * 时间：2017/8/22 15:34
 * 类描述：
 */

public class display extends AppCompatActivity {

        private EditText tvTest = null;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.display);
            tvTest = (EditText) findViewById(R.id.id_edtDisplay);
        }
    public void but(View v){
        String aa = tvTest.getText().toString();
        Toast.makeText(this,aa,Toast.LENGTH_LONG).show();
        SpannableString spannableString = new SpannableString(aa);
        Drawable drawable = getResources().getDrawable(R.drawable.a);
        drawable.setBounds(0, 0, 100, 100);
        ImageSpan imageSpan = new ImageSpan(drawable);
        spannableString.setSpan(imageSpan, aa.length()-1, aa.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tvTest.setText(spannableString);
    }



    }
//    public void but(View v){
//        Drawable drawable = getResources().getDrawable(R.drawable.a);
//        drawable.setBounds(0,  0,100,100);
//        //需要处理的文本，[微笑]是需要被替代的文本
//        SpannableString spannable =  new  SpannableString(edt.getText().toString()+ "[smile]");
//        //要让图片替代指定的文字就要用ImageSpan
//        ImageSpan span =  new  ImageSpan(drawable,ImageSpan.ALIGN_BASELINE);
//        //开始替换，注意第2和第3个参数表示从哪里开始替换到哪里替换结束（开始和结束）
////最后一个参数类似数学中的集合，[5,12）表示从5到12，包括5但不包括12
//        spannable.setSpan(span,edt.getText().length(),edt.getText().length()+ "[smile]" .length(),
//        Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
//        edt.setText(spannable);
//    }



