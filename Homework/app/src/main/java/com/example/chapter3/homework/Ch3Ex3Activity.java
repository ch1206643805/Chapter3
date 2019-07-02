package com.example.chapter3.homework;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;

public class Ch3Ex3Activity extends AppCompatActivity {

    private double time1=0;
    private double time2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch3_ex3);


        final ValueAnimator animator=ValueAnimator.ofFloat(7f,0f);
        animator.setDuration(5000);
        animator.setRepeatCount(0);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float data=(Float) animator.getAnimatedValue();
                if(1.0f<=data && data<=2.0f){
                    findViewById(R.id.animation_view2).setAlpha(data-1f);
                }
                if(data<1.0f){
                    findViewById(R.id.view_pager).setAlpha(1f-data);
                }
            }
        });
        animator.start();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.First_Fragment,new First_Fragment())
                .commit();

        TabLayout tabLayout=findViewById(R.id.tab_layout);
        ViewPager viewpager=findViewById(R.id.view_pager);
        viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return new First_Fragment();
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                if(position==0) return "好友列表";
                else return "我的好友";
            }

        });

        tabLayout.setupWithViewPager(viewpager);

    }

}
