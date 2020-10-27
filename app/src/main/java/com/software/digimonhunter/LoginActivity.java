package com.software.digimonhunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.software.digimonhunter.user.Back;
import com.software.digimonhunter.user.Entered;
import com.software.digimonhunter.user.UserModel;
import com.software.digimonhunter.user.UserSharedPref;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        UserSharedPref userSharedPref = new UserSharedPref(LoginActivity.this);
        UserModel loggedUser = userSharedPref.loggedUser();
        Back back = new Back();
        back.setBack("notBack");
        userSharedPref.setBackDetail(back);
        Entered entered = new Entered();
        entered.setEntered("");
        userSharedPref.setEnterPref(entered);
        if((!loggedUser.getUsername().isEmpty() || loggedUser.getUsername() != "")
        && (!loggedUser.getPassword().isEmpty() || loggedUser.getPassword() != "")){
            Intent intentPass = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intentPass);
            finishAffinity();
        }
        username = findViewById(R.id.username_login);
        password = findViewById(R.id.password_login);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setBackgroundResource(R.drawable.btn_click_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userN = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                if(userN.isEmpty() || userN ==""){
                    Toast.makeText(LoginActivity.this, "Username can't be empty", Toast.LENGTH_SHORT).show();
                }else if(userN.length()<5 || userN.length()>20){
                    Toast.makeText(LoginActivity.this, "Username must be between 5-20 character", Toast.LENGTH_SHORT).show();
                }else if(pass.isEmpty() || pass == ""){
                    Toast.makeText(LoginActivity.this, "Password can't be empty", Toast.LENGTH_SHORT).show();
                }else{
                    Bundle bundle = new Bundle();
                    UserModel userModel = new UserModel();
                    userModel.setUsername(userN);
                    userModel.setPassword(pass);
                    UserSharedPref userSharedPref = new UserSharedPref(LoginActivity.this);
                    userSharedPref.loggingUser(userModel);
                    bundle.putSerializable("User", userModel);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finishAffinity();
                }
            }
        });

    }
}
