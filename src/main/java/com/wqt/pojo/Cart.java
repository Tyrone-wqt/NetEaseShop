package com.wqt.pojo;

/**
 * Created by lenovo on 2018/3/9.
 */
public class Cart {
    int id;
    Content content;
    int count;//购物车中的数量

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
