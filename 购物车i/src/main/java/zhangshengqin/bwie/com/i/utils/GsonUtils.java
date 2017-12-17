package zhangshengqin.bwie.com.i.utils;

import com.google.gson.Gson;

/**
 * Created by 额头发 on 2017/12/16.
 */

public class GsonUtils {
    private static Gson gson;

    public static Gson getInstance(){
        if(gson==null){
            gson=new Gson();
        }
        return gson;
    }

}
