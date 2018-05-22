package com.myexerciseplanner.myexerciseplanner.Providers;

import android.content.Context;
import android.content.Intent;

import com.myexerciseplanner.myexerciseplanner.ExerciseActivity;
import com.myexerciseplanner.myexerciseplanner.Models.Feature;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

public class MockDataProvider implements IDataProvider {

    @Inject
    public MockDataProvider(){
    }

    public List<Feature> getFeatures(Context context){
        List<Feature> features = new ArrayList<>();

        features.add(getHealthAndFitnessFeature(context));

        return features;
    }

    private Feature getHealthAndFitnessFeature(Context context){
        return new Feature(
                UUID.randomUUID(),
                "Health and Fitness",
                "Track your workouts and weight",
                "Use this to create, follow and track your workouts along with how you're progressing.",
                "Go to Health and Fitness",
                new Intent(context, ExerciseActivity.class)
        );
    }
}