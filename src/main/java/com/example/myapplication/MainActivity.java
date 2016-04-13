package com.example.myapplication;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {
    private int[] res = {R.id.a_icon, R.id.b_icon, R.id.c_icon, R.id.d_icon, R.id.e_icon, R.id.f_icon, R.id.g_icon, R.id.h_icon, R.id.i_icon};
    private ArrayList<ImageView> imageviewList = new ArrayList<ImageView>();
    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找到所有图标 并且赋值 监听 加入LIST组
        for (int i = 0; i < res.length; i++) {
            ImageView imageView = (ImageView) findViewById(res[i]);
            imageView.setOnClickListener(this);
            imageviewList.add(imageView);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.a_icon:
                if (flag == false) {
                    startAnim(v);
                } else {
                    closeAnim();
                }

                Toast.makeText(MainActivity.this, "点击了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.b_icon:
                Toast.makeText(MainActivity.this, "b_icon", Toast.LENGTH_SHORT).show();
                break;
            case R.id.c_icon:
                Toast.makeText(MainActivity.this, "c_icon", Toast.LENGTH_SHORT).show();
                break;
            case R.id.d_icon:
                Toast.makeText(MainActivity.this, "d_icon", Toast.LENGTH_SHORT).show();
                break;
            case R.id.e_icon:
                Toast.makeText(MainActivity.this, "e_icon", Toast.LENGTH_SHORT).show();
                break;
            case R.id.f_icon:
                Toast.makeText(MainActivity.this, "f_icon", Toast.LENGTH_SHORT).show();
                break;
            case R.id.g_icon:
                Toast.makeText(MainActivity.this, "g_icon", Toast.LENGTH_SHORT).show();
                break;
            case R.id.h_icon:
                Toast.makeText(MainActivity.this, "h_icon", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void startAnim(View view) {

        for (int i = 1; i < res.length; i++) {

            ObjectAnimator o1 = ObjectAnimator.ofFloat(imageviewList.get(i), "translationX", 0F, 150F);
            ObjectAnimator o2 = ObjectAnimator.ofFloat(imageviewList.get(i), "translationY", 0F, 150F);
            ObjectAnimator o3 = ObjectAnimator.ofFloat(imageviewList.get(i), "translationX", 0F, -150F);
            ObjectAnimator o4 = ObjectAnimator.ofFloat(imageviewList.get(i), "translationY", 0F, -150F);
            AnimatorSet set = new AnimatorSet();

            if (i <= 2) {
                set.play(o2);
                if (i == 2) {
                    set.play(o1);
                }
            } else if (i <= 4) {
                set.play(o1);
                if (i == 4) {
                    set.play(o4);
                }
            } else if (i <= 6) {
                set.play(o4);
                if (i == 6) {
                    set.play(o3);
                }
            } else if (i <= 8) {
                set.play(o3);
                if (i == 8) {
                    set.play(o2);
                }
            }
            set.setStartDelay(i * 100);
            set.setInterpolator(new BounceInterpolator());
            set.setDuration(1000);
            set.start();
            flag = true;
            Log.d("tag", "点击完毕+++++++++++++++++++++++++++++++++++++");
        }
    }

    private void closeAnim() {
        for (int i = 1; i < res.length; i++) {

            ObjectAnimator o1 = ObjectAnimator.ofFloat(imageviewList.get(i), "translationX", 150F, 0F);
            ObjectAnimator o2 = ObjectAnimator.ofFloat(imageviewList.get(i), "translationY", 150F, 0F);
            ObjectAnimator o3 = ObjectAnimator.ofFloat(imageviewList.get(i), "translationX", -150F, 0F);
            ObjectAnimator o4 = ObjectAnimator.ofFloat(imageviewList.get(i), "translationY", -150F, 0F);

            AnimatorSet set = new AnimatorSet();
            if (i <= 2) {
                set.play(o2);

                if (i == 2) {
                    set.play(o1);
                }
            } else if (i <= 4) {
                set.play(o1);
                if (i == 4) {
                    set.play(o4);
                }
            } else if (i <= 6) {
                set.play(o4);
                if (i == 6) {
                    set.play(o3);
                }
            } else if (i <= 8) {
                set.play(o3);
                if (i == 8) {
                    set.play(o2);
                }
            }
            set.setStartDelay(i * 100);
            set.setInterpolator(new AnticipateInterpolator());
            set.setDuration(1000);
            set.start();
            flag = false;
            Log.d("tag", "收回完毕+++++++++++++++++++++++++++++++++++++");
        }
    }
}



