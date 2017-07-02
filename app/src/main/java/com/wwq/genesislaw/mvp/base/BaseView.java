package com.wwq.genesislaw.mvp.base;

/**
 * Created by wwq on 2016/10/30.
 */

public interface BaseView {

    void isEmptyToken();

    void showDialog();

    void onFail(String err);

    void hideDialog();
}