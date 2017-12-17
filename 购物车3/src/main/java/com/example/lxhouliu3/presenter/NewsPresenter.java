package com.example.lxhouliu3.presenter;

import com.example.lxhouliu3.model.IPresenter;
import com.example.lxhouliu3.model.IView;
import com.example.lxhouliu3.model.Model;
import com.example.lxhouliu3.model.ShopCar;

import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by Administrator on 2017/12/16 0016.
 */

public class NewsPresenter implements IPresenter {
    private IView iView;
    private DisposableSubscriber<ShopCar> subscriber;

    public void attachView(IView iView) {
        this.iView = iView;
    }

    @Override
    public void getData(Map<String, String> map) {
        Model model = new Model(this);
        model.getData(map);
    }

    public void detachView() {
        if (subscriber != null) {
            //如果该资源已被处理，则可一次性返回true。如果没有被处理返回false
            if (!subscriber.isDisposed()) {
                subscriber.dispose();
            }
        }

    }

    public void get(Flowable<ShopCar> flowable) {
        subscriber = flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<ShopCar>() {
                    @Override
                    public void onNext(ShopCar listMessageBean) {
                        if (listMessageBean != null) {
                            List<ShopCar.DataBean> data = listMessageBean.getData();
                            if (data != null) {
                                iView.OnSuccess(data);
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        iView.OnFailed(new Exception(t));
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
