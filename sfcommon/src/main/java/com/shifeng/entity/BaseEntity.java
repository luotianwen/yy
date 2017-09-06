package com.shifeng.entity;

import java.io.Serializable;

/**
 * Created by yongshi on 2017/3/6.
 */
public class BaseEntity implements Serializable {
    private  String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
