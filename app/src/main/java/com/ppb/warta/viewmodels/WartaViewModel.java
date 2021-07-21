package com.ppb.warta.viewmodels;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ppb.warta.R;
import com.ppb.warta.models.Berita;
import com.ppb.warta.models.Filter;
import com.ppb.warta.repository.Api;
import com.ppb.warta.network.RetrofitClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WartaViewModel extends ViewModel {
    private MutableLiveData<List<Berita>> mutableLiveData = new MutableLiveData<>();
    private List<Berita> beritas = new ArrayList<>();
    private Api api;
    Context context;
    public WartaViewModel(){
        api = RetrofitClient.getClient().create(Api.class);
    }

    public void setContext(Context context){
        this.context = context;
    }

    public void readBerita(String q, int country, int category){
        Map<String, String> map = new HashMap<>();
        map.put("country", getCountry(country));
        map.put("q", q);
        map.put("category", getCategory(category));
        map.put("apiKey", "60d918c40e924905b6b935cbea827531");
        Call<String> call = api.getHead(map);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                try {
                    JSONObject object = new JSONObject(response.body());
                    String str = object.getJSONArray("articles").toString();
                    beritas = new Gson().fromJson(str, new TypeToken<List<Berita>>(){}.getType());
                    mutableLiveData.setValue(beritas);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("STATE", t.getMessage());
            }
        });
    }

    public Map<String, String > createMap(String q, String country, String category){
        Map<String, String> map = new HashMap<>();
        if(!q.isEmpty() || q != null)
            map.put("q", q);

        if(!country.isEmpty() || country != null){
            map.put("country", country);
        }


        if(!category.isEmpty() || country != null)
            map.put("category", category);

        return map;
    }

    public LiveData<List<Berita>> getBerita(){
        return mutableLiveData;
    }

    public String getCountry(int country){
        Resources resources = context.getResources();
        String[] str = resources.getStringArray(R.array.countries_values);
        return str[country];
    }

    public String getCategory(int category){
        if(category != -1){
            Resources resources = context.getResources();
            String[] str = resources.getStringArray(R.array.categories);
            return str[category];
        }
        return "";
    }
}
