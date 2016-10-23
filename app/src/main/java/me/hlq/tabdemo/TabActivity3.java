package me.hlq.tabdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Tab实现方案三：
 * 使用ViewPager+Fragment
 * （外加FragmentPagerAdapter，确保可以滑动切换页面）
 *
 * （此情景可以看成是方案一的变种，只不过是把页面List中的泛型由View换成Fragment罢了）
 * 因为视图变成了Fragment，所以adapter由PagerAdapter换成FragmentPagerAdapter
 *
 * @author HLQ 2016/10/23
 */
public class TabActivity3 extends FragmentActivity implements View.OnClickListener {

    private LinearLayout ll_tab1_know;
    private LinearLayout ll_tab1_want_to_know;
    private LinearLayout ll_tab1_my_pager;

    private ImageButton ib_know;
    private ImageButton ib_want_to_know;
    private ImageButton ib_my_pager;
    private TextView tv_know;
    private TextView tv_want_to_know;
    private TextView tv_my_page;

    private ViewPager viewPager_tab1;

    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //这里复用布局一
        setContentView(R.layout.activity_tab1);

        initView();
        setListener();
    }

    private void setListener() {

        ll_tab1_know.setOnClickListener(this);
        ll_tab1_want_to_know.setOnClickListener(this);
        ll_tab1_my_pager.setOnClickListener(this);
    }

    private void initView() {

        ll_tab1_know = (LinearLayout) findViewById(R.id.ll_tab1_know);
        ll_tab1_want_to_know = (LinearLayout) findViewById(R.id.ll_tab1_want_to_know);
        ll_tab1_my_pager = (LinearLayout) findViewById(R.id.ll_tab1_my_pager);
        ib_know = (ImageButton) findViewById(R.id.ib_know);
        ib_want_to_know = (ImageButton) findViewById(R.id.ib_want_to_know);
        ib_my_pager = (ImageButton) findViewById(R.id.ib_my_pager);
        tv_know = (TextView) findViewById(R.id.tv_know);
        tv_want_to_know = (TextView) findViewById(R.id.tv_want_to_know);
        tv_my_page = (TextView) findViewById(R.id.tv_my_page);

        viewPager_tab1 = (ViewPager) findViewById(R.id.viewPager_tab1);

        initList();

        viewPager_tab1.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {

                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }

        });

        viewPager_tab1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

                setTabImageNormal();
                switch (position){
                    case 0:
                        //设置viewpager当前的item
                        viewPager_tab1.setCurrentItem(0);
                        ib_know.setImageResource(R.mipmap.btn_know_pre);
                        tv_know.setTextColor(getResources().getColor(R.color.colorPressed));
                        break;
                    case 1:
                        //设置viewpager当前的item
                        viewPager_tab1.setCurrentItem(1);
                        ib_want_to_know.setImageResource(R.mipmap.btn_wantknow_pre);
                        tv_want_to_know.setTextColor(getResources().getColor(R.color.colorPressed));
                        break;
                    case 2:
                        //设置viewpager当前的item
                        viewPager_tab1.setCurrentItem(2);
                        ib_my_pager.setImageResource(R.mipmap.btn_my_pre);
                        tv_my_page.setTextColor(getResources().getColor(R.color.colorPressed));
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    /**
     * 添加View
     */
    private void initList() {

        TabFragment1 fragment1 = new TabFragment1();
        TabFragment2 fragment2 = new TabFragment2();
        TabFragment3 fragment3 = new TabFragment3();
        fragmentList.add(fragment1);
        fragmentList.add(fragment2);
        fragmentList.add(fragment3);
    }

    @Override
    public void onClick(View view) {

        setTabImageNormal();

        switch (view.getId()){
            case R.id.ll_tab1_know:
                //设置viewpager当前的item
                viewPager_tab1.setCurrentItem(0);
                ib_know.setImageResource(R.mipmap.btn_know_pre);
                tv_know.setTextColor(getResources().getColor(R.color.colorPressed));
                break;
            case R.id.ll_tab1_want_to_know:
                //设置viewpager当前的item
                viewPager_tab1.setCurrentItem(1);
                ib_want_to_know.setImageResource(R.mipmap.btn_wantknow_pre);
                tv_want_to_know.setTextColor(getResources().getColor(R.color.colorPressed));
                break;
            case R.id.ll_tab1_my_pager:
                //设置viewpager当前的item
                viewPager_tab1.setCurrentItem(2);
                ib_my_pager.setImageResource(R.mipmap.btn_my_pre);
                tv_my_page.setTextColor(getResources().getColor(R.color.colorPressed));
                break;
            default:
                break;
        }
    }

    /**
     * 使所有Tab图片正常
     */
    public void setTabImageNormal(){

        ib_know.setImageResource(R.mipmap.btn_know_nor);
        ib_want_to_know.setImageResource(R.mipmap.btn_wantknow_nor);
        ib_my_pager.setImageResource(R.mipmap.btn_my_nor);
        int normalColor = getResources().getColor(R.color.colorNormal);
        tv_know.setTextColor(normalColor);
        tv_want_to_know.setTextColor(normalColor);
        tv_my_page.setTextColor(normalColor);
    }
}
