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
            SciChartSurface.setRuntimeLicenseKey("CkjezKYyc/qC/tgy3SM0GNg4nhISgFf5oC88YHDGWvdCoxTauvDNN1HHztBlSs1EHylcctQlvSKJx6lP1pmdEWWNjzFVdmwDMx6fCpdWCeJURWin5LutOTMrnP9DDQnn9w9kUMsMpiguFXAVGcrn3f5/bTWqanZHkWdj5Don9IO5E3r5tyAR6IZlbyQQogNdpTGkOYzmoids7Mi+qXba6KYEyxl/jDjabKtX9OahRW06Nl+u4zwQzYEbOcGSjYEi57IgnX7qc8Rwu01DI80fi1hL3IxYm+wehmVGmlHtYGKSyma6kArOSJXNHe5WJQ6V7YyUnOSBoIXdyTCUE+zh4AOcSTS64c7Uw+FFkedih+zUS6gaG4xFjg7gUXuYtnUc8fBwO70FAcombPOzKpmkT4LG89lt70rm9MspkhEmLhuLe4uegCI7RkX8HWyT9Eyl2O11nCcYfc2XlkHxe5miRLuE4IOUNd8GxKq2");
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
