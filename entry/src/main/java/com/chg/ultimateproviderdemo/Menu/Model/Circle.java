package com.chg.ultimateproviderdemo.Menu.Model;


import com.github.chenhaigang888.Model;
import com.github.chenhaigang888.ViewHolder;

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
