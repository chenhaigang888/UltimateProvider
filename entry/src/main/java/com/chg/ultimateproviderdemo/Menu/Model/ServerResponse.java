package com.chg.ultimateproviderdemo.Menu.Model;

import java.util.List;

public class ServerResponse {
    private String message;
    private String code;
    private List<Found> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Found> getData() {
        return data;
    }

    public void setData(List<Found> data) {
        this.data = data;
    }
}
