package com.chg.ultimateproviderdemo.Menu.Model;

import com.chg.ultimateprovider.Model;
import com.chg.ultimateproviderdemo.Menu.ViewHolder.HorizontalScrollViewHolder;
import com.chg.ultimateproviderdemo.ResourceTable;

import java.util.List;

public class FunctionArea implements Model {

    private List<FuncItem> funcItems;

    public List<FuncItem> getFuncItems() {
        return funcItems;
    }

    public void setFuncItems(List<FuncItem> funcItems) {
        this.funcItems = funcItems;
    }
    @Override
    public int getResource(int position) {
        return ResourceTable.Layout_horizontal_scroll;
    }

    @Override
    public Class getHolderClass(int position) {
        return HorizontalScrollViewHolder.class;
    }
}
