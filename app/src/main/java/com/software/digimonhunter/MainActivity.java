package com.software.digimonhunter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
//import android.app.Fragment;
//import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.software.digimonhunter.user.Back;
import com.software.digimonhunter.user.Entered;
import com.software.digimonhunter.user.UserModel;
import com.software.digimonhunter.user.UserSharedPref;

public class MainActivity extends AppCompatActivity {

    public static int backPressed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        backPressed = 0;
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.menu_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        UserSharedPref backPref = new UserSharedPref(MainActivity.this);
        Back back = backPref.getbackPref();
        if (back.isBack().contains("isBack") || back.isBack() == "isBack"){
            back.setBack("notBack");
            backPref.setBackDetail(back);
            bottomNavigationView.setSelectedItemId(R.id.digimon_frag);
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_fragment, new DigimonActivity()).commit();
            backPressed = 1;
        }else{
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_fragment, new HomeActivity()).commit();
            backPressed = 0;
        }
        Entered entered = backPref.getEnterPref();
        UserModel user = backPref.loggedUser();
        if(entered.getEntered().equals("") || entered.getEntered() == ""){
            Toast.makeText(this, "Welcome, "+user.getUsername(), Toast.LENGTH_SHORT).show();
            entered.setEntered("Entered");
            backPref.setEnterPref(entered);
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedMenu;
                    UserSharedPref backPref = new UserSharedPref(MainActivity.this);
                    Back back = backPref.getbackPref();
                    selectedMenu = new HomeActivity();
                    switch (menuItem.getItemId()){
                        case R.id.home_frag:
                            selectedMenu = new HomeActivity();
                            break;
                        case R.id.digimon_frag:
                            selectedMenu = new DigimonActivity();
                            break;
                        case R.id.contact_frag:
                            selectedMenu = new ContactActivity();
                            break;
                        case R.id.logout_frag:
                            UserSharedPref userSharedPref = new UserSharedPref(MainActivity.this);
                            userSharedPref.logOut();
                            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finishAffinity();
                            break;
                    }
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame_fragment, selectedMenu)
                            .commit();
                    return true;
                }
            };

}
