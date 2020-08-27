package com.example.photoeditor;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.example.photoeditor.Interface.EditImageFragmentListner;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class EditImageFragment extends BottomSheetDialogFragment implements SeekBar.OnSeekBarChangeListener {

  private EditImageFragmentListner listner;
  SeekBar seekbar_brightness , seekbar_constrain , seekbar_saturation;

    public void setListner(EditImageFragmentListner listner) {
        this.listner = listner;
    }

    static  EditImageFragment instance;

    public static EditImageFragment getInstance(){

        if(instance== null)
            instance = new EditImageFragment();
        return instance;
    }



    public EditImageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView =  inflater.inflate(R.layout.fragment_edit_image, container, false);

        seekbar_brightness = (SeekBar)itemView.findViewById(R.id.seekbar_brightness);
        seekbar_constrain = (SeekBar)itemView.findViewById(R.id.seekbar_constrain);
        seekbar_saturation = (SeekBar)itemView.findViewById(R.id.seekbar_saturation);

        seekbar_brightness.setMax(200);
        seekbar_brightness.setProgress(100);

        seekbar_constrain.setMax(20);
        seekbar_constrain.setProgress(0);

        seekbar_saturation.setMax(30);
        seekbar_brightness.setProgress(10);


        seekbar_brightness.setOnSeekBarChangeListener(this);
        seekbar_constrain.setOnSeekBarChangeListener(this);
        seekbar_saturation.setOnSeekBarChangeListener(this);


        return itemView;



    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        if (listner != null)
        {
            if(seekBar.getId() == R.id.seekbar_brightness)
            {
                listner.onBrightnessChanged(progress-100);
            }
            else if(seekBar.getId() == R.id.seekbar_constrain)
            {
                progress+=10;
                float value = .10f*progress;
                listner.onConstrantChanged(value);
            }
            else if (seekBar.getId() == R.id.seekbar_saturation) {

                float value = .10f*progress;
                listner.onSaturationChanged(value);

            }
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

        if(listner != null)
            listner.onEditStarted();
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if(listner != null)
            listner.onEditCompleted();
    }

    public void resetControls(){
        seekbar_brightness.setProgress(100);
        seekbar_constrain.setProgress(0);
        seekbar_saturation.setProgress(10);
    }
}