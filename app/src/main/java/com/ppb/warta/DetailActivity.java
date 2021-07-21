package com.ppb.warta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.ppb.warta.databinding.ActivityDetailBinding;
import com.ppb.warta.models.Berita;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);

        Berita berita = (Berita)getIntent().getSerializableExtra("Berita");
        binding.setBerita(berita);
    }
}