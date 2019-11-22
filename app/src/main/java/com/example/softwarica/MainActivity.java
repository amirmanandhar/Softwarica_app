package com.example.softwarica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.example.softwarica.Fragment.AboutFragment;
import com.example.softwarica.Fragment.HomeFragment;
import com.example.softwarica.Fragment.RegisterFragment;
import com.example.softwarica.Model.Student;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

        BottomNavigationView bottomNavigation;
        FrameLayout main_layout;
        public static List<Student> students=new ArrayList<>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // Start homefragment at startup
            getSupportFragmentManager().beginTransaction().replace(R.id.main_layout,
                    new HomeFragment()).commit();

            bottomNavigation=findViewById(R.id.bottom_navigation);
            main_layout=findViewById(R.id.main_layout);
            students.add(new Student("Ranbir",29,"Male","Pokhara",R.drawable.male));
            students.add(new Student("Rima",29,"Female","Chitwan",R.drawable.female));
            students.add(new Student("Bini",18,"Other","Dharan",R.drawable.others));
            students.add(new Student("Kapoor",20,"Male","KTM",R.drawable.male));

            bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment fragment=null;
                    switch (menuItem.getItemId()){
                        case R.id.nav_home:
                            fragment=new HomeFragment();
                            break;
                        case R.id.nav_about:
                            fragment=new AboutFragment();
                            break;
                        case R.id.nav_register:
                            fragment=new RegisterFragment();
                            break;
                    }


                    getSupportFragmentManager().beginTransaction().replace(R.id.main_layout,
                            fragment).commit();
                    return true;
                }
            });
    }
}
