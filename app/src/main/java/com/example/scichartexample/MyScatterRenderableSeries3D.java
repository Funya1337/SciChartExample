package com.example.scichartexample;

import com.scichart.charting3d.visuals.renderableSeries.hitTest.HitTestInfo3D;
import com.scichart.charting3d.visuals.renderableSeries.scatter.ScatterRenderableSeries3D;

public class MyScatterRenderableSeries3D extends ScatterRenderableSeries3D {
    @Override
    public void performSelection(HitTestInfo3D hitTestInfo3D) {
        super.performSelection(hitTestInfo3D);
        System.out.println("hitTestInfo3D.vertexId");
        System.out.println(hitTestInfo3D.vertexId);
        System.out.println("hitTestInfo3D.isHit");
        System.out.println(hitTestInfo3D.isHit);
    }
}
