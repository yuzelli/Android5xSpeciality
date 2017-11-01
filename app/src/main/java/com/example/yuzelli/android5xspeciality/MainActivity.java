package com.example.yuzelli.android5xspeciality;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.yuzelli.android5xspeciality.excessive.FristActivity;

public class MainActivity extends Activity implements View.OnClickListener {
    Button btn_palette;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.findViewById(R.id.btn_palette).setOnClickListener(this);
        this.findViewById(R.id.btn_etc).setOnClickListener(this);
        this.findViewById(R.id.btn_cardview).setOnClickListener(this);
        this.findViewById(R.id.btn_excessive).setOnClickListener(this);
        this.findViewById(R.id.btn_material_design).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {

            case R.id.btn_palette:
                intent.setClass(MainActivity.this, PaletteActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_etc:
                intent.setClass(MainActivity.this, EZTingClippActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_cardview:
                intent.setClass(MainActivity.this, CardViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_excessive:
                intent.setClass(MainActivity.this, FristActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_material_design:
                intent.setClass(MainActivity.this, MaterialDesignActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
