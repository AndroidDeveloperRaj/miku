package com.biubiu.miku.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by luis on 2016/11/21.
 */

public abstract class BaseMvpFragment<V extends BaseView, T extends BasePresenter<V>> extends BaseFragment {

    private T mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = initPresenter();
        mPresenter.attachView((V) this);
    }

    @Override
    public void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }

    protected T getMvpPresenter() {
        return mPresenter;
    }

    protected abstract T initPresenter();

}
