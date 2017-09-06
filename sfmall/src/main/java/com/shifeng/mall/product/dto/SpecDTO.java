package com.shifeng.mall.product.dto;

/**
 * Created by yongshi on 2017/4/13.
 */
public class SpecDTO {
    private String id;
    private String name;
    private int status;
    private int check=0;

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

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
