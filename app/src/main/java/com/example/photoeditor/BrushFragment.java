package com.example.photoeditor;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;


import android.widget.SeekBar;
import android.widget.ToggleButton;

import com.example.photoeditor.Adapter.ColorAdapter;
import com.example.photoeditor.Interface.BrushFragmentListner;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;


public class BrushFragment extends BottomSheetDialogFragment implements ColorAdapter.ColorAdapterListner {

    SeekBar seekBar_brush_size , seekBar_opacity_size;
    RecyclerView recycler_color;
    ToggleButton btn_brush_state;
    ColorAdapter colorAdapter;



    BrushFragmentListner listner;

    static  BrushFragment instance;

    public static BrushFragment getInstance()  {
        if (instance == null)
            instance = new BrushFragment();
        return instance;
    }

    public void setListner(BrushFragmentListner listner) {
        this.listner = listner;
    }

    public BrushFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_brush, container, false);

        seekBar_brush_size = (SeekBar)itemView.findViewById(R.id.seekbar_brush_size);
        seekBar_opacity_size = (SeekBar)itemView.findViewById(R.id.seekbar_brush_opacity);
        btn_brush_state = (ToggleButton) itemView.findViewById(R.id.btn_brush_state);
        recycler_color = (RecyclerView)itemView.findViewById(R.id.recycler_color);
        recycler_color.setHasFixedSize(true);
        recycler_color.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));


        colorAdapter = new ColorAdapter(getContext(),this);
        recycler_color.setAdapter(colorAdapter);

        seekBar_opacity_size.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                listner.onBrushOpacityChangedListner(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar_brush_size.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                listner.onBrushSizeChangedListner(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btn_brush_state.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                listner.onBrushStateChangedListner(isChecked);
            }
        });


        return  itemView;
    }

    @Override
    public void onColorSelected(int color) {

        listner.onBrushColorChangedListner(color);

    }
}