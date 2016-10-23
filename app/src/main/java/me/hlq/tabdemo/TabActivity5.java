package me.hlq.tabdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * 实现Tab方案五：
 * 使用RadioGroup+Fragment实现
 * 但是Fragment不能滑动（如：QQ）（因为没有使用ViewPager之类的组件）
 *
 * @author HLQ 2016/10/23
 */
public class TabActivity5 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    RadioGroup radioGroup;
    RadioButton rb_know;
    RadioButton rb_want_to_know;
    RadioButton rb_my_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab5);

        findViewById();

        //默认加载第一个fragment
        radioGroup.check(R.id.rb_know);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_container,new TabFragment1(),null)
                .commit();
        rb_know.setTextColor(getResources().getColor(R.color.colorPressed));
        radioGroup.setOnCheckedChangeListener(this);
    }

    private void findViewById() {

        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        rb_know = (RadioButton) findViewById(R.id.rb_know);
        rb_want_to_know = (RadioButton) findViewById(R.id.rb_want_to_know);
        rb_my_page = (RadioButton) findViewById(R.id.rb_my_page);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        setTabStatusNormal();
        switch (i){
            case R.id.rb_know:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl_container,new TabFragment1(),null)
                        .commit();
                rb_know.setTextColor(getResources().getColor(R.color.colorPressed));
                break;
            case R.id.rb_want_to_know:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl_container,new TabFragment2(),null)
                        .commit();
                rb_want_to_know.setTextColor(getResources().getColor(R.color.colorPressed));
                break;
            case R.id.rb_my_page:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl_container,new TabFragment3(),null)
                        .commit();
                rb_my_page.setTextColor(getResources().getColor(R.color.colorPressed));
                break;
        }
    }

    /**
     * 使Tab图标正常
     */
    private void setTabStatusNormal() {
        int normalColor = getResources().getColor(R.color.colorNormal);
        rb_know.setTextColor(normalColor);
        rb_want_to_know.setTextColor(normalColor);
        rb_my_page.setTextColor(normalColor);
    }
}
