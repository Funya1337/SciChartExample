package com.example.scichartexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.extensions.builders.SciChartBuilder;
import com.scichart.extensions3d.builders.SciChart3DBuilder;
import io.github.cdimascio.dotenv.Dotenv;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            SciChartSurface.setRuntimeLicenseKey("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        SciChartBuilder.init(this);
        SciChart3DBuilder.init(this);

        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = MainActivity.this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        CreateScatter3DChartFragment exampleFragment = new CreateScatter3DChartFragment();
        fragmentTransaction.add(R.id.frameContainer, exampleFragment);
        fragmentTransaction.commit();
    }
}
