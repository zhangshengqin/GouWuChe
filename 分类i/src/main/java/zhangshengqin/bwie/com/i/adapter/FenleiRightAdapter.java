package zhangshengqin.bwie.com.i.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import zhangshengqin.bwie.com.i.R;
import zhangshengqin.bwie.com.i.bean.FenleiRightBean;

/**
 * Created by 额头发 on 2017/12/16.
 */

public class FenleiRightAdapter extends RecyclerView.Adapter<FenleiRightAdapter.ViewHolder>{
    private Context context;
    private List<FenleiRightBean.DataBean> rightlist;

    public FenleiRightAdapter(Context context, List<FenleiRightBean.DataBean> rightlist) {
        this.context = context;
        this.rightlist = rightlist;
    }

    @Override
    public FenleiRightAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fenlei_right_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FenleiRightAdapter.ViewHolder holder, int position) {
//      holder.right_name.setText(rightlist.get(position).list.get(0).name);
        holder.right_name.setText(rightlist.get(position).getName());
        GridLayoutManager gridLayoutManager=new GridLayoutManager(context,3);
        holder.childrecycler.setLayoutManager(gridLayoutManager);
        FenleiChildAdapter fenleiChildAdapter = new FenleiChildAdapter(context, rightlist.get(position).list);
        holder.childrecycler.setAdapter(fenleiChildAdapter);
    }

    @Override
    public int getItemCount() {
        return rightlist.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView right_name;
        public RecyclerView childrecycler;
        public ViewHolder(View itemView) {
            super(itemView);
            right_name=itemView.findViewById(R.id.right_name);
            childrecycler=itemView.findViewById(R.id.childrecycler);
        }
    }

}
