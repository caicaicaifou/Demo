package com.exec.mybatis.dto;

import com.exec.mybatis.entity.Category;
import com.exec.mybatis.entity.Goods;

//Data Transfer Object--数据传输对象
public class GoodsDTO {
    private Goods goods = new Goods();
    private Category category = new Category();

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
