package com.chg.ultimateproviderdemo.slice.model;


import com.chg.ultimateproviderdemo.ResourceTable;
import com.chg.ultimateproviderdemo.slice.ViewHolder.FriendItemViewHolder;

public class FriendItem extends UserBean {
    private String city;

    public FriendItem(String name, String city) {
        super(name);
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public Class getHolderClass(int position) {
        return FriendItemViewHolder.class;
    }

    @Override
    public int getResources(int position) {
        return ResourceTable.Layout_friend_item_layout;
    }
}
