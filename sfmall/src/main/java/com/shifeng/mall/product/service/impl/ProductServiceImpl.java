package com.shifeng.mall.product.service.impl;

import com.alibaba.fastjson.JSON;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.brand.Brand;
import com.shifeng.entity.search.WareSkuInfo;
import com.shifeng.mall.product.service.ProductService;
import com.shifeng.util.Const;
import com.shifeng.util.redis.RedisTool;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yongshi on 2017/4/14.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Resource(name = "baseDaoImpl")
    private BaseDao dao;

    @Override
    public List<WareSkuInfo> everybodybuy(String cid, String pcid, String pid) throws Exception {
        if(StringUtils.isEmpty(cid)&&StringUtils.isEmpty(pcid)&&StringUtils.isEmpty(pid))
           return null;
        Map map=new HashMap<>();
        map.put("cid",cid);
        map.put("pcid",pcid);
        map.put("pid",pid);
        return (List<WareSkuInfo>) dao.findForList("prorulesMapper.everybodybuy",map);
    }

    @Override
    public List<WareSkuInfo> guessyoulike(String cid, String pcid, String pid) throws Exception {
        if(StringUtils.isEmpty(cid)&&StringUtils.isEmpty(pcid)&&StringUtils.isEmpty(pid))
            return null;
        Map map=new HashMap<>();
        map.put("cid",cid);
        map.put("pcid",pcid);
        map.put("pid",pid);
        return (List<WareSkuInfo>) dao.findForList("prorulesMapper.guessyoulike",map);
    }

    @Override
    public Brand getBandInfoById(String bandid) throws Exception {
        if(StringUtils.isEmpty(bandid)) {
            return null;
        }
        String flag="0";
        try{
            flag=RedisTool.get(String.format(Const.BAND_CACHE_FLAG,bandid));
        }catch (Exception e){
            flag="0";
        }
        if(StringUtils.isEmpty(flag)){
            flag="0";
        }
        if(flag.equals("0")) {
            return getCacheBrandInfo(bandid);
        }
        String key=String.format(Const.BAND_DETAIL_CACHE,bandid);
        String ws=RedisTool.get(key);
        if(StringUtils.isEmpty(ws)){
            return getCacheBrandInfo(bandid);
        }
        return JSON.parseObject(ws, Brand.class);
    }
    private Brand getCacheBrandInfo(String brandid)throws Exception{
        String key=String.format(Const.BAND_DETAIL_CACHE,brandid);
        Brand brand=(Brand)dao.findForObject("brandMapper.findBrandById",brandid);
        String str= JSON.toJSONString(brand);
        RedisTool.set(key,str);
        RedisTool.set(String.format(Const.BAND_CACHE_FLAG,brandid),"1");
        return brand;
    }
}
