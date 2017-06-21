package com.e.c.a.h.photoviewer.view.detail;

/**
 * Created by hugoa on 6/21/2017.
 */

public class DetailContract {
    public interface View {
    }

    public interface Presenter<V extends View> {
        void attachView(V view);
        void detachView();
    }
}
