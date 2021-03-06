package com.chg.ultimateproviderdemo.Menu.Model;

import com.github.chenhaigang888.Model;
import com.chg.ultimateproviderdemo.Menu.ViewHolder.AlbumViewHolder;
import com.chg.ultimateproviderdemo.ResourceTable;

public class AlbumModel implements Model {

    private String name;
    private String songer;

    public AlbumModel(String name, String songer) {
        this.name = name;
        this.songer = songer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSonger() {
        return songer;
    }

    public void setSonger(String songer) {
        this.songer = songer;
    }

    @Override
    public int getResource(int position) {
        return ResourceTable.Layout_album_item;
    }

    @Override
    public Class getHolderClass(int position) {
        return AlbumViewHolder.class;
    }
}
