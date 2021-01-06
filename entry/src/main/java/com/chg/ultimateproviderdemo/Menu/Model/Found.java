package com.chg.ultimateproviderdemo.Menu.Model;

import java.util.ArrayList;
import java.util.HashMap;


public class Found {
    private String id;
    private String item;
    private String factor;
    private ArrayList<HashMap> feedExts;
    private String type;

    public Found(String id, String item, String factor, ArrayList<HashMap> feedExts, String type) {
        this.id = id;
        this.item = item;
        this.factor = factor;
        this.feedExts = feedExts;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
    }

    public ArrayList<HashMap> getFeedExts() {
        return feedExts;
    }

    public void setFeedExts(ArrayList<HashMap> feedExts) {
        this.feedExts = feedExts;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
