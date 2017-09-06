package com.shifeng.provide.mall.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.shifeng.dto.mall.MallUserInvoiceDTO;
import com.shifeng.provide.mall.dao.MallUserInvoiceDao;
import com.shifeng.provide.mall.service.MallUserInvoiceService;
import com.shifeng.response.ReqResponse;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yongshi on 2017/4/21.
 */
@Service(timeout=1200000)
public class MallUserInvoiceImpl implements MallUserInvoiceService {

    private Logger logger = Logger.getLogger(this.getClass());

    @Resource(name = "mallUserInvoiceDao")
    private MallUserInvoiceDao mallUserInvoiceDao;

    @Override
    public ReqResponse<String> addInvoice(MallUserInvoiceDTO address) {
        ReqResponse<String> req = new ReqResponse<String>();
        try {
            mallUserInvoiceDao.addInvoice(address, req);
        } catch (Exception e) {
        	e.printStackTrace();
            logger.error("【添加用户发票地址】出错：", e);
            req.setCode(1);
            req.setMsg("添加用户发票地址异常");
        }
        return req;
    }

    @Override
    public ReqResponse<String> deleteInvoice(String user_id, int invoiceId) {
        ReqResponse<String> req = new ReqResponse<String>();
        try {
            mallUserInvoiceDao.deleteInvoice(user_id,invoiceId, req);
        } catch (Exception e) {
            logger.error("【删除发票地址】出错：", e);
            req.setCode(1);
            req.setMsg("删除发票地址异常");
        }
        return req;
    }

    @Override
    public ReqResponse<MallUserInvoiceDTO> getInvoiceById(String user_id, int invoiceId) {
        ReqResponse<MallUserInvoiceDTO> req = new ReqResponse<MallUserInvoiceDTO>();
        try {
            mallUserInvoiceDao.getInvoiceById(user_id,invoiceId, req);
        } catch (Exception e) {
            logger.error("【根据地址ID获取发票详细信息】出错：", e);
            req.setCode(1);
            req.setMsg("根据地址ID获取发票详细信息异常");
        }
        return req;
    }

    @Override
    public ReqResponse<List<MallUserInvoiceDTO>> getInvoiceList(String user_id) {
        ReqResponse<List<MallUserInvoiceDTO>> req = new ReqResponse<List<MallUserInvoiceDTO>>();
        try {
            mallUserInvoiceDao.getInvoiceList(user_id, req);
        } catch (Exception e) {
            logger.error("【根据用户ID获取发票地址列表】出错：", e);
            req.setCode(1);
            req.setMsg("根据用户ID获取发票地址列表异常");
        }
        return req;
    }

    @Override
    public ReqResponse<String> updateInvoice(MallUserInvoiceDTO invoice) {
        ReqResponse<String> req = new ReqResponse<String>();
        try {
            mallUserInvoiceDao.updateInvoice(invoice, req);
        } catch (Exception e) {
            logger.error("【修改用户发票地址】出错：", e);
            req.setCode(1);
            req.setMsg("修改用户发票地址异常");
        }
        return req;
    }
}
