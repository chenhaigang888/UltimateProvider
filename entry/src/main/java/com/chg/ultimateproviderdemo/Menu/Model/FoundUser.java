package com.chg.ultimateproviderdemo.Menu.Model;

public class FoundUser {
    private String otherId;

    private String nickName;
    private String avatar;
    private String userId;
    private Integer sex;
    private String finalShowName;
    private String exts;

    public String getExts() {
        return exts;
    }

    public void setExts(String exts) {
        this.exts = exts;
    }

    public String getOtherId() {
        return otherId;
    }

    public void setOtherId(String otherId) {
        this.otherId = otherId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getFinalShowName() {
        return finalShowName;
    }

    public void setFinalShowName(String finalShowName) {
        this.finalShowName = finalShowName;
    }
}
