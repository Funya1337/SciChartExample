package com.example.scichartexample;

import android.view.MotionEvent;

import com.scichart.charting.visuals.renderableSeries.IRenderableSeriesCore;
import com.scichart.charting3d.modifiers.VertexSelectionModifier3D;
import com.scichart.core.observable.CollectionChangedEventArgs;
import com.scichart.core.utility.touch.ModifierTouchEventArgs;

public class MyVertexSelectionModifier3D extends VertexSelectionModifier3D {

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        System.out.println("e.getX()");
        System.out.println(e.getX());
        return super.onSingleTapConfirmed(e);
    }
}
