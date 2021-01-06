package com.chg.ultimateproviderdemo.Menu.Model;


import com.chg.ultimateprovider.Model;
import com.chg.ultimateprovider.ViewHolder;

class Circle implements Model {
    @Override
    public int getResource(int position) {
        return 0;
    }

    @Override
    public Class<ViewHolder<Model>> getHolderClass(int position) {
        return null;
    }
}
