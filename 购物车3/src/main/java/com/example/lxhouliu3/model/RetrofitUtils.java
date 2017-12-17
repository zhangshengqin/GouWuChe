package com.example.lxhouliu3.model;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/12/16 0016.
 */

public class RetrofitUtils {
    private static volatile RetrofitUtils instance;
    private final Retrofit retrofit;

    private RetrofitUtils() {
        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://120.27.23.105/")
                .build();
    }

    public static RetrofitUtils getInstance() {
        if (instance == null) {
            synchronized (RetrofitUtils.class) {
                if (instance == null) {
                    instance = new RetrofitUtils();
                }
            }
        }
        return instance;
    }

    public APIService getApiService() {
        APIService apiService = retrofit.create(APIService.class);
        return apiService;
    }
}
