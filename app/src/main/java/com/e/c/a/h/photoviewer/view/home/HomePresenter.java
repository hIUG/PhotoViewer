package com.e.c.a.h.photoviewer.view.home;

import android.util.Log;

import com.e.c.a.h.photoviewer.model.Photo;
import com.e.c.a.h.photoviewer.rest.api.PhotoAPIHelper;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hugoa on 6/20/2017.
 */

public class HomePresenter implements HomeContract.Presenter {
    private static final String TAG = HomePresenter.class.getSimpleName();
    HomeContract.View view;
    List<Photo> photos;

    @Override
    public void attachView(HomeContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void getPhotos() {
        photos = new ArrayList<>();
        Observable<List<Photo>> getPhotosObservable = PhotoAPIHelper.createGetPhotosObservable();

        getPhotosObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Photo>>() {
                    @Override
                    public void onCompleted() {
                        view.updatePhotoList(photos);
                        Log.d(TAG, "onCompleted: received: " + photos.size());
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showMessage("There was an error trying to fetch the pictures...");
                        Log.e(TAG, "onError: when trying to get the photos", e);
                    }

                    @Override
                    public void onNext(List<Photo> nextPhotos) {
                        photos.addAll(nextPhotos);
                        Log.d(TAG, "onNext: received: " + nextPhotos.size());
                    }
                });
    }
}
