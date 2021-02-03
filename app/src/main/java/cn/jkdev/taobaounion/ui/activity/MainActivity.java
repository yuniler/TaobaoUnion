package cn.jkdev.taobaounion.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jkdev.taobaounion.R;
import cn.jkdev.taobaounion.base.BaseFragment;
import cn.jkdev.taobaounion.ui.fragment.HomeFragment;
import cn.jkdev.taobaounion.ui.fragment.RedPacketFragment;
import cn.jkdev.taobaounion.ui.fragment.SearchFragment;
import cn.jkdev.taobaounion.ui.fragment.SelectedFragment;
import cn.jkdev.taobaounion.utils.LogUtils;

public class MainActivity extends AppCompatActivity {
//    private static final String TAG = "MainActivity";
    @BindView(R.id.main_navigation_bar)//直接找id，不用fvbi
    public BottomNavigationView mNavigationView;
    private HomeFragment mHomeFragment;
    private RedPacketFragment mRedPacketFragment;
    private SelectedFragment mSelectedFragment;
    private SearchFragment mSearchFragment;
    private FragmentManager mFm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

//        initView();
        initFragments();
        initListener();
    }

    private void initFragments() {
        mHomeFragment = new HomeFragment();
        mRedPacketFragment = new RedPacketFragment();
        mSelectedFragment = new SelectedFragment();
        mSearchFragment = new SearchFragment();
        mFm = getSupportFragmentManager();
        switchFragment(mHomeFragment);//默认选中
    }

    private void initListener() {
        mNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

//                Log.d(TAG," title -- > " + item.getTitle() + "id -- > " + item.getItemId());
                if (item.getItemId() == R.id.home){
                    LogUtils.d(MainActivity.class,"切换到首页");
                    switchFragment(mHomeFragment);
                }else if (item.getItemId() == R.id.selected){
                    LogUtils.i(MainActivity.class,"切换到精选");
                    switchFragment(mRedPacketFragment);
                }else if(item.getItemId() == R.id.red_packet){
                    LogUtils.w(MainActivity.class,"切换到特惠");
                    switchFragment(mSelectedFragment);
                }else if(item.getItemId() == R.id.search){
                    LogUtils.e(MainActivity.class,"切换到搜索");
                    switchFragment(mSearchFragment);
                }
                return true;//表示使用了该事件
            }
        });
    }

    private void switchFragment(BaseFragment targetFragment) {
        FragmentTransaction fragmentTransaction = mFm.beginTransaction();
        fragmentTransaction.replace(R.id.main_pager_container,targetFragment);
        fragmentTransaction.commit();
    }

//    private void initView() {
////        mNavigationView = this.findViewById(R.id.main_navigation_bar); --使用黄油刀
//
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction transaction = fm.beginTransaction();//拿到该事物
//        transaction.add(R.id.main_pager_container,homeFragment);//容器id,fragment
//        transaction.commit();//最后一定提交事物,如果不提交不会显示
//
//    }
}
