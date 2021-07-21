package com.ppb.warta;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;
import com.ppb.warta.adapter.Adapter;
import com.ppb.warta.databinding.ActivityMainBinding;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.ppb.warta.models.Berita;
import com.ppb.warta.models.Filter;
import com.ppb.warta.viewmodels.WartaViewModel;
import com.ppb.warta.viewmodels.WartaViewModelFactory;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        WartaViewModelFactory factory = new WartaViewModelFactory();
        WartaViewModel viewModel = new ViewModelProvider(this, factory).get(WartaViewModel.class);
        viewModel.setContext(this);

        Filter filter = new Filter("", 0, 0);
        binding.setViewmodel(viewModel);
        binding.setFilter(filter);

        viewModel.readBerita("", 0, -1);

        viewModel.getBerita().observe(this, new Observer<List<Berita>>() {
            @Override
            public void onChanged(List<Berita> beritas) {
                RecyclerView recyclerView = binding.recyclerView;
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                Adapter adapter = new Adapter(beritas);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        final SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();

        return super.onCreateOptionsMenu(menu);
    }

}