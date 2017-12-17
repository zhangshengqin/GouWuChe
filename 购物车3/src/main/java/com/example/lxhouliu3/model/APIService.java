package com.example.lxhouliu3.model;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2017/12/16 0016.
 */

public interface APIService {
    //http://120.27.23.105/product/getCarts
    @GET("product/getCarts")
    Flowable<ShopCar> getNews(@QueryMap Map<String, String> map);
}
