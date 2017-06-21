package com.e.c.a.h.photoviewer.view.detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.e.c.a.h.photoviewer.R;
import com.e.c.a.h.photoviewer.model.Photo;

public class DetailActivity extends AppCompatActivity implements DetailContract.View {

    private DetailContract.Presenter presenter;
    private Photo photo;
    private ImageView detailImage;
    private TextView detailTitle;
    private TextView detailAlbumId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        presenter = new DetailPresenter();
        presenter.attachView(this);

        detailImage = (ImageView) findViewById(R.id.detailImage);
        detailTitle = (TextView) findViewById(R.id.detailTitle);
        detailAlbumId = (TextView) findViewById(R.id.detailAlbumId);

        photo = getIntent().getParcelableExtra("photo");
        fillView();
    }

    private void fillView() {
        Glide.with(this).load(photo.getUrl()).into(detailImage);
        detailTitle.setText(photo.getTitle());
        detailAlbumId.setText("" + photo.getAlbumId());
    }
}
