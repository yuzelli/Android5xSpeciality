package com.example.yuzelli.android5xspeciality.excessive;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.yuzelli.android5xspeciality.R;

public class FristActivity extends AppCompatActivity {

  private View mIv_sun_img;
  private View iv_sheep_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frist);
        mIv_sun_img =  findViewById(R.id.iv_shared_img);
        iv_sheep_img = findViewById(R.id.iv_sheep_img);
    }

    //如果报错就在每个方法前加上@TargetApi(Build.VERSION_CODES.LOLLIPOP)，主要是为了防止版本太低
    public void explode(View v) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("flag", 0);
        startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(FristActivity.this).toBundle());
    }

    public void slide(View v) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("flag", 1);
        startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(FristActivity.this).toBundle());
    }

    public void fade(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("flag", 2);
        startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(FristActivity.this).toBundle());

    }

    public void share(View view) {
        Toast.makeText(FristActivity.this, "aaaaa", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("flag", 3);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(FristActivity.this, Pair.create((View)
                mIv_sun_img, "sun"),Pair.create(iv_sheep_img,"sheep")).toBundle());
    }
}
