package com.myexerciseplanner.myexerciseplanner;

import android.app.Application;

import com.myexerciseplanner.myexerciseplanner.Component.AppComponent;
import com.myexerciseplanner.myexerciseplanner.Component.DaggerAppComponent;
import com.myexerciseplanner.myexerciseplanner.Module.DataProviderModule;
import com.myexerciseplanner.myexerciseplanner.Module.RepositoryModule;

public class App extends Application {
    private static AppComponent mAppComponent;
    public static AppComponent getComponent(){
        return mAppComponent;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        mAppComponent = buildComponent();
    }

    protected AppComponent buildComponent(){
        return DaggerAppComponent.builder()
                .dataProviderModule(new DataProviderModule())
                .repositoryModule(new RepositoryModule())
                .build();
    }

}
