package com.myexerciseplanner.myexerciseplanner.Dagger;

import com.myexerciseplanner.myexerciseplanner.ExerciseActivity;
import com.myexerciseplanner.myexerciseplanner.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { DataProviderModule.class })
public interface DataProviderComponent {
    void inject(MainActivity mainActivity);
    void inject(ExerciseActivity healthAndFitnessActivity);
}