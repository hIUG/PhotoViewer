package com.e.c.a.h.photoviewer.view.detail;

/**
 * Created by hugoa on 6/21/2017.
 */

public class DetailPresenter implements DetailContract.Presenter {

    private DetailContract.View view;

    @Override
    public void attachView(DetailContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
