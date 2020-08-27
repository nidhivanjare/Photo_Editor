package com.example.photoeditor.Adapter;

import android.content.Context;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.photoeditor.Interface.FiltersListFragmentListner;
import com.example.photoeditor.R;
import com.zomato.photofilters.utils.ThumbnailItem;

import java.util.List;

public class ThumbnailAdapter extends RecyclerView.Adapter<ThumbnailAdapter.MyViewHolder> {


    private List<ThumbnailItem> thumbnailItems;
    private FiltersListFragmentListner listner;
    private Context context;
    private int selectedIndex = 0;

    public ThumbnailAdapter(List<ThumbnailItem> thumbnailItems , FiltersListFragmentListner listner , Context context) {
        this.thumbnailItems = thumbnailItems;
        this.listner = listner;
        this.context = context;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itenView = LayoutInflater.from(context).inflate(R.layout.thumnail_item ,parent,false);
        return new MyViewHolder(itenView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

       final ThumbnailItem thumbnailItem = thumbnailItems.get(position);


        holder.thumbnail.setImageBitmap(thumbnailItem.image);
        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listner.onFilterSelected(thumbnailItem.filter);
                selectedIndex = position;
                notifyDataSetChanged();

            }
        });

        holder.filter_name.setText(thumbnailItem.filterName);

        if(selectedIndex == position)
            holder.filter_name.setTextColor(ContextCompat.getColor(context,R.color.selected_filter));
        else
            holder.filter_name.setTextColor(ContextCompat.getColor(context,R.color.normal_filter));

    }

    @Override
    public int getItemCount() {
        return thumbnailItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView thumbnail;
        TextView filter_name;


        public MyViewHolder( View itemView) {
            super(itemView);
            thumbnail = (ImageView)itemView.findViewById(R.id.thumbnail);
            filter_name = (TextView)itemView.findViewById(R.id.filter_name);
        }
    }
}
