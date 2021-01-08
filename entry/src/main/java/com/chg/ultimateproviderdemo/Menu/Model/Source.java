package com.chg.ultimateproviderdemo.Menu.Model;



import com.chg.ultimateprovider.Model;
import com.chg.ultimateproviderdemo.Menu.ViewHolder.SourceViewHolder;
import com.chg.ultimateproviderdemo.ResourceTable;

import java.io.Serializable;

public class Source implements Model, Serializable {
    private int sourceType;
    private String url;
    //处理过的url
    private String handleUrl;
    private int height;
    private int width;
    private String path;
    private Float duration;
    private Boolean isLongImage;

    public String getHandleUrl() {
        return handleUrl;
    }

    public void setHandleUrl(String handleUrl) {
        this.handleUrl = handleUrl;
    }

    public int getSourceType() {
        return sourceType;
    }

    public void setSourceType(int sourceType) {
        this.sourceType = sourceType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }

    public Boolean getLongImage() {
        return isLongImage;
    }

    public void setLongImage(Boolean longImage) {
        isLongImage = longImage;
    }

    @Override
    public int getResource(int position) {
        return ResourceTable.Layout_source_item;
    }

    @Override
    public Class getHolderClass(int position) {
        return SourceViewHolder.class;
    }
}
