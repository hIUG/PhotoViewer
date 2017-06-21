package com.e.c.a.h.photoviewer.view.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.e.c.a.h.photoviewer.R;
import com.e.c.a.h.photoviewer.model.Photo;
import com.e.c.a.h.photoviewer.model.adapter.PhotoAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements HomeContract.View {

    RecyclerView rv;
    RecyclerView.LayoutManager lm;
    PhotoAdapter adapter;
    List<Photo> photos;
    HomeContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        photos = new ArrayList<>();
        rv = (RecyclerView) findViewById(R.id.rv);
        lm = new GridLayoutManager(this, 2);
        adapter = new PhotoAdapter(photos);

        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);

        presenter = new HomePresenter();
        presenter.attachView(this);
        presenter.getPhotos();
    }

    @Override
    public void updatePhotoList(List<Photo> result) {
        this.photos.clear();
        this.photos.addAll(result);
        this.adapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
