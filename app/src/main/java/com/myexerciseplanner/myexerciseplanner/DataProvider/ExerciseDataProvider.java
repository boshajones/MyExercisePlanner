package com.myexerciseplanner.myexerciseplanner.DataProvider;

import javax.inject.Inject;

public class ExerciseDataProvider {

    @Inject
    public ExerciseDataProvider(){
    }

    public String getMainFragmentSampleText(){
        return "MainFragmentSampleText";
    }

    public String getMainFragmentTwoSampleText(){
        return "MainFragmentTwoSampleText";
    }

    public String getExerciseFragmentSampleText(){
        return "ExerciseFragmentSampleText";
    }
}
