package com.myexerciseplanner.myexerciseplanner.Dagger;

import com.myexerciseplanner.myexerciseplanner.Providers.IDataProvider;
import com.myexerciseplanner.myexerciseplanner.Providers.MockDataProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataProviderModule {

    @Provides
    @Singleton
    IDataProvider provideDataProvider(){
        return new MockDataProvider();
    }
}
