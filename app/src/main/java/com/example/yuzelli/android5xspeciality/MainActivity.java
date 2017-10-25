package com.example.yuzelli.android5xspeciality;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {
    Button btn_palette;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_palette = this.findViewById(R.id.btn_palette);

        btn_palette.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {

            case R.id.btn_palette:
                intent.setClass(MainActivity.this,PaletteActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
