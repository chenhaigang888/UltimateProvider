package com.chg.ultimateproviderdemo.slice.model;


import com.chg.ultimateprovider.Model;
import com.chg.ultimateproviderdemo.ResourceTable;
import com.chg.ultimateproviderdemo.slice.ViewHolder.UserViewHolder;

public class UserBean implements Model {
    private String name;

    public UserBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getResources(int position) {
        return ResourceTable.Layout_user_layout;
    }

    @Override
    public Class getHolderClass(int position) {
        return UserViewHolder.class;
    }
}
