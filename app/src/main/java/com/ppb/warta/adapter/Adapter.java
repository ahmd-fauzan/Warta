package com.ppb.warta.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ppb.warta.databinding.ItemBinding;
import com.ppb.warta.models.Berita;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<Berita> beritaList;
    Context context;

    public Adapter(List<Berita> beritaList){
        this.beritaList = beritaList;
    }

    public void setBeritaList(List<Berita> beritaList){
        this.beritaList = beritaList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemBinding binding = ItemBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull  Adapter.ViewHolder holder, int position) {
        holder.bind(beritaList.get(position));
    }

    @Override
    public int getItemCount() {
        if(beritaList != null){
            return beritaList.size();
        }
        else
            return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ItemBinding binding;

        public ViewHolder(ItemBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Berita berita){
            binding.setBerita(berita);
            binding.executePendingBindings();
        }
    }
}
