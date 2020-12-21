package com.chg.ultimateproviderdemo.slice.model;


import com.chg.ultimateprovider.Model;
import com.chg.ultimateproviderdemo.ResourceTable;
import com.chg.ultimateproviderdemo.slice.ViewHolder.GroupViewHolder;

import java.util.List;

public class GroupBean implements Model {

    private String name;
    private List<FriendItem> friends;

    public GroupBean(String name, List<FriendItem> friends) {
        this.name = name;
        this.friends = friends;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FriendItem> getFriends() {
        return friends;
    }

    public void setFriends(List<FriendItem> friends) {
        this.friends = friends;
    }

    @Override
    public int getResources(int position) {
        return ResourceTable.Layout_group_layout;
    }

    @Override
    public Class getHolderClass(int position) {
        return GroupViewHolder.class;
    }
}
