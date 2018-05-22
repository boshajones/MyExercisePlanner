package com.myexerciseplanner.myexerciseplanner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.myexerciseplanner.myexerciseplanner.Application.MyApp;
import com.myexerciseplanner.myexerciseplanner.Models.Feature;
import com.myexerciseplanner.myexerciseplanner.Providers.IDataProvider;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject IDataProvider mDataProvider;

    private List<Feature> mFeatures;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MyApp) getApplication()).getDataProviderComponent().inject(this);

        mFeatures = mDataProvider.getFeatures(this);
    }
}
