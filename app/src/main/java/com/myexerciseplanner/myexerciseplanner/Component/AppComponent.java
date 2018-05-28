package com.myexerciseplanner.myexerciseplanner.Component;

import com.myexerciseplanner.myexerciseplanner.Module.DataProviderModule;
import com.myexerciseplanner.myexerciseplanner.Module.RepositoryModule;
import com.myexerciseplanner.myexerciseplanner.ViewModel.MainViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = { DataProviderModule.class, RepositoryModule.class})
@Singleton
public interface AppComponent {
    void inject(MainViewModel mainViewModel);

}
