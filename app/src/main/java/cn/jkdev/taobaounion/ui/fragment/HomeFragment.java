package cn.jkdev.taobaounion.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import cn.jkdev.taobaounion.R;
import cn.jkdev.taobaounion.base.BaseFragment;

/**
 * 有四个fragent一样，抽取基类,
 */
public class HomeFragment extends BaseFragment {
    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_home;
    }


//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_home,container,false);
//    }
}
