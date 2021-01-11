package com.chg.ultimateproviderdemo.Menu.Model;

import com.github.chenhaigang888.Model;
import com.chg.ultimateproviderdemo.Menu.ViewHolder.OneTitleViewHolder;
import com.chg.ultimateproviderdemo.ResourceTable;

public class OneTitleModel implements Model {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public OneTitleModel(String title) {
        this.title = title;
    }

    @Override
    public int getResource(int position) {
        return ResourceTable.Layout_one_title_view;
    }

    @Override
    public Class getHolderClass(int position) {
        return OneTitleViewHolder.class;
    }
}
