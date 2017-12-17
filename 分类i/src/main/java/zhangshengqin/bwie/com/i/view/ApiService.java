package zhangshengqin.bwie.com.i.view;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import zhangshengqin.bwie.com.i.bean.FenleiLeftBean;
import zhangshengqin.bwie.com.i.bean.FenleiRightBean;

/**
 * Created by 额头发 on 2017/12/16.
 */

public interface ApiService {
    @GET("product/getCatagory")
    Observable<FenleiLeftBean> getdatas();
    @GET("product/getProductCatagory")
    Observable<FenleiRightBean> getRightData(@Query("cid") int cid);
}
