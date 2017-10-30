package com.example.yuzelli.android5xspeciality;

import android.graphics.Outline;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.TextView;

//视图阴影  着色  剪裁
public class EZTingClippActivity extends AppCompatActivity {
    private TextView viewD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ezting_clipp);
        viewD = (TextView) findViewById(R.id.viewD);
        TextView tv1 = (TextView) findViewById(R.id.tv1);
        viewD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               viewD.animate().translationZ(100);
            }
        });

        //获取outLine，我们需要使用ViewoutLineProvider
        ViewOutlineProvider viewOutlineProvider=new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                //修改outLine的形状，这里是设置分别设置左上右下，以及Radius
                outline.setRoundRect(0,0,view.getWidth(),view.getHeight(),30);
            }
        };
        //将需要控件重写设置形状
        tv1.setOutlineProvider(viewOutlineProvider);
    }
}
