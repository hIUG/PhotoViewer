package com.e.c.a.h.photoviewer.rest.api;

import com.e.c.a.h.photoviewer.model.Photo;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by hugoa on 6/20/2017.
 */

public interface PhotoAPI {
    @GET("photos")
    Observable<List<Photo>> getPhotos();
}
