package com.myexerciseplanner.myexerciseplanner.ViewModel;

import android.arch.lifecycle.ViewModel;

import com.myexerciseplanner.myexerciseplanner.Component.DaggerAppComponent;
import com.myexerciseplanner.myexerciseplanner.Repository.ExerciseRepository;

import javax.inject.Inject;

public class MainViewModel extends ViewModel {

    @Inject ExerciseRepository mExerciseRepository;

    public MainViewModel(){
        DaggerAppComponent.builder().build().inject(this);
    }

    public String getSomeText(){
        return mExerciseRepository.getSomeText();
    }
}
