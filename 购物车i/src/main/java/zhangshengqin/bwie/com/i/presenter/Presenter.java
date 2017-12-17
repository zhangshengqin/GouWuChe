package zhangshengqin.bwie.com.i.presenter;

import java.util.Map;

import zhangshengqin.bwie.com.i.utils.HttpUtils;
import zhangshengqin.bwie.com.i.view.CallBack;
import zhangshengqin.bwie.com.i.view.ImView;

/**
 * Created by 额头发 on 2017/12/16.
 */

public class Presenter {
    private ImView inv;
    public void attachView(ImView inv){
        this.inv=inv;
    }

    public void get(String url, Map<String,String> map, String tag, Class clv){
        HttpUtils.getInstance().get(url, map, new CallBack() {
            @Override
            public void onSuccess(String tag, Object o) {
                if(o!=null){
                    inv.onSuccess(tag,o);
                }
            }

            @Override
            public void onFailed(String tag, Exception e) {
                inv.onFailed(tag,e);
            }
        },clv,tag);
    }
    //创建对象方便 v层进行释放 解耦 方法
    public void deleteView(){
        if(inv!=null){
            inv=null;
        }
    }

}
