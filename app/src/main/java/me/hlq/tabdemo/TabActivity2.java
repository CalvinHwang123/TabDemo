package me.hlq.tabdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
/**
 * 实现Tab方案二：
 * 仅使用Fragment实现
 * 但是Fragment不能滑动（如：QQ）（因为没有使用ViewPager之类的组件）
 * TabActivity2继承的是FragmentActivity
 *
 * @author HLQ 2016/10/23
 */
public class TabActivity2 extends FragmentActivity implements View.OnClickListener {

    private LinearLayout ll_tab1_know;
    private LinearLayout ll_tab1_want_to_know;
    private LinearLayout ll_tab1_my_pager;

    private ImageButton ib_know;
    private ImageButton ib_want_to_know;
    private ImageButton ib_my_pager;
    private TextView tv_know;
    private TextView tv_want_to_know;
    private TextView tv_my_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab2);

        initView();
        setListener();

        //默认加载第一个fragment
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fl_tab_activity2_container,new TabFragment1())
                .commit();
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
    }

    @Override
    public void onClick(View view) {

        setTabImageNormal();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (view.getId()) {
            case R.id.ll_tab1_know:
                ib_know.setImageResource(R.mipmap.btn_know_pre);
                tv_know.setTextColor(getResources().getColor(R.color.colorPressed));
                transaction.replace(R.id.fl_tab_activity2_container,new TabFragment1());
                transaction.commit();

                break;
            case R.id.ll_tab1_want_to_know:
                ib_want_to_know.setImageResource(R.mipmap.btn_wantknow_pre);
                tv_want_to_know.setTextColor(getResources().getColor(R.color.colorPressed));
                transaction.replace(R.id.fl_tab_activity2_container,new TabFragment2());
                transaction.commit();

                break;
            case R.id.ll_tab1_my_pager:
                ib_my_pager.setImageResource(R.mipmap.btn_my_pre);
                tv_my_page.setTextColor(getResources().getColor(R.color.colorPressed));
                transaction.replace(R.id.fl_tab_activity2_container,new TabFragment3());
                transaction.commit();

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
