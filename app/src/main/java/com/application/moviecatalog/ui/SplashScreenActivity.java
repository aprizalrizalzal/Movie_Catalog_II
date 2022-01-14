package com.application.moviecatalog.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.application.moviecatalog.R;
import com.application.moviecatalog.databinding.ActivitySplashScreenBinding;
import com.bumptech.glide.Glide;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySplashScreenBinding binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Glide.with(this).load(R.mipmap.ic_launcher).into(binding.imgApp);

        Thread thread = new Thread(() -> {
            long splash = 1_500;

            try {
                Thread.sleep(splash);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                startActivity(new Intent(SplashScreenActivity.this, MainHomeActivity.class));
                finish();
            }

        });
        thread.start();
    }
}