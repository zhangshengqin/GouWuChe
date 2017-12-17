package zhangshengqin.bwie.com.i.model;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zhangshengqin.bwie.com.i.bean.FenleiLeftBean;
import zhangshengqin.bwie.com.i.view.ApiService;

/**
 * Created by 额头发 on 2017/12/16.
 */

public class FenleiLeftModel implements FenleiLeftIModel {
    @Override
    public void RequestData(String url, final OnRequestListener onRequestListener) {
        //retrofit网络请求
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())

                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<FenleiLeftBean> getdatas = apiService.getdatas();
        getdatas.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FenleiLeftBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onRequestListener.OnError(e.getMessage().toString());
                    }

                    @Override
                    public void onNext(FenleiLeftBean fenleiLeftBean) {
                        List<FenleiLeftBean.DataBean> data = fenleiLeftBean.getData();
                        onRequestListener.OnSuccess(data);
                    }
                });
    }

}
