package com.zsx.crm_excel.pojo;

import java.util.Date;

public class UserInfo {

    private Long id; //id
    private String name; //用户名字
    private String tel; //电话
    private String qita; //其他
    private String tag; //提交标签
    private String origin; //来源地址
    private String time; //提交时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getQita() {
        return qita;
    }

    public void setQita(String qita) {
        this.qita = qita;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public UserInfo(){

    }

    public UserInfo(Long id, String name, String tel, String qita, String tag, String origin, String time) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.qita = qita;
        this.tag = tag;
        this.origin = origin;
        this.time = time;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", qita='" + qita + '\'' +
                ", tag='" + tag + '\'' +
                ", origin='" + origin + '\'' +
                ", time=" + time +
                '}';
    }
}
