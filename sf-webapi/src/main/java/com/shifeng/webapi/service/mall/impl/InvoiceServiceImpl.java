package com.shifeng.webapi.service.mall.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shifeng.dto.mall.MallUserInvoiceDTO;
import com.shifeng.provide.mall.service.MallUserInvoiceService;
import com.shifeng.response.ReqResponse;
import com.shifeng.webapi.service.mall.InvoiceService;

/**
 * 发票
 * @author Win
 *
 */
@Service("invoiceServiceImpl")
public class InvoiceServiceImpl implements InvoiceService{

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "mallUserInvoiceService")
	protected MallUserInvoiceService mallUserInvoiceService;
    /**
     * 添加发票
     * @param address
     * @return
     */
	public boolean addInvoice(MallUserInvoiceDTO userInvoice) {
		try {
			ReqResponse<String> result = mallUserInvoiceService.addInvoice(userInvoice);
			if(result.getCode() == 0){
					return true;
			}
		} catch (Exception e) {
			logger.error("【添加发票】出错：", e);
		}
		return false;
	}
 

    /**
     * 删除发票
     * @param user_id
     * @return
     */
    public boolean deleteInvoice(String user_id,int invoiceId) {
		try {
			ReqResponse<String> result = mallUserInvoiceService.deleteInvoice(user_id,invoiceId);
			if(result.getCode() == 0){
					return true;
			}
		} catch (Exception e) {
			logger.error("【删除发票】出错：", e);
		}
		return false;
	}

    /**
     * 根据地址ID获取发票详细信息
     * @param user_id
     * @param invoiceId
     * @return
     */
    public MallUserInvoiceDTO getInvoiceById(String user_id,int invoiceId) {
		try {
			ReqResponse<MallUserInvoiceDTO> result = mallUserInvoiceService.getInvoiceById(user_id,invoiceId);
			if(result.getCode() == 0){
					return result.getData();
			}
		} catch (Exception e) {
			logger.error("【 根据地址ID获取发票详细信息】出错：", e);
		}
		return null;
	}

    /**
     * 根据用户ID获取发票地址列表
     * @param user_id
     * @return
     */
    public List<MallUserInvoiceDTO> getInvoiceList(String user_id) {
		try {
			ReqResponse<List<MallUserInvoiceDTO>> result = mallUserInvoiceService.getInvoiceList(user_id);
			if(result.getCode() == 0){
					return result.getData();
			}
		} catch (Exception e) {
			logger.error("【根据用户ID获取发票地址列表】出错：", e);
		}
		return null;
	}

    /**
     * 修改用户发票地址
     * @return
     */
    public boolean updateInvoice(MallUserInvoiceDTO invoice) {
		try {
			ReqResponse<String> result = mallUserInvoiceService.updateInvoice(invoice);
			if(result.getCode() == 0){
					return true;
			}
		} catch (Exception e) {
			logger.error("【修改用户发票地址】出错：", e);
		}
		return false;
	}


}
