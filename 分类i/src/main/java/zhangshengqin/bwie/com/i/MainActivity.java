package zhangshengqin.bwie.com.i;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import zhangshengqin.bwie.com.i.adapter.FenleiRightAdapter;
import zhangshengqin.bwie.com.i.adapter.FenleileftAdapter;
import zhangshengqin.bwie.com.i.bean.FenleiLeftBean;
import zhangshengqin.bwie.com.i.bean.FenleiRightBean;
import zhangshengqin.bwie.com.i.presenter.FenleiLeftPresenter;
import zhangshengqin.bwie.com.i.presenter.FenleiRightPresenter;
import zhangshengqin.bwie.com.i.view.Api;
import zhangshengqin.bwie.com.i.view.FenleiLeftIView;
import zhangshengqin.bwie.com.i.view.FenleiRightIView;

public class MainActivity extends AppCompatActivity implements FenleiLeftIView, FenleiRightIView {

    @BindView(R.id.fenleileftrecler)
    RecyclerView fenleileftrecler;
    @BindView(R.id.fenleirightrecler)
    RecyclerView fenleirightrecler;
    private FenleiRightPresenter fenleiRightPresenter;
    private FenleileftAdapter fenleileftAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        fenleileftrecler.setLayoutManager(linearLayoutManager);
        LinearLayoutManager linearLayoutManagerright = new LinearLayoutManager(this);
        fenleirightrecler.setLayoutManager(linearLayoutManagerright);
        FenleiLeftPresenter fenleiLeftPresenter = new FenleiLeftPresenter(this);
        fenleiLeftPresenter.loadList(Api.HOST);
        fenleiRightPresenter = new FenleiRightPresenter(this);
        fenleiRightPresenter.loadRightList(Api.HOST, 1);
    }



    @Override
    public void showList(final List<FenleiLeftBean.DataBean> list) {
        fenleileftAdapter = new FenleileftAdapter(this, list);
        fenleileftrecler.setAdapter(fenleileftAdapter);
        fenleileftAdapter.setOnClickListener(new FenleileftAdapter.OnClickListener() {
            @Override
            public void OnDianji(View v, int position) {
                int cid = list.get(position).cid;
                fenleiRightPresenter.loadRightList(Api.HOST, cid);
            }
        });

    }

    @Override
    public void showError(String e) {

    }

    @Override
    public void showRight(List<FenleiRightBean.DataBean> list) {
        FenleiRightAdapter fenleiRightAdapter = new FenleiRightAdapter(this, list);
        fenleirightrecler.setAdapter(fenleiRightAdapter);
    }
}
