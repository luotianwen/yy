package com.shifeng.op.dto.product;

import com.shifeng.entity.product.Product;

/**
 * Created by yongshi on 2017/2/28.
 */
public class ProductDTO extends Product {
    private String shopName;
    private String brandName;
    private String categoryName;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
