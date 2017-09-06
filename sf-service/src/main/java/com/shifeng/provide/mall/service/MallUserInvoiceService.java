package com.shifeng.provide.mall.service;

import com.shifeng.dto.mall.MallUserInvoiceDTO;
import com.shifeng.response.ReqResponse;

import java.util.List;

/**
 * Created by yongshi on 2017/4/21.
 */
public interface MallUserInvoiceService {
    /**
     * 添加发票
     * @param address
     * @return
     */
    ReqResponse<String> addInvoice(MallUserInvoiceDTO address);
 

    /**
     * 删除发票
     * @param user_id
     * @return
     */
    ReqResponse<String> deleteInvoice(String user_id,int invoiceId);

    /**
     * 根据地址ID获取发票详细信息
     * @param user_id
     * @param invoiceId
     * @return
     */
    ReqResponse<MallUserInvoiceDTO> getInvoiceById(String user_id,int invoiceId);

    /**
     * 根据用户ID获取发票地址列表
     * @param user_id
     * @return
     */
    ReqResponse<List<MallUserInvoiceDTO>> getInvoiceList(String user_id);

    /**
     * 修改用户发票地址
     * @return
     */
    ReqResponse<String> updateInvoice(MallUserInvoiceDTO invoice);


}
