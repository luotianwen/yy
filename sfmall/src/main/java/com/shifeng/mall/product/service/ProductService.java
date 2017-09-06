package com.shifeng.mall.product.service;

import com.shifeng.entity.brand.Brand;
import com.shifeng.entity.search.WareSkuInfo;

import java.util.List;

/**
 * Created by yongshi on 2017/4/14.
 */

public interface ProductService {
    /**
     *大家都在买
     */
    List<WareSkuInfo> everybodybuy(String cid, String pcid, String sku)throws Exception;
    /**
     *猜你喜欢
     */
      List<WareSkuInfo> guessyoulike(String cid,String pcid,String sku) throws Exception;
    /**
     *品牌信息
     */
      Brand getBandInfoById(String bandid)throws Exception;
}
