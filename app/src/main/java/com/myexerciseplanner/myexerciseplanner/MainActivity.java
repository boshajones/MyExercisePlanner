package com.myexerciseplanner.myexerciseplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;

import com.myexerciseplanner.myexerciseplanner.Fragment.MainFragment;
import com.myexerciseplanner.myexerciseplanner.Fragment.MainFragmentTwo;

// Consider a BaseActivity class that has a method to swap Fragments to be shared across activities
public class MainActivity extends AppCompatActivity {
    // Would probably avoid indexing fragments like this, imagine 20 fragments would have a lot of indicies :P
    public static final int MAIN_FRAGMENT_1_NAVIGATION_CODE = 1;
    public static final int MAIN_FRAGMENT_2_NAVIGATION_CODE = 2;

    // You never really want to hold onto strong references to the fragment (with few exceptions), 
    // you can always get the current fragment using getSupportFragmentManager().findFragmentById(R.id.fragment_container)
    private MainFragment mMainFragment;
    private MainFragmentTwo mMainFragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Only swap fragments in onCreate if savedInstanceState is null, this allows the system to restore
        // the fragment and handle state internally as opposed to recreating the fragment on each configuration change (e.g. rotation)
        onNavigateFragment(MAIN_FRAGMENT_1_NAVIGATION_CODE);
    }

    // Won't need these methods if you remove the member variables
    private MainFragment getMainFragment(){
        if(mMainFragment == null){
            // Handling listeners like this will mean that the listener is lost on configuration change
            // Rule of thumb is that you shouldn't be creating a new activity/fragment/dialog/etc with anything that can't be bundled
            // (see https://stackoverflow.com/a/9245510)
            mMainFragment = MainFragment.newInstance(new FragmentListener() {
                @Override
                public void onNavigateToFragment(int fragmentCode) {
                    onNavigateFragment(fragmentCode);
                }

                // I should probably look at where you're using this but yolo, you can determine activity
                // parental hierarchy within the android manifest, task stack builders tend to be used when either
                // a) coming into an app from a notification
                // b) there are multiple entry points to an application (multiple launcher intents)
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

    // See above
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

    // Good stuff, but you could just pass the Fragment instance here as a parameter to avoid the indexing
    private void onNavigateFragment(int fragmentCode){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, getFragmentFromCode(fragmentCode))
                .addToBackStack(null)
                .commit();
    }

    // Remove the indexing and you can get rid of this as well
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

    // Instead of passing a listener directly to the fragment you might want to consider inversing this,
    // create a "NavigationListener" interface in another class, and have this activity implement that listener
    // this interface can contain methods like goToFragmentOne() and goToFragmentTwo() which are implemented here
    // and call through to the onNavigateFragment() method. Within the activity you can then call 
    // if (getActivity() instanceof NavigationListener) ((NavigationListener) getActivity()).goToFragmentTwo();
    // Or you could hold onto the listener as a weak reference within the activity, setting it up within
    // onAttach, but I'll leave that up to you (though the latter is worth bonus points ;p)
    public interface FragmentListener {
        void onNavigateToFragment(int fragmentCode);
        void onNavigateToActivity(Intent activityLaunchIntent);
    }
}
