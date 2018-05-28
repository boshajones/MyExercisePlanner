package com.myexerciseplanner.myexerciseplanner.Module;

import android.support.annotation.NonNull;

import com.myexerciseplanner.myexerciseplanner.DataProvider.ExerciseDataProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataProviderModule {

    @Provides
    @NonNull
    @Singleton
    public ExerciseDataProvider provideExerciseDataProvider(){
        return new ExerciseDataProvider();
    }

}
