package com.myexerciseplanner.myexerciseplanner.Application;


import android.app.Application;

import com.myexerciseplanner.myexerciseplanner.Dagger.DaggerDataProviderComponent;
import com.myexerciseplanner.myexerciseplanner.Dagger.DataProviderComponent;

public class MyApp extends Application {

    private DataProviderComponent mDataProviderComponent;

    @Override
    public void onCreate(){
        super.onCreate();

        mDataProviderComponent = DaggerDataProviderComponent.builder().build();
    }

    public DataProviderComponent getDataProviderComponent() {
        return mDataProviderComponent;
    }
}
