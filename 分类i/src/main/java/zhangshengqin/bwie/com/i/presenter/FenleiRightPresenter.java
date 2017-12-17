package zhangshengqin.bwie.com.i.presenter;

import java.util.List;

import zhangshengqin.bwie.com.i.bean.FenleiLeftBean;
import zhangshengqin.bwie.com.i.bean.FenleiRightBean;
import zhangshengqin.bwie.com.i.model.FenleiRightIModel;
import zhangshengqin.bwie.com.i.model.FenleiRightModel;
import zhangshengqin.bwie.com.i.model.OnRequestListener;
import zhangshengqin.bwie.com.i.view.FenleiRightIView;

/**
 * Created by 额头发 on 2017/12/16.
 */

public class FenleiRightPresenter implements FenleiRightIPresenter{
    private FenleiRightIView fenleiRightIView;
    private FenleiRightIModel fenleiRightIModel;

    public FenleiRightPresenter(FenleiRightIView fenleiRightIView) {
        this.fenleiRightIView = fenleiRightIView;
        fenleiRightIModel = new FenleiRightModel();
    }
    @Override
    public void loadRightList(String url, int cid) {
        fenleiRightIModel.RequestRightData(url, cid, new OnRequestListener() {
            @Override
            public void OnSuccess(List<FenleiLeftBean.DataBean> list) {

            }

            @Override
            public void OnRightSuccess(List<FenleiRightBean.DataBean> list) {
                fenleiRightIView.showRight(list);
            }

            @Override
            public void OnError(String e) {

            }
        });
    }

}
