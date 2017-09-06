package com.shifeng.mall.homepage.service.impl;

import com.alibaba.fastjson.JSON;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.system.SysSpecial;
import com.shifeng.mall.homepage.service.SysSpecialService;
import com.shifeng.util.Const;
import com.shifeng.util.redis.RedisTool;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yongshi on 2017/5/22.
 */
@Service("sysSpecialServiceImpl")
public class SysSpecialServiceImpl implements SysSpecialService {
    @Resource(name = "baseDaoImpl")
    private BaseDao dao;
    @Override
    public SysSpecial getSysSpecialByTitle(String id) throws Exception {
        if(StringUtils.isEmpty(id))
            return null;
        String key=String.format(Const.SPECIAL_CACHE_FLAG,id);
        String flag="0";
        try{
            flag= RedisTool.get(key);
        }catch (Exception e){
            flag="0";
        }
        if(StringUtils.isEmpty(flag)){
            flag="0";
        }
        key=String.format(Const.SPECIAL_DETAIL_CACHE,id);
        //从数据库读取更新
        if(flag.equals("0")){
            return getCacheSysSpecial(id);
        }
        else{
            //缓存中读取
            String ws=RedisTool.get(key);
            if(StringUtils.isEmpty(ws)){
                return getCacheSysSpecial(id);
            }

            return JSON.parseObject(ws, SysSpecial.class);
        }
       /*
       ;*/
    }
    private SysSpecial getCacheSysSpecial(String id) throws Exception {
        SysSpecial  sysspecial= (SysSpecial) dao.findForObject("sysspecialMapper.findSysSpecialById",id);
        String key=String.format(Const.SPECIAL_DETAIL_CACHE,id);
        String str= JSON.toJSONString(sysspecial);
        RedisTool.set(key,str);
        RedisTool.set(String.format(Const.SPECIAL_CACHE_FLAG,id),"1");
        return sysspecial;
    }

}
