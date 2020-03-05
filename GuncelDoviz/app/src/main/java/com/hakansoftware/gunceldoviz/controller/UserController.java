package com.hakansoftware.gunceldoviz.controller;

import android.content.Context;
import android.util.Log;

import com.hakansoftware.gunceldoviz.activity.ListScreenActivity;
import com.hakansoftware.gunceldoviz.base.BaseIntent;
import com.hakansoftware.gunceldoviz.base.BaseUtils;

import java.io.IOException;
import java.util.HashMap;

import io.swagger.client.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserController {

    public static String username, password;

    private volatile static UserController instance;

    public UserController() {
    }

    public static UserController getInstance() {
        if (instance == null)
        {
            synchronized (UserController.class) {
                if (instance == null) {
                    instance = new UserController();
                }
            }
        }
        return instance;
    }

    public void register(String username, String password) {
        UserController.username = username;
        UserController.password = password;
    }

    public void login(Context context, String username, String password) {
        if ((username.equalsIgnoreCase(UserController.username) && password.equalsIgnoreCase(UserController.password)) || (username.equalsIgnoreCase("demo") && password.equalsIgnoreCase("demo")))
        {
            BaseIntent.baseIntent(context, ListScreenActivity.class);
        }
        else
        {
            BaseUtils.showToast(context, "Kullanıcı Adı ve Şifre Yanlış, demo demo bilgilerini ile giriş yapaiblirisiniz.");
        }
    }
}
