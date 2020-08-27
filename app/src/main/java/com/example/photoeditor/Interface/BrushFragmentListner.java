package com.example.photoeditor.Interface;

public interface BrushFragmentListner  {

    void onBrushSizeChangedListner(float size);
    void  onBrushOpacityChangedListner(int opacity);
    void onBrushColorChangedListner(int color);
    void  onBrushStateChangedListner(boolean isEraser);
}
