package com.myexerciseplanner.myexerciseplanner.DataProvider;

import javax.inject.Inject;

public class ExerciseDataProvider {

    @Inject
    public ExerciseDataProvider(){

    }

    public String getSomeText(){
        return "SomeTextFromDataProvider";
    }
}
