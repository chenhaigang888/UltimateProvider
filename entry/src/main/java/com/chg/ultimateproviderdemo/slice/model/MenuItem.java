package com.chg.ultimateproviderdemo.slice.model;

import com.chg.ultimateprovider.Model;
import com.chg.ultimateproviderdemo.ResourceTable;
import com.chg.ultimateproviderdemo.slice.ViewHolder.MenuItemViewHolder;


/**
 * 功能
 */
public class MenuItem implements Model {
    /*演示功能标题*/
    private String title;
    /*功能介绍*/
    private String desc;

    private String AbilityName;

    public MenuItem(String title, String desc, String abilityName) {
        this.title = title;
        this.desc = desc;
        AbilityName = abilityName;
    }

    public String getAbilityName() {
        return AbilityName;
    }

    public void setAbilityName(String abilityName) {
        AbilityName = abilityName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public int getResource(int position) {
        return ResourceTable.Layout_menu_item;
    }

    @Override
    public Class getHolderClass(int position) {
        return MenuItemViewHolder.class;
    }
}
