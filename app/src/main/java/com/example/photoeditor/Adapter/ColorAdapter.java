package com.example.photoeditor.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.photoeditor.R;

import java.util.ArrayList;
import java.util.List;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ColorViewHolder> {


    Context context;
    List<Integer> colorList;
    ColorAdapterListner listner;

    public ColorAdapter(Context context  , ColorAdapterListner listner) {
        this.context = context;
        this.colorList = genColorList();
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


    private List<Integer> genColorList() {

        List<Integer> colorList = new ArrayList<>();

        colorList.add(Color.parseColor("#C996E6"));
        colorList.add(Color.parseColor("#C2E6C7"));
        colorList.add(Color.parseColor("#5AD8E6"));
        colorList.add(Color.parseColor("#FFFEFD"));
        colorList.add(Color.parseColor("#FFEBF4"));
        colorList.add(Color.parseColor("#79CBFF"));
        colorList.add(Color.parseColor("#64FDFF"));
        colorList.add(Color.parseColor("#FF5973"));
        colorList.add(Color.parseColor("#396050"));
        colorList.add(Color.parseColor("#2F4F60"));
        colorList.add(Color.parseColor("#603646"));
        colorList.add(Color.parseColor("#A4799B"));
        colorList.add(Color.parseColor("#187FA4"));
        colorList.add(Color.parseColor("#87CB25"));
        colorList.add(Color.parseColor("#F8F975"));
        colorList.add(Color.parseColor("#131722"));
        colorList.add(Color.parseColor("#e7a68a"));
        colorList.add(Color.parseColor("#a0c4e2"));
        colorList.add(Color.parseColor("#294d6c"));
        colorList.add(Color.parseColor("#cbe0ff"));
        colorList.add(Color.parseColor("#cbcba9"));
        colorList.add(Color.parseColor("#6d8f7b"));
        colorList.add(Color.parseColor("#ff0000"));
        colorList.add(Color.parseColor("#ef7a85"));
        colorList.add(Color.parseColor("#66cdaa"));
        colorList.add(Color.parseColor("#2e8b57"));
        colorList.add(Color.parseColor("#F2C532"));
        colorList.add(Color.parseColor("#2F75E4"));
        colorList.add(Color.parseColor("#E5AD35"));



        return colorList;
    }


    public  interface ColorAdapterListner {
        void onColorSelected(int color);
    }
}
