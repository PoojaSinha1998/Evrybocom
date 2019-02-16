package com.intellinettechnologies.evrybocom.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("vendor")
    @Expose
    private String vendor;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("available")
    @Expose
    private String available;
    @SerializedName("available1")
    @Expose
    private String available1;
    @SerializedName("date")
    @Expose
    private String date;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getAvailable1() {
        return available1;
    }

    public void setAvailable1(String available1) {
        this.available1 = available1;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
