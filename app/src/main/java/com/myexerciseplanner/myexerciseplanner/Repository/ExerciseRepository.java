package com.myexerciseplanner.myexerciseplanner.Repository;

import com.myexerciseplanner.myexerciseplanner.DataProvider.ExerciseDataProvider;

public class ExerciseRepository {
    private ExerciseDataProvider mExerciseDataProvider;

    public ExerciseRepository(ExerciseDataProvider exerciseDataProvider){
        mExerciseDataProvider = exerciseDataProvider;
    }

    public String getMainFragmentSampleText(){
        return mExerciseDataProvider.getMainFragmentSampleText();
    }

    public String getMainFragmentTwoSampleText(){
        return mExerciseDataProvider.getMainFragmentTwoSampleText();
    }

    public String getExerciseFragmentSampleText(){
        return mExerciseDataProvider.getExerciseFragmentSampleText();
    }
}
