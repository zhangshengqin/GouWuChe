package com.example.lxhouliu3.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lxhouliu3.R;
import com.example.lxhouliu3.adapter.MyShopAdapter;
import com.example.lxhouliu3.model.GoodsBean;
import com.example.lxhouliu3.model.GroupBean;
import com.example.lxhouliu3.model.IView;
import com.example.lxhouliu3.model.ShopCar;
import com.example.lxhouliu3.presenter.NewsPresenter;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IView {

    @BindView(R.id.tv_bianji)
    TextView tvBianji;
    @BindView(R.id.exlist)
    ExpandableListView exlist;
    @BindView(R.id.check_all)
    public CheckBox checkAll;
    @BindView(R.id.tv_zprice)
    TextView price;
    @BindView(R.id.tv_count)
    TextView counts;
    @BindView(R.id.btn_js)
    Button btnJs;
    ArrayList<GroupBean> groupBeen = new ArrayList<>();
    ArrayList<ArrayList<GoodsBean>> goods = new ArrayList<>();
    private MyShopAdapter adapter;
    private boolean flagedit = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        NewsPresenter presenter = new NewsPresenter();
        presenter.attachView(this);
        Map<String, String> map = new HashMap<>();
        map.put("uid", "2606");
        presenter.getData(map);
        adapter = new MyShopAdapter(this, groupBeen, goods, this);
        exlist.setAdapter(adapter);
        for (int i = 0; i < adapter.getGroupCount(); i++) {
            exlist.expandGroup(i);
        }
        adapter.notifyDataSetChanged();
    }

    @OnClick({R.id.tv_bianji, R.id.check_all, R.id.btn_js})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_bianji:
                String trim = tvBianji.getText().toString().trim();
                if (trim.equals("编辑")) {
                    tvBianji.setText("完成");
                } else {
                    tvBianji.setText("编辑");
                }
                for (List<GoodsBean> i1 : goods) {
                    for (int r = 0; r < i1.size(); r++) {
                        i1.get(r).setBtn(flagedit);
                    }
                }
                flagedit = !flagedit;
                adapter.notifyDataSetChanged();
                break;
            case R.id.check_all:
                boolean checked = checkAll.isChecked();
                for (int i = 0; i < groupBeen.size(); i++) {
                    groupBeen.get(i).setGroupcheck(checked);
                }
                for (int q = 0; q < goods.size(); q++) {
                    ArrayList<GoodsBean> goodsBeen = goods.get(q);
                    for (int j = 0; j < goodsBeen.size(); j++) {
                        goodsBeen.get(j).setGoodscheck(checked);
                    }
                }
                changesum(goods);
                adapter.notifyDataSetChanged();
                break;
            case R.id.btn_js:
                int index = 0;
                for (int q = 0; q < goods.size(); q++) {
                    ArrayList<GoodsBean> goodsBeen = goods.get(q);
                    for (int j = 0; j < goodsBeen.size(); j++) {
                        boolean goodscheck = goodsBeen.get(j).isGoodscheck();
                        if (goodscheck) {
                            index++;
                        }
                    }
                }
                if (index == 0) {
                    Toast.makeText(this, "请选择商品，谢谢", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "钱就是另一回事了", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void OnSuccess(Object o) {
        if (o != null) {
            if (o instanceof List) {
                List<ShopCar.DataBean> data = (List<ShopCar.DataBean>) o;
                for (int i = 0; i < data.size(); i++) {
                    groupBeen.add(new GroupBean(false, data.get(i).getSellerName(), data.get(i).getSellerid()));
                    List<ShopCar.DataBean.ListBean> list = data.get(i).getList();
                    ArrayList<GoodsBean> goodsBeen = new ArrayList<>();
                    for (int j = 0; j < list.size(); j++) {
                        goodsBeen.add(new GoodsBean(false, list.get(j).getBargainPrice(), list.get(j).getImages(), list.get(j).getTitle(), list.get(j).getSubhead(), list.get(j).getNum(), list.get(j).getPid()));
                    }
                    goods.add(goodsBeen);
                }
                for (int i = 0; i < adapter.getGroupCount(); i++) {
                    exlist.expandGroup(i);
                }
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void OnFailed(Exception e) {
        Toast.makeText(this, "shibai", Toast.LENGTH_SHORT).show();
    }

    DecimalFormat df = new DecimalFormat("######0.00");

    public void changesum(ArrayList<ArrayList<GoodsBean>> childBeen) {
        int count = 0;
        double sum = 0;
        for (List<GoodsBean> i1 : childBeen) {
            for (int r = 0; r < i1.size(); r++) {
                boolean childCb1 = i1.get(r).isGoodscheck();
                if (childCb1) {
                    double price = i1.get(r).getBargainPrice();
                    int num = i1.get(r).getNum();
                    sum += price * num;
                    count++;
                }
            }
        }
        price.setText("￥" + df.format(sum));
        counts.setText(count + "");
    }

    public void deleteShop(int pid) {
        Toast.makeText(this, "aadas", Toast.LENGTH_SHORT).show();
    }
}
