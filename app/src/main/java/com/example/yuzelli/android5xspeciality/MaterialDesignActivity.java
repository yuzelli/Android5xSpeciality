package com.example.yuzelli.android5xspeciality;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

public class MaterialDesignActivity extends AppCompatActivity {
    private Button btn_reval, btn_reval1;
    private ImageView iv_reval, iv_reval1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_design);
        btn_reval = (Button) findViewById(R.id.btn_reval);
        btn_reval1 = (Button) findViewById(R.id.btn_reval1);
        iv_reval = (ImageView) findViewById(R.id.iv_reval);
        iv_reval1 = (ImageView) findViewById(R.id.iv_reval1);

        btn_reval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iv_reval.getVisibility() == View.GONE
                        || iv_reval.getVisibility() == View.INVISIBLE) {
                    showRevalView();
                } else {
                    hideRevalView();
                }
            }
        });
        // 从某一角度到对角的动画
        btn_reval1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iv_reval1.getVisibility() == View.GONE || iv_reval1.getVisibility() == View.INVISIBLE) {
                    Animator anim =
                            ViewAnimationUtils.createCircularReveal(
                                    iv_reval1,//对应的view
                                    0,// 开始缩放点x位置
                                    0,// 开始缩放点y位置
                                    0,//开始半径
                                    // 结束半径    hypot(double ,double ) 表示斜线的长度
                                    (float) Math.hypot(iv_reval1.getWidth(), iv_reval1.getHeight()));
                    // make the view visible and start the animation
                    iv_reval1.setVisibility(View.VISIBLE);
                    anim.setDuration(2000);
                    /* Set a natural ease-in/ease-out interpolator. */
                    anim.setInterpolator(new AccelerateDecelerateInterpolator());
                    anim.start();
                } else {
                    Animator anim =
                            ViewAnimationUtils.createCircularReveal(
                                    iv_reval1,//对应的view
                                    0,// 开始缩放点x位置
                                    0,// 开始缩放点y位置
                                    // 开始半径和结束半径
                                    (float) Math.hypot(iv_reval1.getWidth(), iv_reval1.getHeight()), 0);
                    // make the view visible and start the animation
                    iv_reval1.setVisibility(View.VISIBLE);
                    anim.setDuration(2000);
                    /* Set a natural ease-in/ease-out interpolator. */
                    anim.setInterpolator(new AccelerateDecelerateInterpolator());
                    anim.start();
                    anim.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            iv_reval1.setVisibility(View.GONE);
                        }
                    });
                }
            }
        });

        findViewById(R.id.tv_toolbar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MaterialDesignActivity.this, ToolbarActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.tv_notification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MaterialDesignActivity.this, ToolbarActivity.class);
                startActivity(intent);
            }
        });
    }


    protected void hideRevalView() {
        // get the center for the clipping circle
        int cx = (iv_reval.getLeft() + iv_reval.getRight()) / 2;
        int cy = (iv_reval.getTop() + iv_reval.getBottom()) / 2;

        // get the final radius for the clipping circle
        int finalRadius = Math.max(iv_reval.getWidth(), iv_reval.getHeight());

// create the animator for this view (the start radius is zero)
        Animator anim =
                ViewAnimationUtils.createCircularReveal(
                        iv_reval,//对应的view
                        iv_reval.getWidth() / 2,// 开始缩放点x位置
                        iv_reval.getHeight() / 2,// 开始缩放点y位置
                        iv_reval.getWidth(),// 开始半径和结束半径    hypot(double ,double ) 斜线的长度
                        0);
        // make the view visible and start the animation
        iv_reval.setVisibility(View.VISIBLE);
        anim.setDuration(2000);
             /* Set a natural ease-in/ease-out interpolator. */
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.start();
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                iv_reval.setVisibility(View.GONE);
            }
        });
    }

    private void showRevalView() {
        // get the center for the clipping circle
        int cx = (iv_reval.getLeft() + iv_reval.getRight()) / 2;
        int cy = (iv_reval.getTop() + iv_reval.getBottom()) / 2;

        // get the final radius for the clipping circle
        int finalRadius = Math.max(iv_reval.getWidth(), iv_reval.getHeight());

// create the animator for this view (the start radius is zero)
        Animator anim =
                ViewAnimationUtils.createCircularReveal(
                        iv_reval,
                        iv_reval.getWidth() / 2,// 开始缩放点x位置
                        iv_reval.getHeight() / 2,// 开始缩放点y位置
                        0,// 开始半径和结束半径
                        (float) Math.hypot(iv_reval.getWidth(), iv_reval.getHeight()));
        // make the view visible and start the animation
        iv_reval.setVisibility(View.VISIBLE);
        anim.setDuration(2000);
         /* Set a natural ease-in/ease-out interpolator. */
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.start();
    }

}
