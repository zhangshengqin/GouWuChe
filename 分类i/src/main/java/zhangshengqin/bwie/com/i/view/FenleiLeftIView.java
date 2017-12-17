package zhangshengqin.bwie.com.i.view;

import java.util.List;

import zhangshengqin.bwie.com.i.bean.FenleiLeftBean;

/**
 * Created by 额头发 on 2017/12/16.
 */

public interface FenleiLeftIView {
    void showList(List<FenleiLeftBean.DataBean> list);
    void showError(String e);

}
