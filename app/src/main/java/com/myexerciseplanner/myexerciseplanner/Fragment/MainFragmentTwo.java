package com.myexerciseplanner.myexerciseplanner.Fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.myexerciseplanner.myexerciseplanner.MainActivity;
import com.myexerciseplanner.myexerciseplanner.R;
import com.myexerciseplanner.myexerciseplanner.ViewModel.MainViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainFragmentTwo extends Fragment {

    @BindView(R.id.main_fragment_two_text_id) TextView mSampleTextId;

    private MainViewModel mMainViewModel;
    private MainActivity.FragmentListener mFragmentListener;

    public static MainFragmentTwo newInstance(MainActivity.FragmentListener fragmentListener) {
        MainFragmentTwo mainFragment = new MainFragmentTwo();
        mainFragment.setFragmentListener(fragmentListener);

        return mainFragment;
    }

    private void setFragmentListener(MainActivity.FragmentListener fragmentListener){
        mFragmentListener = fragmentListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_2, parent, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mSampleTextId.setText(mMainViewModel.getSomeTextTwo());
    }
}