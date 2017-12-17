package zhangshengqin.bwie.com.i.presenter;

import java.util.List;

import zhangshengqin.bwie.com.i.bean.FenleiLeftBean;
import zhangshengqin.bwie.com.i.bean.FenleiRightBean;
import zhangshengqin.bwie.com.i.model.FenleiLeftIModel;
import zhangshengqin.bwie.com.i.model.FenleiLeftModel;
import zhangshengqin.bwie.com.i.model.OnRequestListener;
import zhangshengqin.bwie.com.i.view.FenleiLeftIView;

/**
 * Created by 额头发 on 2017/12/16.
 */

public class FenleiLeftPresenter implements FenleileftIPresenter{
    private FenleiLeftIView fenleiLeftIView;
    private FenleiLeftIModel fenleiLeftIModel;

    public FenleiLeftPresenter(FenleiLeftIView fenleiLeftIView) {
        this.fenleiLeftIView = fenleiLeftIView;
        fenleiLeftIModel = new FenleiLeftModel();
    }
    @Override
    public void loadList(String url) {
        fenleiLeftIModel.RequestData(url, new OnRequestListener() {
            @Override
            public void OnSuccess(List<FenleiLeftBean.DataBean> list) {
                fenleiLeftIView.showList(list);
            }

            @Override
            public void OnRightSuccess(List<FenleiRightBean.DataBean> list) {

            }

            @Override
            public void OnError(String e) {
                fenleiLeftIView.showError(e);
            }
        });

    }

}
