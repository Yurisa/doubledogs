package com.entity;

/**
 * Created by Yurisa on 2017/6/7.
 */
public class Product {
  private  int f_id;
  private  String name;
  private  String url;
  private String type;
  private  String subtype;
  private int price;
  private int time;
  private String designer;
  private String range1;
  private  String marterial;

    public int getF_id() {
        return f_id;
    }

    public void setF_id(int f_id) {
        this.f_id = f_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public String getRange1() {
        return range1;
    }

    public void setRange1(String range1) {
        this.range1 = range1;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDesigner() {
        return designer;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }


    public String getMarterial() {
        return marterial;
    }

    public void setMarterial(String marterial) {
        this.marterial = marterial;
    }


}
