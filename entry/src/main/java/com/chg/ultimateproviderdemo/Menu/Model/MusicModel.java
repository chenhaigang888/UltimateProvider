package com.chg.ultimateproviderdemo.Menu.Model;

import com.github.chenhaigang888.Model;
import com.chg.ultimateproviderdemo.Menu.ViewHolder.MusicViewHolder;
import com.chg.ultimateproviderdemo.ResourceTable;

import java.util.List;

public class MusicModel implements Model {

    private String title;
    private List data;

    public MusicModel(String title, List data) {
        this.title = title;
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    @Override
    public int getResource(int position) {
        return ResourceTable.Layout_music_item;
    }

    @Override
    public Class getHolderClass(int position) {
        return MusicViewHolder.class;
    }
}
