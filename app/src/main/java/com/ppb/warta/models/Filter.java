package com.ppb.warta.models;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.ppb.warta.BR;

public class Filter extends BaseObservable {
    private String q;
    private int country;
    private int category;

    public Filter(){}

    public Filter(String q, int country, int category) {
        this.q = q;
        this.country = country;
        this.category = category;
    }

    @Bindable
    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
        notifyPropertyChanged(BR.q);
    }

    @Bindable
    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
        notifyPropertyChanged(BR.country);
    }

    @Bindable
    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
        notifyPropertyChanged(BR.category);
    }
}
