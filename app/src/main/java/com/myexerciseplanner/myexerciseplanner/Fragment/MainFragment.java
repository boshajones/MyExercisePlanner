package com.myexerciseplanner.myexerciseplanner.Fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.myexerciseplanner.myexerciseplanner.R;
import com.myexerciseplanner.myexerciseplanner.ViewModel.MainViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainFragment extends Fragment {

    @BindView(R.id.some_text_id) TextView mSomeText;

    private MainViewModel mMainViewModel;
    private FragmentListener mFragmentListener;


    public static MainFragment newInstance(FragmentListener fragmentListener) {
        MainFragment mainFragment = new MainFragment();
        mainFragment.setFragmentListener(fragmentListener);

        return mainFragment;
    }

    private void setFragmentListener(FragmentListener fragmentListener){
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
        mSomeText.setText(mMainViewModel.getSomeText());
    }

    @OnClick(R.id.callback_button_id)
    public void onClickCallbackButton(View v) {
        mFragmentListener.onNavigate(null);
    }

    public interface FragmentListener
    {
        void onNavigate(Fragment fragment);
    }
}
