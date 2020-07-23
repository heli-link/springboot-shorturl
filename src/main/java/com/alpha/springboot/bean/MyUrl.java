package com.alpha.springboot.bean;

public class MyUrl {
     int id;
     String longurl;
     String srandom;
     String creatTime;

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    @Override
    public String toString() {
        return "MyUrl{" +
                "id=" + id +
                ", longurl='" + longurl + '\'' +
                ", srandom='" + srandom + '\'' +
                ", creatTime='" + creatTime + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLongurl() {
        return longurl;
    }

    public void setLongurl(String longurl) {
        this.longurl = longurl;
    }

    public String getSrandom() {
        return srandom;
    }

    public void setSrandom(String srandom) {
        this.srandom = srandom;
    }
}
