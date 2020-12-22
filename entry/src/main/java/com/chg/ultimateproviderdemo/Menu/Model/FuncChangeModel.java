package com.chg.ultimateproviderdemo.Menu.Model;

import com.chg.ultimateprovider.Model;
import com.chg.ultimateproviderdemo.Menu.ViewHolder.FuncChangeViewHolder;
import com.chg.ultimateproviderdemo.ResourceTable;

import java.util.List;

public class FuncChangeModel implements Model {
    private List<TabItem> tabs;

    public List<TabItem> getTabs() {
        return tabs;
    }

    public void setTabs(List<TabItem> tabs) {
        this.tabs = tabs;
    }

    public FuncChangeModel(List<TabItem> tabs) {
        this.tabs = tabs;
    }

    @Override
    public int getResources(int position) {
        return ResourceTable.Layout_func_change_item;
    }

    @Override
    public Class getHolderClass(int position) {
        return FuncChangeViewHolder.class;
    }
}
