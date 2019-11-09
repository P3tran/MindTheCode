package com.example.demo.pojos;

public class Error {
    private int code;
    private String title;
    private String desc;

    public Error(int code, String title, String desc) {
        this.code = code;
        this.title = title;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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
}
