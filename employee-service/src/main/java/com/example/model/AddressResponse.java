package com.example.model;

public class AddressResponse {
    private   int id;
    private String lane1;
    private String lane2;
    private int zip;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLane1() {
        return lane1;
    }

    public void setLane1(String lane1) {
        this.lane1 = lane1;
    }

    public String getLane2() {
        return lane2;
    }

    public void setLane2(String lane2) {
        this.lane2 = lane2;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

}
