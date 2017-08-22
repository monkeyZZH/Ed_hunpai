package com.ed_hunpai;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText edt;

    private Button btn;
    private Button btnsave;
    int []faces = {R.drawable.a, R.drawable.b, R.drawable.d};  //图片资源ID

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        initView();

        initEvent();
    }

    private void initEvent() {
        //点击选择添加图片

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //核心代码：html标签插入EditText中，实现imageGetter对象中的getDrawable方法
                edt.append(Html.fromHtml("<img src='"+ faces[new Random().nextInt(3)] +"'/>", imageGetter, null));
            }
        });
        //点击保存图片
        btnsave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String content = edt.getText().toString(); //将edt的内容存储，图片的话存储的是路径
                Bundle data = new Bundle();
                data.putString("nei", content);
                Intent intent = new Intent(MainActivity.this, display.class);
//                intent.putExtra("neirong", data);
                startActivity(intent);

            }
        });
    }




    //实现ImageGetter中的 getDrawable 返回Drawable资源（图片png）
    private Html.ImageGetter imageGetter = new Html.ImageGetter() {

        @Override
        public Drawable getDrawable(String src) {
            int id = Integer.parseInt(src);
            Drawable d = getResources().getDrawable(id);
            d.setBounds(0, 0, 100, 100);   //记住一定给图片一个显示的区域
            return d;
        }
    };
    private void initView() {
        // TODO Auto-generated method stub
        edt = (EditText) findViewById(R.id.id_edt);
        btn = (Button) findViewById(R.id.id_btn);
        btnsave = (Button) findViewById(R.id.id_btnsave);
    }


}

