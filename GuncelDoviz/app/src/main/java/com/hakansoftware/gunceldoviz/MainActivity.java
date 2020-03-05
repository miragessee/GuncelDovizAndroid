package com.hakansoftware.gunceldoviz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hakansoftware.gunceldoviz.activity.ListScreenActivity;
import com.hakansoftware.gunceldoviz.activity.LoginScreenActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.startActivity(LoginScreenActivity.newIntent(this));
    }
}
