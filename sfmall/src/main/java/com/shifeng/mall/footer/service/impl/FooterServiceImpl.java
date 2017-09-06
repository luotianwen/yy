package com.shifeng.mall.footer.service.impl;

import com.shifeng.dao.BaseDao;
import com.shifeng.mall.footer.dto.ExplainDTO;
import com.shifeng.mall.footer.service.FooterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by martins on 2017-04-25.
 */
@Service("footerServiceImpl")
public class FooterServiceImpl implements FooterService {
    @Resource(name = "baseDaoImpl")
    private BaseDao dao;
    public ExplainDTO getExplain(int type, String name) throws Exception {
        Map map=new HashMap();
        map.put("type",type);
        map.put("name",name);
        return (ExplainDTO) dao.findForObject("explainMapper.findAllExplain",map);
    }
}
