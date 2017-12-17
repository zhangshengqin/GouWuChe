package com.example.lxhouliu3.model;

import com.example.lxhouliu3.presenter.NewsPresenter;

import java.util.Map;

import io.reactivex.Flowable;

/**
 * Created by Administrator on 2017/12/16 0016.
 */

public class Model implements IModel {
    private NewsPresenter presenter;

    public Model(NewsPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getData(Map<String, String> map) {
        Flowable<ShopCar> flowable = RetrofitUtils.getInstance().getApiService().getNews(map);
        presenter.get(flowable);
    }
}
