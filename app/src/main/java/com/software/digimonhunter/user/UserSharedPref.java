package com.software.digimonhunter.user;

import android.content.Context;
import android.content.SharedPreferences;

public class UserSharedPref {

    private SharedPreferences sharedPreferences;
    public UserSharedPref(Context context){
        sharedPreferences = context.getSharedPreferences("sharedPreference", Context.MODE_PRIVATE);
    }

    public UserSharedPref(){
        super();
    }
    public void loggingUser(UserModel user){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Username", user.getUsername());
        editor.putString("Password", user.getPassword());
        editor.apply();
    }

    public UserModel loggedUser(){
        UserModel user = new UserModel();
        user.setUsername(sharedPreferences.getString("Username", ""));
        user.setPassword(sharedPreferences.getString("Password", ""));
        return user;
    }

    public void logOut(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("sharedPreference");
        editor.clear();
        editor.apply();
    }

    public void setBackDetail(Back back){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("isBack", back.isBack());
        editor.apply();
    }

    public Back getbackPref(){
        Back back = new Back();
        back.setBack(sharedPreferences.getString("isBack", ""));
        return back;
    }

    public Entered getEnterPref(){
        Entered entered = new Entered();
        entered.setEntered(sharedPreferences.getString("Enter",""));
        return entered;
    }

    public void setEnterPref(Entered entered){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Enter", entered.getEntered());
        editor.apply();
    }

}
