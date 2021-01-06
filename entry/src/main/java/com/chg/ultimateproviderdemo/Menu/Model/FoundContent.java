package com.chg.ultimateproviderdemo.Menu.Model;

import java.util.List;

public class FoundContent {
    private String content;
    private List<Source> source;
    private int browses;
    private String cover;
    private Integer type;
    private Integer imageShowType;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getImageShowType() {
        return imageShowType;
    }

    public void setImageShowType(Integer imageShowType) {
        this.imageShowType = imageShowType;
    }

    public int getBrowses() {
        return browses;
    }

    public void setBrowses(int browses) {
        this.browses = browses;
    }

    public List<Source> getSource() {
        return source;
    }

    public void setSource(List<Source> source) {
        this.source = source;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
