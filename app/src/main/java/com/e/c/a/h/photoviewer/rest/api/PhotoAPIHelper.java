package com.e.c.a.h.photoviewer.rest.api;

import com.e.c.a.h.photoviewer.model.Photo;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by hugoa on 6/20/2017.
 */

public class PhotoAPIHelper {
    private final static String BASE_URL = "http://jsonplaceholder.typicode.com/";

    public static Retrofit create() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();

        return retrofit;
    }

    public static Observable<List<Photo>> createGetPhotosObservable() {
        Retrofit retrofit = create();
        PhotoAPI api = retrofit.create(PhotoAPI.class);
        return api.getPhotos();
    }
}
