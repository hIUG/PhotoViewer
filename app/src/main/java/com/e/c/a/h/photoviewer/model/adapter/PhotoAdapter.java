package com.e.c.a.h.photoviewer.model.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.e.c.a.h.photoviewer.R;
import com.e.c.a.h.photoviewer.model.Photo;
import com.e.c.a.h.photoviewer.view.detail.DetailActivity;

import java.util.List;

/**
 * Created by hugoa on 6/20/2017.
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {

    private List<Photo> photos;

    public PhotoAdapter(List<Photo> photos) {
        this.photos = photos;
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_item, parent, false);

        return new PhotoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final PhotoViewHolder holder, final int position) {
        Glide.with(holder.itemImage.getContext()).load(photos.get(position).getThumbnailUrl()).into(holder.itemImage);
        holder.itemTitle.setText(photos.get(position).getTitle());
        holder.itemAlbumId.setText(photos.get(position).getAlbumId() + "");

        holder.itemLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemImage.getContext(), DetailActivity.class);
                intent.putExtra("photo", photos.get(position));
                holder.itemImage.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.photos.size();
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout itemLinearLayout;
        private ImageView itemImage;
        private TextView itemTitle;
        private TextView itemAlbumId;

        public PhotoViewHolder(View itemView) {
            super(itemView);
            itemLinearLayout = (LinearLayout) itemView.findViewById(R.id.itemLinearLayout);
            itemImage = (ImageView) itemView.findViewById(R.id.itemImage);
            itemTitle = (TextView) itemView.findViewById(R.id.itemTitle);
            itemAlbumId = (TextView) itemView.findViewById(R.id.itemAlbumId);
        }
    }
}
