package cn.jkdev.taobaounion.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jkdev.taobaounion.R;
import cn.jkdev.taobaounion.utils.LogUtils;

public class TestActivity extends Activity {


    @BindView(R.id.test_navigation_bar)
    public RadioGroup navigationBar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        initListener();

    }

    private void initListener() {
        navigationBar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                LogUtils.d(TestActivity.class,"checkedId -- >" + checkedId);
                switch (checkedId){
                    case R.id.test_home:
                        LogUtils.d(TestActivity.class, "切换的首页");
                        break;
                    case R.id.test_selected:
                        LogUtils.d(TestActivity.class,"切换到精选");
                        break;
                    case R.id.test_red_packet:
                        LogUtils.d(TestActivity.class,"切换到特惠");
                        break;
                    case R.id.test_search:
                        LogUtils.d(TestActivity.class,"切换到搜索");
                        break;
                }
            }
        });
    }
}
