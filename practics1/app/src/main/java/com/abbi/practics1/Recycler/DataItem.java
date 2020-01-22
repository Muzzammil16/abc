package com.abbi.practics1.Recycler;

public class DataItem {

    private String name;
    private String phonenumber;

    public DataItem(String name, String phonenumber) {
        this.name = name;
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getName() {
        return name;
    }
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setName(String name) {
        this.name = name;
    }



}
