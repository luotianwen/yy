package com.shifeng.seller.shop.controller;

import com.shifeng.entity.shop.MerchantsSettled;
import com.shifeng.entity.shop.Shopinfo;
import com.shifeng.entity.shop.StoreSupervisor;
import com.shifeng.provide.system.service.SystemService;
import com.shifeng.seller.controller.BaseController;
import com.shifeng.seller.entity.users.Users;
import com.shifeng.seller.shop.dto.ShopCategoryDTO;
import com.shifeng.seller.shop.service.MerchantsSettledService;
import com.shifeng.seller.shop.service.ShopCategoryService;
import com.shifeng.seller.shop.service.ShopinfoService;
import com.shifeng.seller.shop.service.StoreSupervisorService;
import com.shifeng.util.Const;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;


/** 
 * 店铺表(s_shopinfo)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-28 17:55:22 
 */ 
@Controller
@RequestMapping(value="/shopinfo")
public class ShopinfoController extends BaseController {
	
	@Resource(name="shopinfoServiceImpl")
	private ShopinfoService shopinfoServiceImpl;
	
	@Resource(name="merchantssettledServiceImpl")
	private MerchantsSettledService merchantssettledServiceImpl;
	
	@Resource(name="storesupervisorServiceImpl")
	private StoreSupervisorService storesupervisorServiceImpl;
	
	@Resource(name="shopcategoryServiceImpl")
	private ShopCategoryService shopcategoryServiceImpl;
	@Resource(name="systemService")
	private SystemService systemServiceImpl;
	/**
	 * 查询店铺信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/myshop")
	@ResponseBody
	public ModelAndView myshop(ModelAndView mv,String id,HttpSession session) throws Exception{
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		
		MerchantsSettled merchantsSettled = merchantssettledServiceImpl.findMerchantsSettledByShopId(user.getShopid()+"");
		Shopinfo shopinfo = shopinfoServiceImpl.findShopinfoByMid(merchantsSettled.getId()+"");
		List<StoreSupervisor> storeSupervisors = storesupervisorServiceImpl.findStoreSupervisorByMid(merchantsSettled.getId()+"");
		List<ShopCategoryDTO> shopCategorys = shopcategoryServiceImpl.findShopCategoryByMid(merchantsSettled.getId()+"");
		StringBuffer sb=new StringBuffer("");
		if(!StringUtils.isEmpty(merchantsSettled.getCompanyArea())){
			String[] area=merchantsSettled.getCompanyArea().split(",");
			sb.append(systemServiceImpl.getProvinceNameById(area[0])).append(" ");
			sb.append(systemServiceImpl.getCityNameByPid(area[1])).append(" ");
			sb.append(systemServiceImpl.getAreaNameByCid(area[2]));
			merchantsSettled.setCompanyArea(sb.toString());
		}
		if(!StringUtils.isEmpty(merchantsSettled.getLocationBankbranch())){
			sb=new StringBuffer("");
			String[] area=merchantsSettled.getLocationBankbranch().split(",");
			sb.append(systemServiceImpl.getProvinceNameById(area[0])).append(" ");
			sb.append(systemServiceImpl.getCityNameByPid(area[1])).append(" ");
			sb.append(systemServiceImpl.getAreaNameByCid(area[2]));
			merchantsSettled.setLocationBankbranch(sb.toString());
		}
		mv.addObject("merchantsSettled", merchantsSettled);
		mv.addObject("shopinfo", shopinfo);
		mv.addObject("storeSupervisors", storeSupervisors);
		mv.addObject("shopCategorys", shopCategorys);
		
		mv.setViewName("shop/myshop");
		
		return mv;
	}

}
