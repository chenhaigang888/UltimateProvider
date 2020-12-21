package com.chg.ultimateproviderdemo.Menu.Model;

import com.chg.ultimateprovider.Model;
import com.chg.ultimateproviderdemo.Menu.ViewHolder.SongViewHolder;
import com.chg.ultimateproviderdemo.ResourceTable;

public class SongModel implements Model {

    private String name;
    private String singer;

    public SongModel(String name, String singer) {
        this.name = name;
        this.singer = singer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public int getResources(int position) {
        return ResourceTable.Layout_song_item;
    }

    @Override
    public Class getHolderClass(int position) {
        return SongViewHolder.class;
    }
}
