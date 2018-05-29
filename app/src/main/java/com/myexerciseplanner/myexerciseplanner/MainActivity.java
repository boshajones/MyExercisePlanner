package com.myexerciseplanner.myexerciseplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;

import com.myexerciseplanner.myexerciseplanner.Fragment.MainFragment;
import com.myexerciseplanner.myexerciseplanner.Fragment.MainFragmentTwo;

public class MainActivity extends AppCompatActivity {
    public static final int MAIN_FRAGMENT_1_NAVIGATION_CODE = 1;
    public static final int MAIN_FRAGMENT_2_NAVIGATION_CODE = 2;

    private MainFragment mMainFragment;
    private MainFragmentTwo mMainFragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onNavigateFragment(MAIN_FRAGMENT_1_NAVIGATION_CODE);
    }

    private MainFragment getMainFragment(){
        if(mMainFragment == null){
            mMainFragment = MainFragment.newInstance(new FragmentListener() {
                @Override
                public void onNavigateToFragment(int fragmentCode) {
                    onNavigateFragment(fragmentCode);
                }

                @Override
                public void onNavigateToActivity(Intent activityLaunchIntent) {
                    TaskStackBuilder
                            .create(MainActivity.this)
                            .addNextIntentWithParentStack(activityLaunchIntent)
                            .startActivities();
                }
            });
        }

        return mMainFragment;
    }

    private MainFragmentTwo getMainFragment2(){
        if(mMainFragmentTwo == null){
            mMainFragmentTwo = MainFragmentTwo.newInstance(new FragmentListener() {
                @Override
                public void onNavigateToFragment(int fragmentCode) {
                    //Not implemented
                }

                @Override
                public void onNavigateToActivity(Intent activityLaunchIntent) {
                    //Not implemented
                }
            });
        }

        return mMainFragmentTwo;
    }

    private void onNavigateFragment(int fragmentCode){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, getFragmentFromCode(fragmentCode))
                .addToBackStack(null)
                .commit();
    }

    private Fragment getFragmentFromCode(int fragmentCode){
        switch(fragmentCode){
            case MAIN_FRAGMENT_1_NAVIGATION_CODE:
                return getMainFragment();

            case MAIN_FRAGMENT_2_NAVIGATION_CODE:
                return getMainFragment2();

            default:
                return null;
        }
    }

    public interface FragmentListener
    {
        void onNavigateToFragment(int fragmentCode);
        void onNavigateToActivity(Intent activityLaunchIntent);
    }
}
