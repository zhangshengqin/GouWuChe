package zhangshengqin.bwie.com.i.model;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zhangshengqin.bwie.com.i.bean.FenleiRightBean;
import zhangshengqin.bwie.com.i.view.ApiService;

/**
 * Created by 额头发 on 2017/12/16.
 */

public class FenleiRightModel implements FenleiRightIModel{
    @Override
    public void RequestRightData(String url, int cid, final OnRequestListener onRequestListener) {
        //retrofit网络请求
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<FenleiRightBean> rightData = apiService.getRightData(cid);
        rightData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FenleiRightBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onRequestListener.OnError(e.getMessage().toString());
                    }

                    @Override
                    public void onNext(FenleiRightBean fenleiRightBean) {
                        List<FenleiRightBean.DataBean> data = fenleiRightBean.getData();
                        onRequestListener.OnRightSuccess(data);
                    }
                });
    }

}
