package com.e.c.a.h.photoviewer.view.home;

import com.e.c.a.h.photoviewer.model.Photo;

import java.util.List;


/**
 * Created by hugoa on 6/20/2017.
 */

public class HomeContract {
    public interface View {
        void updatePhotoList(List<Photo> result);
        void showMessage(String msg);
    }

    public interface Presenter<V extends View> {
        void attachView(V view);
        void detachView();
        void getPhotos();
    }
}
