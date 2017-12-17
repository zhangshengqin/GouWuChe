package zhangshengqin.bwie.com.i.view;

/**
 * Created by 额头发 on 2017/12/16.
 */

public interface CallBack {
    void onSuccess(String tag, Object o);
    void onFailed(String tag, Exception e);
}

