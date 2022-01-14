package com.application.moviecatalog.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.application.moviecatalog.databinding.ActivityMainHomeBinding;

public class MainHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainHomeBinding binding = ActivityMainHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionPagerAdapter sectionPagerAdapter = new SectionPagerAdapter(this,getSupportFragmentManager());

        binding.viewPager.setAdapter(sectionPagerAdapter);
        binding.tabs.setupWithViewPager(binding.viewPager);

        if (getSupportActionBar() !=null) {
            getSupportActionBar().setElevation(0);
        }
    }
}