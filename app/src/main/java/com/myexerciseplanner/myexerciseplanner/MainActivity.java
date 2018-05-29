package com.myexerciseplanner.myexerciseplanner;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.myexerciseplanner.myexerciseplanner.Fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onNavigateFragment(getMainFragment());
    }

    private void onNavigateFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    private MainFragment mMainFragment;
    private MainFragment getMainFragment(){
        if(mMainFragment == null){
            mMainFragment = MainFragment.newInstance(new MainFragment.FragmentListener() {
                @Override
                public void onNavigate(Fragment fragment) {
                    onNavigateFragment(fragment);
                }
            });
        }

        return mMainFragment;
    }
}
