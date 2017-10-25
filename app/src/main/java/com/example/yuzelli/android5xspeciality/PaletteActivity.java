package com.example.yuzelli.android5xspeciality;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PaletteActivity extends AppCompatActivity {

    private LinearLayout line1, line2, line3, line4, line5, line6;
    private TextView tv1_1, tv1_2, tv2_1, tv2_2, tv3_1, tv3_2, tv4_1, tv4_2, tv5_1, tv5_2, tv6_1, tv6_2;
    private List<LinearLayout> bgs = new ArrayList<>();
    private List<TextView> bodyTexts = new ArrayList<>();
    private List<TextView> titleTexts = new ArrayList<>();
    private List<Palette.Swatch> swatchs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);
        ImageView img = (ImageView) findViewById(R.id.img);
        initView();
        Bitmap bitmap = ((BitmapDrawable) img.getDrawable()).getBitmap();
        if (bitmap == null) {
            return;
        }
        Palette.from(bitmap).generate(listener);

    }

    private Palette.PaletteAsyncListener listener = new Palette.PaletteAsyncListener() {
        @Override
        public void onGenerated(Palette palette) {
            if (palette != null) {
                Palette.Swatch vibrant = palette.getVibrantSwatch();//有活力的
                Palette.Swatch vibrantDark = palette.getDarkVibrantSwatch();//有活力的，暗色
                Palette.Swatch vibrantLight = palette.getLightVibrantSwatch();//有活力的，亮色
                Palette.Swatch muted = palette.getMutedSwatch();//柔和的
                Palette.Swatch mutedDark = palette.getDarkMutedSwatch();//柔和的，暗色
                Palette.Swatch mutedLight = palette.getLightMutedSwatch();//柔和的,亮色
                swatchs.clear();
                swatchs.add(vibrant);
                swatchs.add(vibrantDark);
                swatchs.add(vibrantLight);
                swatchs.add(muted);
                swatchs.add(mutedDark);
                swatchs.add(mutedLight);
                show();
            }
        }
    };

    private void show() {
        for (int i = 0; i < 6; i++) {
            if (swatchs.get(i)!=null){
                bgs.get(i).setBackgroundColor(swatchs.get(i).getRgb());
                bodyTexts.get(i).setTextColor(swatchs.get(i).getBodyTextColor());
                titleTexts.get(i).setTextColor(swatchs.get(i).getTitleTextColor());
            }

        }
    }


    private void initView() {
        line1 = (LinearLayout) findViewById(R.id.line1);
        line2 = (LinearLayout) findViewById(R.id.line2);
        line3 = (LinearLayout) findViewById(R.id.line3);
        line4 = (LinearLayout) findViewById(R.id.line4);
        line5 = (LinearLayout) findViewById(R.id.line5);
        line6 = (LinearLayout) findViewById(R.id.line6);
        bgs.clear();
        bgs.add(line1);
        bgs.add(line2);
        bgs.add(line3);
        bgs.add(line4);
        bgs.add(line5);
        bgs.add(line6);
        tv1_1 = (TextView) findViewById(R.id.tv1_1);
        tv2_1 = (TextView) findViewById(R.id.tv2_1);
        tv3_1 = (TextView) findViewById(R.id.tv3_1);
        tv4_1 = (TextView) findViewById(R.id.tv4_1);
        tv5_1 = (TextView) findViewById(R.id.tv5_1);
        tv6_1 = (TextView) findViewById(R.id.tv6_1);
        tv1_2 = (TextView) findViewById(R.id.tv1_2);
        tv2_2 = (TextView) findViewById(R.id.tv2_2);
        tv3_2 = (TextView) findViewById(R.id.tv3_2);
        tv4_2 = (TextView) findViewById(R.id.tv4_2);
        tv5_2 = (TextView) findViewById(R.id.tv5_2);
        tv6_2 = (TextView) findViewById(R.id.tv6_2);
        bodyTexts.clear();
        titleTexts.clear();
        bodyTexts.add(tv1_1);
        bodyTexts.add(tv2_1);
        bodyTexts.add(tv3_1);
        bodyTexts.add(tv4_1);
        bodyTexts.add(tv5_1);
        bodyTexts.add(tv6_1);
        titleTexts.add(tv1_2);
        titleTexts.add(tv2_2);
        titleTexts.add(tv3_2);
        titleTexts.add(tv4_2);
        titleTexts.add(tv5_2);
        titleTexts.add(tv6_2);
    }

}
