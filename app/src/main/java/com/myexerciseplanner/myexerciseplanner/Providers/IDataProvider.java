package com.myexerciseplanner.myexerciseplanner.Providers;

import android.content.Context;

import com.myexerciseplanner.myexerciseplanner.Models.Feature;

import java.util.List;

public interface IDataProvider {
    public List<Feature> getFeatures(Context context);
}
