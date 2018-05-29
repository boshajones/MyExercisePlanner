package com.myexerciseplanner.myexerciseplanner.Component;

import com.myexerciseplanner.myexerciseplanner.Module.AppModule;
import com.myexerciseplanner.myexerciseplanner.ViewModel.ExerciseViewModel;
import com.myexerciseplanner.myexerciseplanner.ViewModel.MainViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = { AppModule.class})
@Singleton
public interface AppComponent {
    void inject(MainViewModel mainViewModel);
    void inject(ExerciseViewModel exerciseViewModel);

}
