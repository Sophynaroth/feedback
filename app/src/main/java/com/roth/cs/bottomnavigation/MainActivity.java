package com.roth.cs.bottomnavigation;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.roth.cs.bottomnavigation.ui.canteen.CanteenFragment;
import com.roth.cs.bottomnavigation.ui.dormitory.DormitoryFragment;
import com.roth.cs.bottomnavigation.ui.lecturer.LecturerFragment;
import com.roth.cs.bottomnavigation.ui.post.PostFragment;
import com.roth.cs.bottomnavigation.ui.university.UniversityFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;



public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new UniversityFragment());

        BottomNavigationView navigation = findViewById(R.id.nav_view);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_uni:
                fragment = new UniversityFragment();
                break;

            case R.id.navigation_lecturer:
                fragment = new LecturerFragment();
                break;

            case R.id.navigation_canteen:
                fragment = new CanteenFragment();
                break;

            case R.id.navigation_dorm:
                fragment = new DormitoryFragment();
                break;

            case R.id.navigation_post:
                fragment = new PostFragment();
                break;
        }

        return loadFragment(fragment);
    }

    private boolean loadFragment (Fragment fragment){
        if(fragment != null){

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();

            return true;
        }
        return false;
    }


}
