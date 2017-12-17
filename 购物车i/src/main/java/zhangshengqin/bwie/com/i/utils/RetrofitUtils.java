package zhangshengqin.bwie.com.i.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 额头发 on 2017/12/16.
 */

public class RetrofitUtils {
    private  static volatile RetrofitUtils instance;
    private Retrofit retrofit;
    private Class service;
    private  RetrofitUtils() {

    }

    public  RetrofitUtils (String baseUrl){
        retrofit=new Retrofit.Builder()
                // 自动Gson解析
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build();
    }

    public static RetrofitUtils getInstance(String baseUrl){
        if(instance==null){
            synchronized (RetrofitUtils.class){
                if(null==instance){
                    instance=new RetrofitUtils();
                }
            }
        }
        return instance;
    }

    public static RetrofitUtils getInstance(){
        if(null==instance){
            return  getInstance("https://www.zhaoapi.cn/");
        }
        return  instance;
    }
    public Retrofit getRetrofit(){
        return  retrofit;
    }
    public <T>void create (Class<T>cls){
        service=(Class)retrofit.create(cls);
    }

    public Class getService(){
        return  service;
    }
}
