package com.example.scichartexample;

import com.scichart.charting3d.model.dataSeries.xyz.XyzDataSeries3D;
import com.scichart.charting3d.visuals.renderableSeries.hitTest.HitTestInfo3D;
import com.scichart.charting3d.visuals.renderableSeries.scatter.ScatterRenderableSeries3D;

public class MyScatterRenderableSeries3D extends ScatterRenderableSeries3D {

    XyzDataSeries3D<Double, Double, Double> emptyDataSeries;
    XyzDataSeries3D<Double, Double, Double> firstPlayerDataSeries;
    XyzDataSeries3D<Double, Double, Double> secondPlayerDataSeries;
    private double x, y, z;
    private boolean checker = true;

    public MyScatterRenderableSeries3D(XyzDataSeries3D<Double, Double, Double> emptyDataSeries, XyzDataSeries3D<Double, Double, Double> firstPlayerDataSeries, XyzDataSeries3D<Double, Double, Double> secondPlayerDataSeries) {
        this.emptyDataSeries = emptyDataSeries;
        this.firstPlayerDataSeries = firstPlayerDataSeries;
        this.secondPlayerDataSeries = secondPlayerDataSeries;
    }

    @Override
    public void performSelection(HitTestInfo3D hitTestInfo3D) {
        super.performSelection(hitTestInfo3D);
        checker = !checker;
        int number = (int)asBase3(hitTestInfo3D.vertexId);
        String str = "";
        int length = String.valueOf(number).length();
        if (length == 1)
            str += ("00" + number);
        else if (length == 2)
            str += ("0" + number);
        else
            str += (number + "");
        x = Integer.parseInt(String.valueOf(str.charAt(0)));
        y = Integer.parseInt(String.valueOf(str.charAt(1)));
        z = Integer.parseInt(String.valueOf(str.charAt(2)));
        emptyDataSeries.updateXAt(hitTestInfo3D.vertexId, 10000d);
        if (checker)
            firstPlayerDataSeries.append(x, y, z);
        else
            secondPlayerDataSeries.append(x, y, z);
    }
    public long asBase3(int num) {
        long ret = 0, factor = 1;
        while (num > 0) {
            ret += num % 3 * factor;
            num /= 3;
            factor *= 10;
        }
        return ret;
    }
}
