package com.wqt.pojo;

/**
 * Created by lenovo on 2018/3/7.
 */
public class Content {
    int id;
    String cTitle;
    String cAbstract;
    String cText;
    int cPrice;
    String cImgUrl;
    int sid;//发布该内容的用户id
    //对买家来说，这个标记表示已经购买了该商品(tag>0)
//对卖家来说，这个标记表示该商品已经有人购买过(tag>0)
    //tag=0，表示标记为假；
    int tag;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getcTitle() {
        return cTitle;
    }

    public void setcTitle(String cTitle) {
        this.cTitle = cTitle;
    }

    public String getcAbstract() {
        return cAbstract;
    }

    public void setcAbstract(String cAbstract) {
        this.cAbstract = cAbstract;
    }

    public String getcText() {
        return cText;
    }

    public void setcText(String cText) {
        this.cText = cText;
    }

    public int getcPrice() {
        return cPrice;
    }

    public void setcPrice(int cPrice) {
        this.cPrice = cPrice;
    }

    public String getcImgUrl() {
        return cImgUrl;
    }

    public void setcImgUrl(String cImgUrl) {
        this.cImgUrl = cImgUrl;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }
}
