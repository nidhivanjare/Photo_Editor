package com.example.photoeditor.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.photoeditor.R;

import java.util.List;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ColorViewHolder> {


    Context context;
    List<Integer> colorList;
    ColorAdapterListner listner;

    public ColorAdapter(Context context , List<Integer> colorList , ColorAdapterListner listner) {
        this.context = context;
        this.colorList = colorList;
        this.listner = listner;
    }

    @NonNull
    @Override
    public ColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.color_item,parent,false);
        return new ColorViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewHolder holder, int position) {
        holder.color_section.setCardBackgroundColor(colorList.get(position));

    }

    @Override
    public int getItemCount() {
        return colorList.size();
    }


    public class ColorViewHolder extends RecyclerView.ViewHolder {

        public CardView color_section;

        public ColorViewHolder(View itemView) {
            super(itemView);
            color_section = (CardView)itemView.findViewById(R.id.color_section);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listner.onColorSelected(colorList.get(getAdapterPosition()));
                }
            });
        }
    }

    public  interface ColorAdapterListner {
        void onColorSelected(int color);
    }
}
