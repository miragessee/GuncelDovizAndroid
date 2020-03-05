package com.hakansoftware.gunceldoviz.controller;

import android.content.Context;
import android.util.Log;

import com.hakansoftware.gunceldoviz.base.BaseUtils;
import com.hakansoftware.gunceldoviz.callbacks.Yatirim24Callback;

import java.io.IOException;
import java.util.List;

import io.swagger.client.ApiClient;
import io.swagger.client.api.GuncelDovizApi;
import io.swagger.client.model.Yatirim24Model;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Yatirim24Controller {

    private volatile static Yatirim24Controller instance;

    private GuncelDovizApi api = new ApiClient().createService(GuncelDovizApi.class);

    private Yatirim24Model yatirim24Model;

    public Yatirim24Controller() {
    }

    public static Yatirim24Controller getInstance() {
        if (instance == null)
        {
            synchronized (UserController.class) {
                if (instance == null) {
                    instance = new Yatirim24Controller();
                }
            }
        }
        return instance;
    }

    public void getYatirim24(Yatirim24Callback yatirim24Callback) {
        Call<Yatirim24Model> call = api.apiGuncelDovizGetYatirim24Get();

        call.enqueue(new Callback<Yatirim24Model>() {
            @Override
            public void onResponse(Call<Yatirim24Model> call, Response<Yatirim24Model> response) {
                if (response.body() != null) {
                    Log.d("successTag", response.body().toString());

                    yatirim24Model = response.body();

                    yatirim24Callback.onSuccess(yatirim24Model);
                }
                else
                {
                    try {
                        Log.d("errorTag", response.errorBody().string());

                        yatirim24Callback.onError();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Yatirim24Model> call, Throwable t) {
                Log.d("failTag", t.getMessage());
            }
        });
    }
}
