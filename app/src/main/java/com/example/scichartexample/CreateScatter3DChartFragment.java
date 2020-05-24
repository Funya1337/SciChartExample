package com.example.scichartexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.scichart.charting3d.model.dataSeries.xyz.XyzDataSeries3D;
import com.scichart.charting3d.visuals.SciChartSurface3D;
import com.scichart.charting3d.visuals.axes.NumericAxis3D;
import com.scichart.charting3d.visuals.camera.Camera3D;
import com.scichart.charting3d.visuals.pointMarkers.EllipsePointMarker3D;
import com.scichart.charting3d.visuals.renderableSeries.scatter.ScatterRenderableSeries3D;
import com.scichart.drawing.utility.ColorUtil;
import com.scichart.extensions3d.builders.SciChart3DBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateScatter3DChartFragment extends Fragment {
    @BindView(R.id.chart3d)
    SciChartSurface3D surface3d;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.scatter3d_chart_fragment, null);
        ButterKnife.bind(this, rootView);
        initExample();
        return rootView;
    }

    protected final SciChart3DBuilder sciChart3DBuilder = SciChart3DBuilder.instance();

    protected void initExample() {
        final Camera3D camera = sciChart3DBuilder.newCamera3D().build();

        final NumericAxis3D xAxis = sciChart3DBuilder.newNumericAxis3D().withGrowBy(.1, .1).build();
        final NumericAxis3D yAxis = sciChart3DBuilder.newNumericAxis3D().withGrowBy(.1, .1).build();
        final NumericAxis3D zAxis = sciChart3DBuilder.newNumericAxis3D().withGrowBy(.1, .1).build();
        final XyzDataSeries3D<Double, Double, Double> dataSeries = new XyzDataSeries3D<>(Double.class, Double.class, Double.class);
        for (int i = 0; i < 5; i++) {
            final double x = i;
            final double y = i;
            final double z = i;
            dataSeries.append(x, y, z);
        }
        final EllipsePointMarker3D pointMarker3D = sciChart3DBuilder.newEllipsePointMarker3D()
                .withFill(ColorUtil.LimeGreen)
                .withSize(2f)
                .build();
        final ScatterRenderableSeries3D rs = sciChart3DBuilder.newScatterSeries3D()
                .withDataSeries(dataSeries)
                .withPointMarker(pointMarker3D)
                .build();
        surface3d.setCamera(camera);
        surface3d.setXAxis(xAxis);
        surface3d.setYAxis(yAxis);
        surface3d.setZAxis(zAxis);
        surface3d.getRenderableSeries().add(rs);
        surface3d.getChartModifiers().add(sciChart3DBuilder.newModifierGroupWithDefaultModifiers().build());
    }
}
