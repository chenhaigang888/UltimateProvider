package com.chg.ultimateproviderdemo.Menu.Model;

import com.chg.ultimateprovider.Model;
import com.chg.ultimateproviderdemo.Menu.ViewHolder.TabItemViewHolder;
import com.chg.ultimateproviderdemo.ResourceTable;

public class TabItem implements Model {
    private int id;
    private String name;

    public TabItem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getResources(int position) {
        return ResourceTable.Layout_tab_item;
    }

    @Override
    public Class getHolderClass(int position) {
        return TabItemViewHolder.class;
    }
}
