package me.hlq.tabdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import me.hlq.tabdemo.TabFragment1;
import me.hlq.tabdemo.TabFragment2;
import me.hlq.tabdemo.TabFragment3;

/**
 * 顶部标题数据适配器
 * Created by HLQ on 2016/09/11.
 */
public class Tab4Adapter extends FragmentPagerAdapter {

    private static final String[] TITLE = {"知道","我想知道","我的主页"};

    public Tab4Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new TabFragment1();
        }else if(position==1){
            return new TabFragment2();
        }else{
            return new TabFragment3();
        }
    }

    @Override
    public int getCount() {
        return TITLE.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return TITLE[position];
    }
}
