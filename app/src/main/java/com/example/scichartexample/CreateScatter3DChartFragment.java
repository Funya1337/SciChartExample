package com.example.scichartexample;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.scichart.charting3d.model.dataSeries.xyz.XyzDataSeries3D;
import com.scichart.charting3d.modifiers.CrosshairMode;
import com.scichart.charting3d.modifiers.IChartModifier3D;
import com.scichart.charting3d.modifiers.ModifierGroup3D;
import com.scichart.charting3d.modifiers.OrbitModifier3D;
import com.scichart.charting3d.modifiers.TooltipModifier3D;
import com.scichart.charting3d.modifiers.VertexSelectionModifier3D;
import com.scichart.charting3d.visuals.SciChartSurface3D;
import com.scichart.charting3d.visuals.axes.NumericAxis3D;
import com.scichart.charting3d.visuals.camera.Camera3D;
import com.scichart.charting3d.visuals.pointMarkers.SpherePointMarker3D;
import com.scichart.charting3d.visuals.renderableSeries.metadataProviders.DefaultSelectableMetadataProvider3D;
import com.scichart.charting3d.visuals.renderableSeries.metadataProviders.PointMetadataProvider3D;
import com.scichart.charting3d.visuals.renderableSeries.scatter.ScatterRenderableSeries3D;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.drawing.utility.ColorUtil;
import com.scichart.extensions3d.builders.SciChart3DBuilder;

import java.util.ArrayList;

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
//        surface3d.setIsAxisCubeVisible(false);

        final NumericAxis3D xAxis = sciChart3DBuilder.newNumericAxis3D().withGrowBy(.2, .2).build();
        final NumericAxis3D yAxis = sciChart3DBuilder.newNumericAxis3D().withGrowBy(.05, .05).build();
        final NumericAxis3D zAxis = sciChart3DBuilder.newNumericAxis3D().withGrowBy(.2, .2).build();

        final XyzDataSeries3D<Double, Double, Double> xyzDataSeries3D = new XyzDataSeries3D<>(Double.class, Double.class, Double.class);
        final PointMetadataProvider3D metadataProvider = new PointMetadataProvider3D();
        final ArrayList<PointMetadataProvider3D.PointMetadata3D> medatata = metadataProvider.metadata;

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                for (int k=0; k<3; k++) {
                    xyzDataSeries3D.append((double)i, (double)j, (double)k);
                    final int color = Color.parseColor("#00FF00");
                    final float scale = 40;
                    medatata.add(new PointMetadataProvider3D.PointMetadata3D(color, scale));
                }
            }
        }


        final SpherePointMarker3D pointMarker = sciChart3DBuilder.newSpherePointMarker3D()
                .withFill(ColorUtil.LimeGreen)
                .withSize(80f)
                .build();

        MyScatterRenderableSeries3D rs = new MyScatterRenderableSeries3D();
        rs.setDataSeries(xyzDataSeries3D);
        rs.setPointMarker(pointMarker);
        rs.setMetadataProvider(new DefaultSelectableMetadataProvider3D());
        UpdateSuspender.using(surface3d, () -> {
            surface3d.setCamera(camera);

            surface3d.setXAxis(xAxis);
            surface3d.setYAxis(yAxis);
            surface3d.setZAxis(zAxis);

            surface3d.getRenderableSeries().add(rs);

            VertexSelectionModifier3D selectModifier = new MyVertexSelectionModifier3D();
            selectModifier.setReceiveHandledEvents(true);
            OrbitModifier3D orbitModifier = new OrbitModifier3D();
            orbitModifier.setReceiveHandledEvents(true);

//            boolean modifier = sciChart3DBuilder.newModifierGroup()
//                    .withVertexSelectionModifier().withReceiveHandledEvents(true).build()
//                    .withPinchZoomModifier3D().build()
//                    .withOrbitModifier3D().withReceiveHandledEvents(true).build()
//                    .withZoomExtentsModifier3D().build()
//                    .build();
            surface3d.getChartModifiers().add(new ModifierGroup3D(selectModifier, orbitModifier));
        });
    }
    private boolean callBack() {
        System.out.println("event1");
        return true;
    }
}
