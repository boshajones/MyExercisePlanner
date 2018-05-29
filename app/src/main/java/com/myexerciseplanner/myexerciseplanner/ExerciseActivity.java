package com.myexerciseplanner.myexerciseplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.myexerciseplanner.myexerciseplanner.Fragment.ExerciseFragment;

public class ExerciseActivity extends AppCompatActivity {
    public static final int EXERCISE_FRAGMENT_NAVIGATION_CODE = 0;

    private ExerciseFragment mExerciseFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        onNavigateFragment(EXERCISE_FRAGMENT_NAVIGATION_CODE);
    }

    private ExerciseFragment getExerciseFragment(){
        if(mExerciseFragment == null){
            mExerciseFragment = ExerciseFragment.newInstance(new ExerciseActivity.FragmentListener() {
                @Override
                public void onNavigateToFragment(Fragment fragment) {
                    //Not implemented
                }

                @Override
                public void onNavigateToActivity(Intent activityLaunchIntent) {
                    //Not implemented
                }
            });
        }

        return mExerciseFragment;
    }

    private void onNavigateFragment(int fragmentCode){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, getFragmentFromCode(fragmentCode))
                .commit();
    }

    private Fragment getFragmentFromCode(int fragmentCode){
        switch(fragmentCode){
            case EXERCISE_FRAGMENT_NAVIGATION_CODE:
                return getExerciseFragment();

            default:
                return null;
        }
    }

    public interface FragmentListener
    {
        void onNavigateToFragment(Fragment fragment);
        void onNavigateToActivity(Intent activityLaunchIntent);
    }
}
