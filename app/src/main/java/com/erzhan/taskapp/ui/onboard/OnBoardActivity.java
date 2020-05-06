package com.erzhan.taskapp.ui.onboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.erzhan.taskapp.R;

public class OnBoardActivity extends AppCompatActivity {
    Button button;
    private int dotsCount;
    private ImageView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);
        ViewPager viewPager = findViewById(R.id.viewPager);
        button = findViewById(R.id.btn_get_started);
        viewPager.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager()));


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                // Change the current position intimation

                for (int i = 0; i < dotsCount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(OnBoardingActivity.this, R.drawable.non_selected_item_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(OnBoardingActivity.this, R.drawable.selected_item_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(@NonNull FragmentManager fm) {
            super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            Bundle bundle = new Bundle();
            bundle.putInt("pos",position);
            BoardFragment fragment = new BoardFragment();
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
    public void show_animation()
    {
        Animation show = AnimationUtils.loadAnimation(this, R.anim.slide_up_anim);

        button.startAnimation(show);

        show.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                button.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                button.clearAnimation();

            }

        });


    }
}


