package com.myexerciseplanner.myexerciseplanner.Fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.myexerciseplanner.myexerciseplanner.ExerciseActivity;
import com.myexerciseplanner.myexerciseplanner.MainActivity;
import com.myexerciseplanner.myexerciseplanner.R;
import com.myexerciseplanner.myexerciseplanner.ViewModel.MainViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainFragment extends Fragment {

    @BindView(R.id.main_fragment_text_id) TextView mSampleTextId;

    private MainViewModel mMainViewModel;
    private MainActivity.FragmentListener mFragmentListener;


    public static MainFragment newInstance(MainActivity.FragmentListener fragmentListener) {
        MainFragment mainFragment = new MainFragment();
        mainFragment.setFragmentListener(fragmentListener);

        return mainFragment;
    }

    private void setFragmentListener(MainActivity.FragmentListener fragmentListener){
        mFragmentListener = fragmentListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, parent, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mSampleTextId.setText(mMainViewModel.getSomeText());
    }

    @OnClick(R.id.on_click_launch_exercise_activity)
    public void onClickLaunchExerciseActivity(View v) {
        mFragmentListener.onNavigateToActivity(new Intent(getActivity(), ExerciseActivity.class));
    }

    @OnClick(R.id.on_click_launch_main_fragment_2)
    public void onClickLaunchMainFragment2(View v) {
        mFragmentListener.onNavigateToFragment(MainActivity.MAIN_FRAGMENT_2_NAVIGATION_CODE);
    }
}
