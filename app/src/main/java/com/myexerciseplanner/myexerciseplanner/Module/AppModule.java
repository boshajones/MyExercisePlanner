package com.myexerciseplanner.myexerciseplanner.Module;

import android.support.annotation.NonNull;

import com.myexerciseplanner.myexerciseplanner.DataProvider.ExerciseDataProvider;
import com.myexerciseplanner.myexerciseplanner.Repository.ExerciseRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @NonNull
    @Singleton
    public ExerciseRepository provideExerciseRepository(ExerciseDataProvider exerciseDataProvider){
        return new ExerciseRepository(exerciseDataProvider);
    }

}
