package com.chg.ultimateproviderdemo.slice.model;


import com.chg.ultimateprovider.Model;
import com.chg.ultimateproviderdemo.ResourceTable;
import com.chg.ultimateproviderdemo.slice.ViewHolder.AnimalViewHolder;

public class Animal implements Model {
    private String type;

    public Animal(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int getResources(int position) {
        return ResourceTable.Layout_animal_layout;
    }

    @Override
    public Class getHolderClass(int position) {
        return AnimalViewHolder.class;
    }
}
