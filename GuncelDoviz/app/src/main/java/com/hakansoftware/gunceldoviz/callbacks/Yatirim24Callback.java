package com.hakansoftware.gunceldoviz.callbacks;

import io.swagger.client.model.Yatirim24Model;

public interface Yatirim24Callback{
    void onSuccess(Yatirim24Model yatirim24Model);
    void onError();
}