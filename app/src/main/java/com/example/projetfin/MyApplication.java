package com.example.projetfin;

import android.app.Application;

import com.example.projetfin.Database.User;

public class MyApplication extends Application {
    private User user;

    public User getSomeVariable() {
        return user;
    }
    public void setSomeVariable(User user_) {
        this.user = user_;
    }
}
