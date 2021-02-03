package cn.jkdev.taobaounion.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * 抽取基类。相同的fragment
 * 只是不同的view，进行abstract子类传递就可以
 */
public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {//创建view
        return loadRootView(inflater,container,savedInstanceState);
    }

    protected View loadRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){//加载view.  id,container,false
        int resId = getRootViewResId();
        return inflater.inflate(resId,container,false);
    }//返回view

    protected abstract int getRootViewResId();//子类实现返回id


}
