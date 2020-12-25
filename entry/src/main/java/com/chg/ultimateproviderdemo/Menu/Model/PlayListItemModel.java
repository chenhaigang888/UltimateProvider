package com.chg.ultimateproviderdemo.Menu.Model;

import com.chg.ultimateprovider.Model;
import com.chg.ultimateproviderdemo.Menu.ViewHolder.PlayListItemViewHolder;
import com.chg.ultimateproviderdemo.ResourceTable;

public class PlayListItemModel implements Model {
    /*歌曲名称*/
    private String name;
    /*歌手*/
    private String songer;
    /*是否喜欢*/
    private boolean love = false;
    /*是否收藏*/
    private boolean collection = false;
    /*是否正在播放*/
    private boolean play = false;

    public PlayListItemModel(String name, String songer) {
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

    public boolean isLove() {
        return love;
    }

    public void setLove(boolean love) {
        this.love = love;
    }

    public boolean isCollection() {
        return collection;
    }

    public void setCollection(boolean collection) {
        this.collection = collection;
    }

    public boolean isPlay() {
        return play;
    }

    public void setPlay(boolean play) {
        this.play = play;
    }

    @Override
    public int getResource(int position) {
        return ResourceTable.Layout_play_list_item;
    }

    @Override
    public Class getHolderClass(int position) {
        return PlayListItemViewHolder.class;
    }
}
