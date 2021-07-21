package com.ppb.warta.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class WartaViewModelFactory implements ViewModelProvider.Factory{
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(WartaViewModel.class)){
            return (T)new WartaViewModel();
        }
        throw new IllegalArgumentException("ViewModel yang diminta WartaViewModel");
    }
}
