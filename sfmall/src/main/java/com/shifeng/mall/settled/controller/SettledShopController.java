package com.shifeng.mall.settled.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shifeng.common.OrderType;
import com.shifeng.common.PaymentMethod;
import com.shifeng.entity.category.Category;
import com.shifeng.entity.shop.ShopinfoLog;
import com.shifeng.entity.shop.ShopinfoPay;
import com.shifeng.mall.category.service.CategoryService;
import com.shifeng.mall.controller.BaseController;
import com.shifeng.mall.entity.user.Users;
import com.shifeng.mall.service.YzmService;
import com.shifeng.mall.settled.dto.ProgressDTO;
import com.shifeng.mall.settled.dto.ShopCategoryDTO;
import com.shifeng.mall.settled.dto.ShopDTO;
import com.shifeng.mall.settled.service.MerchantsSettledService;
import com.shifeng.mall.util.UrlUtil;
import com.shifeng.provide.system.service.SystemService;
import com.shifeng.util.Const;
import com.shifeng.util.MD5Util;
import com.shifeng.util.redis.RedisTool;

/**
 * 商家入驻
 */
@Controller
@RequestMapping(value = "/settled")
public class SettledShopController extends BaseController {
	@Resource(name="systemService")
	private SystemService systemServiceImpl;
    @Resource(name="merchantssettledServiceImpl")
    private MerchantsSettledService merchantssettledServiceImpl;
    
    @Resource(name="categoryServiceImpl")
	private CategoryService categoryServiceImpl;
    
    @Resource(name = "yzmServiceImpl")
    private YzmService yzmServiceImpl;
    
    /**
     *入驻首页
     */
    @RequestMapping(value = "/check")
    public ModelAndView check( ModelAndView mv,HttpSession session) throws Exception {
        checkLogin(mv,session);
        //增加是否入驻判断
        Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
        if(user!=null){
            try {
                ShopDTO shopDTO=merchantssettledServiceImpl.findMerchantsSettledByUserId(user.getuId()+"");
                if(null==shopDTO) {
                    mv.setViewName(basePath + "settled/check_home.btl");
                }else{
                	return redirect(shopDTO.getNext());
                }
            } catch (Exception e) {
                e.printStackTrace();
                mv.setViewName("500");
            }

        }else{
            mv.setViewName("500");
        }

        return mv;

    }
    
    public ModelAndView redirect(int next){
    	if (next == 1) {
			return new ModelAndView("redirect:/settled/check_in_1.html");
		} else if (next == 2) {
			return new ModelAndView("redirect:/settled/check_in_2.html");
		} else if (next == 3) {
			return new ModelAndView("redirect:/settled/check_in_3.html");
		} else if (next == 4) {
			return new ModelAndView("redirect:/settled/check_in_4.html");
		} else if (next == 5) {
			return new ModelAndView("redirect:/settled/check_in_5.html");
		}else{
			return new ModelAndView(basePath + "settled/check_home.btl");
		}
    }
    
    /**
     *查看入住须知及协议
     */
    @RequestMapping(value = "/check_in")
    public ModelAndView check_in( ModelAndView mv,HttpSession session) {
    	Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		try {
			int next = merchantssettledServiceImpl.findNext(user.getuId());
			if(next!=0){
	    		return redirect(next);
	    	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	mv.setViewName(basePath+"settled/check_in.btl");
        return mv;

    }
    
    @RequestMapping(value="check_in_save")
    @ResponseBody
    public Map<String,String> check_in_save(HttpSession session){
    	Map<String,String> map = new HashMap<String,String>();
    	Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
    	try {
    		int next = merchantssettledServiceImpl.findNext(user.getuId());
			if(next==0){
				session.setAttribute("next", "1");
	    	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
    	return map;
    }
    
    /**
     *填写公司信息
     */
    @RequestMapping(value = "/check_in_1")
    public ModelAndView check_in_1( ModelAndView mv,HttpSession session ) {
        Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
        try {
            ShopDTO shopDTO=merchantssettledServiceImpl.findMerchantsSettledByUserId(user.getuId()+"");
            if(shopDTO!=null){
            	if(shopDTO.getNext()==0){
    				if(session.getAttribute("next")!=null){
    					shopDTO.setNext(Integer.valueOf(session.getAttribute("next")+""));
    				}
    	    	}
            	if(shopDTO.getNext()==1){
            		mv.addObject("shopDTO",shopDTO);
                    List provinces = systemServiceImpl.getAllProvince();
                    mv.addObject("provinces",provinces);
                    mv.setViewName(basePath+"settled/check_in_1.btl");
            	}else{
            		return redirect(shopDTO.getNext());
            	}
            }else{
            	mv.setViewName(basePath + "settled/check_home.btl");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }
    
    /**
     *保存公司信息
     */
    @RequestMapping(value = "/check_in_1_save")
    @ResponseBody
    public Map<String,Object> check_in_1_save(HttpSession session,ShopDTO shopDTO ) {
        Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
        Map<String,Object> map = new HashMap<String,Object>();

        try {
        	int next = merchantssettledServiceImpl.findNext(user.getuId());
			if(next==1){
				merchantssettledServiceImpl.updateMerchantssettled(shopDTO,user);
				
				yzmServiceImpl.delSettled(user.getuId());
	    	}
        	map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);
            map.put(Const.ERROR_INFO, "保存错误");
        }

        return map;
    }
    /**
     *填写公司信息
     */
    @RequestMapping(value = "/check_in_2")
    public ModelAndView check_in_2( ModelAndView mv,HttpSession session ) {
        Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
        try {
        	ShopDTO shopDTO = merchantssettledServiceImpl.findShopByUserId(user.getuId());
        	if(shopDTO==null){
        		int next = merchantssettledServiceImpl.findNext(user.getuId());
            	if(next!=2){
            		return redirect(next);
            	}else{
            		shopDTO = new ShopDTO();
            	}
        	}else{
        		if(shopDTO.getNext()!=2){
        			return redirect(shopDTO.getNext());
        		}
        	}
        	mv.addObject("shopDTO",shopDTO);
        	List<Category> categorys = categoryServiceImpl.findAllParentCategory("");
        	mv.addObject("categorys", categorys);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.setViewName(basePath+"settled/check_in_2.btl");
        return mv;
    }
    
    /**
     *保存店铺详细信息
     */
    @RequestMapping(value = "/check_in_2_save")
    @ResponseBody
    public Map<String,Object> check_in_2_save(HttpSession session,ShopDTO shopDTO) {
        Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
        Map<String,Object> map = new HashMap<String,Object>();
        shopDTO.setUserId(Integer.valueOf(user.getuId()));
        shopDTO.setUserName(user.getuName());
        try {
        	int next = merchantssettledServiceImpl.findNext(user.getuId());
			if(next==2){
				merchantssettledServiceImpl.check_in_2_save(shopDTO);
	    	}
            map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);
            map.put(Const.ERROR_INFO, "保存错误");
        }

        return map;
    }
    
    /**
     * 查询分类
     * @param name
     * @return
     */
    @RequestMapping(value="findCategory")
    @ResponseBody
    public List<Category> findCategory(String name){
    	List<Category> categorys = new ArrayList<Category>();
		try {
			categorys = categoryServiceImpl.findAllParentCategory(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return categorys;
    }
    
	@RequestMapping(value="/check_in_3")
    public ModelAndView check_in_3(ModelAndView mv,HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		try {
			int next = merchantssettledServiceImpl.findNext(user.getuId());
			if(next!=3){
				return redirect(next);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        mv.setViewName(basePath+"settled/check_in_3.btl");
        return mv;
    }
    
	@RequestMapping(value="/check_in_4")
    public ModelAndView check_in_4(ModelAndView mv,HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
        try {
        	int next = merchantssettledServiceImpl.findNext(user.getuId());
        	if(next!=4){
        		return redirect(next);
        	}else{
        		List<ShopinfoPay> shopinfoPays = merchantssettledServiceImpl.findShopinfoPay(user.getuId()+"");
                if(shopinfoPays==null||shopinfoPays.size()==0){
                	List<ShopCategoryDTO> shopCategorys = merchantssettledServiceImpl.findShopCategory(user.getuId()+"");
                    if(shopCategorys!=null){
                    	mv.addObject("next",1);
                        mv.addObject("shopCategorys",shopCategorys);
                    }
                }else{
                	mv.addObject("next",2);
                	mv.addObject("shopinfoPays",shopinfoPays);
                }
        	}
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.setViewName(basePath+"settled/check_in_4.btl");
        return mv;
    }
	
	/**
	 * 新增订单
	 * @param session
	 * @return
	 */
	@RequestMapping(value="saveOrder")
	@ResponseBody
	public Map<String,Object> saveOrder(HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		try {
			merchantssettledServiceImpl.saveOrder(user,map);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);
            map.put(Const.ERROR_INFO, "保存错误");
		}
		return map;
	}
	
	/**
	 * 付款
	 * @param mv
	 * @param id
	 * @param method
	 * @return
	 */
	@RequestMapping(value="pay")
	public ModelAndView pay(ModelAndView mv,String id,String method){
		if(StringUtils.isEmpty(method)||StringUtils.isEmpty(id)){
			return new ModelAndView("500");
		}
		String payment_type = method;
		String payment_method = PaymentMethod.DEFAULT;
		String order_type = OrderType.SHOP;
		String order_id = id;
		String sign = MD5Util.hexSALT(payment_type+payment_method+order_type+order_id);
		// 需要访问的接口路径
		String payUrl= UrlUtil.getPayUrl();

		mv.addObject("payUrl",payUrl+"pay.html");
		mv.addObject("payment_type",payment_type);
		mv.addObject("payment_method",payment_method);
		mv.addObject("order_type",order_type);
		mv.addObject("order_id",order_id);
		mv.addObject("sign",sign);
		//mv.addObject("payment_type",payment_type);
		/*String url = ?payment_type="+payment_type
        			+"&payment_method="+payment_method
        			+"&order_type="+order_type
        			+"&order_id="+order_id
        			+"&sign="+sign;*/

		mv.setViewName(basePath+"settled/pay.btl");
		  return  mv;
	}
	
	@RequestMapping(value="check_in_4_save")
	@ResponseBody
	public Map<String,String> check_in_4_save(String id,HttpSession session){
		Map<String,String> map = new HashMap<String,String>();
		try {
			merchantssettledServiceImpl.updateNext(id, "5");
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);
            map.put(Const.ERROR_INFO, "保存错误");
		}
		
		return map;
	}
	
	@RequestMapping(value="check_in_5")
	@ResponseBody
	public ModelAndView check_in_5(ModelAndView mv,HttpSession session){
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		
		try {
			int next = merchantssettledServiceImpl.findNext(user.getuId());
			if(next!=5){
				return redirect(next);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mv.setViewName(basePath+"settled/check_in_5.btl");
		return mv;
	}
	
	/**
	 * 发送验证码
	 * @param phone
	 */
	@RequestMapping(value="sendSMS")
	@ResponseBody
	public Map<String,String> sendSMS(String phone,HttpSession session){
		Map<String,String> map = new HashMap<String,String>();
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		
		yzmServiceImpl.validateYzmTime(map, user.getuId(), phone);
		return map;
	}
	
	/**
	 * 验证验证码
	 * @param phone
	 */
	@RequestMapping(value="verifyYzm")
	@ResponseBody
	public Map<String,String> verifyYzm(String phone,String yzm,HttpSession session){
		Map<String,String> map = new HashMap<String,String>();
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		
		yzmServiceImpl.verifyYzm(map, user.getuId(), phone,yzm);
		return map;
	}
	
	/**
	 * 审核进度
	 * @param mv
	 * @param session
	 * @return
	 */
	@RequestMapping(value="progress")
	@ResponseBody
	public ModelAndView progress(ModelAndView mv,HttpSession session){
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		try {
			ProgressDTO progressDTO = merchantssettledServiceImpl.findProgress(user.getuId());
			List<ShopinfoLog> shopinfoLogs = merchantssettledServiceImpl.findShopInfoLog(user.getuId());
			
			if(progressDTO==null){
				progressDTO = new ProgressDTO();
				progressDTO.setNext(0);
			}
			
			mv.addObject("progressDTO", progressDTO);
			mv.addObject("shopinfoLogs", shopinfoLogs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mv.setViewName(basePath+"settled/application_progress.btl");
		return mv;
	}
	
}
