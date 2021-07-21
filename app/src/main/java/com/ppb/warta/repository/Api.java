package com.ppb.warta.repository;

import com.ppb.warta.models.Berita;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface Api {
    @GET("top-headlines")
    Call<String> getHead(@QueryMap Map<String, String> query);
}
