package com.shifeng.webapi.service.mall;

import com.shifeng.dto.mall.MallUserInvoiceDTO;
import com.shifeng.response.ReqResponse;

import java.util.List;

/**
 * 发票
 * @author Win
 *
 */
public interface InvoiceService {
    /**
     * 添加发票
     * @param userInvoice
     * @return
     */
    boolean addInvoice(MallUserInvoiceDTO userInvoice);
 

    /**
     * 删除发票
     * @param user_id
     * @return
     */
    boolean deleteInvoice(String user_id,int invoiceId);

    /**
     * 根据地址ID获取发票详细信息
     * @param user_id
     * @param invoiceId
     * @return
     */
    MallUserInvoiceDTO getInvoiceById(String user_id,int invoiceId);

    /**
     * 根据用户ID获取发票地址列表
     * @param user_id
     * @return
     */
    List<MallUserInvoiceDTO> getInvoiceList(String user_id);

    /**
     * 修改用户发票地址
     * @return
     */
    boolean updateInvoice(MallUserInvoiceDTO invoice);


}
