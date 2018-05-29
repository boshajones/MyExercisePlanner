package com.myexerciseplanner.myexerciseplanner.Fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.myexerciseplanner.myexerciseplanner.ExerciseActivity;
import com.myexerciseplanner.myexerciseplanner.R;
import com.myexerciseplanner.myexerciseplanner.ViewModel.ExerciseViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExerciseFragment extends Fragment {

    @BindView(R.id.exercise_fragment_text_id) TextView mSampleTextId;

    private ExerciseViewModel mExerciseViewModel;
    private ExerciseActivity.FragmentListener mFragmentListener;

    public static ExerciseFragment newInstance(ExerciseActivity.FragmentListener fragmentListener) {
        ExerciseFragment exerciseFragment = new ExerciseFragment();
        exerciseFragment.setFragmentListener(fragmentListener);

        return exerciseFragment;
    }

    private void setFragmentListener(ExerciseActivity.FragmentListener fragmentListener){
        mFragmentListener = fragmentListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercise, parent, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mExerciseViewModel = ViewModelProviders.of(this).get(ExerciseViewModel.class);
        mSampleTextId.setText(mExerciseViewModel.getSomeText());
    }

}