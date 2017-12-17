package zhangshengqin.bwie.com.i.app;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import zhangshengqin.bwie.com.i.bean.Category;
import zhangshengqin.bwie.com.i.bean.MessageBean;

/**
 * Created by 额头发 on 2017/12/16.
 */

public interface ApiService {
    @GET("product/getCatagory")
    Call<MessageBean<List<Category>>> getCategory();
}
