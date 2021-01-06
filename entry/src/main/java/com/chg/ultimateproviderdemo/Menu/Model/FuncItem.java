package com.chg.ultimateproviderdemo.Menu.Model;


import com.chg.ultimateprovider.Model;
import com.chg.ultimateproviderdemo.Menu.ViewHolder.FuncItemViewHolder;
import com.chg.ultimateproviderdemo.ResourceTable;
import ohos.global.resource.Element;

public class FuncItem implements Model {

    private String name;
    private int icon;

    public FuncItem(String name, int icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    @Override
    public int getResource( int position) {
        return ResourceTable.Layout_func_item;
    }

    @Override
    public Class getHolderClass(int position) {
        return FuncItemViewHolder.class;
    }
}
