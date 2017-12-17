package com.example.lxhouliu3.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lxhouliu3.R;

/**
 * 作者 陈飞 on 2017/11/21 0021.0
 */

public class AddDeleteView extends LinearLayout {
    private OnAddDelClickListener listener;
    private EditText etNumber;

    //对外提供一个点击的回调接口
    public interface OnAddDelClickListener {
        void onAddClick(View v);

        void onDelClick(View v);
    }

    public void setOnAddDelClickListener(OnAddDelClickListener listener) {
        if (listener != null) {
            this.listener = listener;
        }
    }

    public AddDeleteView(Context context) {
        this(context, null);
    }

    public AddDeleteView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AddDeleteView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs, defStyleAttr);
    }

    private void initView(Context context, AttributeSet attrs, int defStyleAttr) {
        View.inflate(context, R.layout.adddelete, this);
        TextView txtDelete = findViewById(R.id.tv_delete);
        TextView txtAdd = findViewById(R.id.tv_add);
        etNumber = findViewById(R.id.ed_num);


        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AddDeleteView);

        String leftText = typedArray.getString(R.styleable.AddDeleteView_left_item);
        String rightText = typedArray.getString(R.styleable.AddDeleteView_right_item);
        String middleText = typedArray.getString(R.styleable.AddDeleteView_middle_item);

        txtDelete.setText(leftText);
        txtAdd.setText(rightText);
        etNumber.setText(middleText);

        //回收
        typedArray.recycle();


        txtDelete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onDelClick(view);
            }
        });

        txtAdd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onAddClick(view);
            }
        });

    }

    //对外提供一个修改数字的方法
    public void setNumber(int number) {
        if (number > 0) {
            etNumber.setText(number + "");
        }
    }

    //对外提供一个获取当前数字的方法
    public int getNumber() {
        String string = etNumber.getText().toString();
        int i = Integer.parseInt(string);
        return i;
    }
}
