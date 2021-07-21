package com.ppb.warta.util;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.ppb.warta.DetailActivity;
import com.ppb.warta.R;
import com.ppb.warta.WebActivity;
import com.ppb.warta.models.Berita;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class BindingUtil {
    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String urlImage){
        Picasso.get().load(urlImage).into(imageView, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {

            }
        });
    }

    public static void moveActivity(Context context, Berita berita){
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("Berita", berita);
        context.startActivity(intent);
    }

    public static void webActivity(Context context, String url){
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra("Web", url);
        context.startActivity(intent);
    }

    public static String getDate(String date){
        String temp = "";
        for(int i = 0; i < date.length(); i++){
            if(date.charAt(i) == 'T'){
                Log.d("state", "found");
                temp = date.substring(0, i);
                return temp;
            }
        }
        return "";
    }

    public static String getTime(String date){
        String temp = "";
        for(int i = date.length() - 1; i > 0; i--){
            if(date.charAt(i) == 'T'){
                temp = date.substring((i + 1), (date.length() - 1));
                return temp;
            }
        }
        return "";
    }
}
