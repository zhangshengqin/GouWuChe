package com.example.lxhouliu3.model;

/**
 * 作者 陈飞 on 2017/11/21 0021.
 */

public class GroupBean {
    private boolean groupcheck;
    private String sellerName;
    private String sellerid;

    public GroupBean(boolean groupcheck, String sellerName, String sellerid) {
        this.groupcheck = groupcheck;
        this.sellerName = sellerName;
        this.sellerid = sellerid;
    }

    public boolean isGroupcheck() {
        return groupcheck;
    }

    public void setGroupcheck(boolean groupcheck) {
        this.groupcheck = groupcheck;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerid() {
        return sellerid;
    }

    public void setSellerid(String sellerid) {
        this.sellerid = sellerid;
    }

    @Override
    public String toString() {
        return "GroupBean{" +
                "groupcheck=" + groupcheck +
                ", sellerName='" + sellerName + '\'' +
                ", sellerid=" + sellerid +
                '}';
    }
}
