package com.shifeng.op.fx.controller;

import com.shifeng.entity.fx.FxProduct;
import com.shifeng.entity.shop.Shopinfo;
import com.shifeng.op.entity.users.Users;
import com.shifeng.op.fx.service.FxProductService;
import com.shifeng.op.shop.service.ShopinfoService;
import com.shifeng.op.util.ImportExcelUtil;
import com.shifeng.op.util.JxlsExcelView;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/** 
 * 商品分销价格(fx_product)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-09 10:31:56 
 */ 
@Controller
@RequestMapping(value="/fxproduct")
public class FxProductController{
	
	@Resource(name="fxproductServiceImpl")
	private FxProductService fxproductServiceImpl;
	@Resource(name="shopinfoServiceImpl")
	private ShopinfoService shopinfoServiceImpl;
	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goFxProductList")
	public ModelAndView goFxProductList(ModelAndView mv) throws Exception{
		List<Shopinfo> shopinfos =shopinfoServiceImpl.findAllShopinfoByState();
		mv.addObject("shopinfos",shopinfos);
		mv.setViewName("fx/fxproductList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param fxproduct
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllFxProduct")
	@ResponseBody
	public Map<String,Object> findAllFxProduct(Page page,FxProduct fxproduct) throws Exception{
		if(fxproduct==null){
			fxproduct = new FxProduct();
		}
		page.setT(fxproduct);
		Map<String,Object> map = new HashMap<String,Object>();
		List<FxProduct> fxproducts = fxproductServiceImpl.findAllFxProduct(page);
		map.put("fxproducts", fxproducts);
		map.put("page", page);
		return map;
	}
 
 
	/**
	 * 跳转编辑页面
	 * @param mv
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goFxProductEdit")
	@ResponseBody
	public ModelAndView goFxProductEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("sku", id);
		mv.setViewName("fx/fxproductEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findFxProductById")
	@ResponseBody
	public Map<String,Object> findFxProductById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		FxProduct fxproduct = fxproductServiceImpl.findFxProductById(id);
		map.put("fxproduct",fxproduct);
		return map;
	}
	
	/**
	 * 新增
	 * @param fxproduct
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveFxProduct")
	@ResponseBody
	public Map<String,Object> saveFxProduct(FxProduct fxproduct,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			fxproduct.setUpdatename(user.getuName());
			if (null != fxproduct.getSku2()) {
				fxproductServiceImpl.updateFxProduct(fxproduct);
			}
			else {
				fxproductServiceImpl.saveFxProduct(fxproduct);
			}
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goImport")
	public ModelAndView goImport(ModelAndView mv) throws Exception{
		mv.setViewName("fx/fxproductImport");
		return mv;
	}
	/**
	 * 列表页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/analysis")
	@ResponseBody
	public Map<String,Object> analysis(String url)  {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
        if(StringUtils.isEmpty(url)){
            return map;
        }
		File file=new File(url);
        if(!file.exists())
            return map;
        try {
            readExcel(file);
            map.put(Const.RESPONSE_STATE, 200);
        }catch (Exception e){
            e.printStackTrace();
            map.put(Const.RESPONSE_STATE, 500);
        }
		return map;
	}
	private void readExcel(File file) throws Exception {
		List<List<Object>> listob = null;
		InputStream in = null;
		in = new FileInputStream(file);
		listob = new ImportExcelUtil().getListByExcel(in, file.getName());
		in.close();
		//该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
		for (int i = 0; i < listob.size(); i++) {
			List<Object> lo = listob.get(i);
			fxproductServiceImpl.updateFxProductBySnumber(String.valueOf(lo.get(0)), Double.parseDouble(lo.get(1).toString()));
		}
	}
	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goExport")
	public ModelAndView goExport(Page page,FxProduct fxproduct) throws Exception{
		if(fxproduct==null){
			fxproduct = new FxProduct();
		}
		page.setT(fxproduct);
		Map<String,Object> map = new HashMap<String,Object>();
		List<FxProduct> fxproducts = fxproductServiceImpl.findAllFxProduct(page);
		map.put("fxproducts",fxproducts);
		return new ModelAndView(new JxlsExcelView("/temple/demo.xls","商品名称"),map);
	}
 
}
