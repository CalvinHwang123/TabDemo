package me.hlq.tabdemo;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.viewpagerindicator.TabPageIndicator;

import me.hlq.tabdemo.adapter.Tab4Adapter;

/**
 * Tab实现方案四(顶部)：
 * ViewPager+Fragment+TabPageIndicator
 * （外加FragmentPagerAdapter，确保可以滑动切换页面）
 *
 * (有指示器的Tab一般位于顶部且不含图标)
 *
 * @author HLQ 2016/10/23
 */
public class TabActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab4);

        ViewPager viewPager_tab4 = (ViewPager) findViewById(R.id.viewPager_tab4);
        viewPager_tab4.setAdapter(new Tab4Adapter(getSupportFragmentManager()));

        TabPageIndicator title_page_indicator = (TabPageIndicator) findViewById(R.id.title_page_indicator);
        //关联TabPageIndicator和ViewPager
        title_page_indicator.setViewPager(viewPager_tab4);
    }
}
