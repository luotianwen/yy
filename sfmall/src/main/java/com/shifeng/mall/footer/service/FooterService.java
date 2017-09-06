package com.shifeng.mall.footer.service;

import com.shifeng.mall.footer.dto.ExplainDTO;

/**
 * Created by martins on 2017-04-25.
 */
public interface FooterService {
    //<select name="type" class="form-control m-b"><option value="1">购物指南</option> <option value="2">如何支付</option> <option value="3">常见问题</option> <option value="4">售后服务</option> <option value="5">商务合作</option> <option value="6">合同范本</option> <option value="7">关于我们</option></select>
   public ExplainDTO getExplain(int type,String name) throws Exception;
}
