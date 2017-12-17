package zhangshengqin.bwie.com.i.model;

import java.util.List;

import zhangshengqin.bwie.com.i.bean.FenleiLeftBean;
import zhangshengqin.bwie.com.i.bean.FenleiRightBean;

/**
 * Created by 额头发 on 2017/12/16.
 */

public interface OnRequestListener {
    void OnSuccess(List<FenleiLeftBean.DataBean> list);
    void OnRightSuccess(List<FenleiRightBean.DataBean> list);
    void OnError(String e);

}
