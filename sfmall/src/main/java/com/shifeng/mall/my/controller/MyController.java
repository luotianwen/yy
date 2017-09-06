package com.shifeng.mall.my.controller;

import com.alibaba.druid.util.StringUtils;
import com.shifeng.common.OrderType;
import com.shifeng.common.PaymentMethod;
import com.shifeng.common.PaymentType;
import com.shifeng.dto.express.ExpressTraceDTO;
import com.shifeng.dto.fx.FxTotalDTO;
import com.shifeng.dto.fx.FxUserDTO;
import com.shifeng.dto.fx.FxUserMoneyDTO;
import com.shifeng.dto.mall.MallCartShopDTO;
import com.shifeng.dto.mall.MallFeedbackDTO;
import com.shifeng.dto.mall.MallUserAddressDTO;
import com.shifeng.dto.mall.MallUserInvoiceDTO;
import com.shifeng.dto.mall.comments.OrderShopCommentDTO;
import com.shifeng.dto.mall.comments.OrderWareCommentDTO;
import com.shifeng.dto.mall.freight.MallShopWareFreight;
import com.shifeng.dto.mall.order.*;
import com.shifeng.entity.search.WareSkuInfo;
import com.shifeng.entity.user.SysUser;
import com.shifeng.mall.controller.BaseController;
import com.shifeng.mall.entity.user.Users;
import com.shifeng.mall.search.service.SearchService;
import com.shifeng.mall.service.YzmService;
import com.shifeng.mall.util.UrlUtil;
import com.shifeng.plugin.page.Page;
import com.shifeng.provide.distributor.service.DistributorService;
import com.shifeng.provide.express.ExpressService;
import com.shifeng.provide.mall.service.*;
import com.shifeng.provide.system.service.SystemService;
import com.shifeng.provide.sysuser.service.SysUserService;
import com.shifeng.provide.usercenter.service.BuyAddressService;
import com.shifeng.response.ReqResponse;
import com.shifeng.util.Const;
import com.shifeng.util.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by yongshi on 2017/4/18.
 */
@Controller
@RequestMapping("/my")
public class MyController extends BaseController {
	// 购物车服务
	@Resource(name = "mallCartService")
	private MallCartService mallCartService;
	// 关注商品
	@Resource(name = "mallFollowWareService")
	protected MallFollowWareService mallFollowWareService;
	// 关注店铺
	@Resource(name = "mallFollowVenderService")
	protected MallFollowVenderService mallFollowVenderService;
	// 收货地址
	@Resource(name = "buyAddressService")
	protected BuyAddressService buyAddressService;
	// 系统服务
	@Resource(name = "systemService")
	private SystemService systemServiceImpl;
	// 订单服务
	@Resource(name = "mallOrderService")
	private MallOrderService mallOrderService;
	// 运费服务
	@Resource(name = "mallFreightService")
	private MallFreightService mallFreightService;
	// 发票服务
	@Resource(name = "mallUserInvoiceService")
	private MallUserInvoiceService mallUserInvoiceService;
	// 快递查询
	@Resource(name = "expressService")
	private ExpressService expressService;
	// 用户信息
	@Resource(name = "sysUserService")
	private SysUserService sysUserService;
	// 验证码
	@Resource(name = "yzmServiceImpl")
	private YzmService yzmServiceImpl;
	// 搜索
	@Resource(name = "searchServiceImpl")
	protected SearchService searchService;
	// 意见反馈
	@Resource(name = "mallFeedbackService")
	protected MallFeedbackService mallFeedbackService;
	// 分销
	@Resource(name = "distributorService")
	protected DistributorService distributorService;
	@Resource(name = "mallFxService")
	protected MallFxService mallFxService;
	
	
	/**
	 * 加入购物车
	 * 
	 * @param mv
	 * @param sku
	 * @param pcount
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/joincart")
	public ModelAndView joincart(ModelAndView mv, String sku, int pcount, HttpSession session) throws Exception {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		ReqResponse r = mallCartService.addCartWare(user.getuId(), sku, pcount);
		WareSkuInfo wareSkuInfo = searchService.getWareSkuInfo(sku);
		mv.addObject("detail", wareSkuInfo);
		mv.addObject("pcount", pcount);
		mv.setViewName(basePath + "my/joincart.btl");
		return mv;
	}

	/**
	 * 修改购物车商品数量
	 * 
	 * @param mv
	 * @param sku
	 * @param pcount
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/updatecart")
	@ResponseBody
	public ReqResponse updatecart(ModelAndView mv, String sku, int pcount, HttpSession session) throws Exception {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		ReqResponse r = mallCartService.updateCartWare(user.getuId(), sku, pcount);
		return r;
	}

	/**
	 * 购物车列表
	 * 
	 * @param mv
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/cart")
	@ResponseBody
	public ModelAndView cart(ModelAndView mv, HttpSession session) throws Exception {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		ReqResponse<List<MallCartShopDTO>> r = mallCartService.getCartWareList(user.getuId());

		mv.addObject("carts", r.getData());
		mv.setViewName(basePath + "my/cart.btl");
		return mv;
	}

	/**
	 * 购物车下单页面列表
	 * 
	 * @param mv
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/cartorder", method = RequestMethod.POST)
	public ModelAndView cartorder(ModelAndView mv, HttpSession session, String[] skucheck, int[] goodsNumberInput,
			String[] cart) throws Exception {
		if (skucheck == null || skucheck.length == 0 || goodsNumberInput == null || goodsNumberInput.length == 0) {
			mv.addObject("");
			mv.setViewName("500");
			return mv;
		}

		String skuchecks = "";
		for (String str : skucheck) {
			if (StringUtils.isEmpty(skuchecks)) {
				skuchecks += str;
			} else {
				skuchecks += "," + str;
			}
		}

		String goodsNumberInputs = "";
		for (int str : goodsNumberInput) {
			if (StringUtils.isEmpty(goodsNumberInputs)) {
				goodsNumberInputs += str;
			} else {
				goodsNumberInputs += "," + str;
			}
		}

		String carts = "";
		if (cart != null && cart.length > 0) {
			for (String str : cart) {
				if (StringUtils.isEmpty(carts)) {
					carts += str;
				} else {
					carts += "," + str;
				}
			}
		}

		mv.addObject("skuchecks", skuchecks);
		mv.addObject("goodsNumberInputs", goodsNumberInputs);
		mv.addObject("carts", carts);

		// 省份信息
		List provinces = systemServiceImpl.getAllProvince();
		mv.addObject("provinces", provinces);

		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);

		// 用户发票信息
		ReqResponse<List<MallUserInvoiceDTO>> invoices = mallUserInvoiceService.getInvoiceList(user.getuId());
		mv.addObject("invoices", invoices.getData());

		mv.setViewName(basePath + "my/cartorder.btl");
		return mv;
	}

	/**
	 * 购物车下单页面列表
	 * 
	 * @param mv
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/cartorderproduct", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView cartorderproduct(ModelAndView mv, HttpSession session, Integer addressid, String[] skucheck,
			Integer[] goodsNumberInput, Integer[] cart) throws Exception {
		if (skucheck == null || skucheck.length == 0 || goodsNumberInput == null || goodsNumberInput.length == 0) {
			mv.addObject("");
			mv.setViewName("500");
			return mv;
		}
		// session.setAttribute("skucheck","");
		// session.setAttribute("goodsNumberInput","");
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);

		// 商品信息
		List<OrderWareDTO> orderPreloadings = new ArrayList<OrderWareDTO>();
		for (int i = 0; i < skucheck.length; i++) {
			OrderWareDTO orderPreloading = new OrderWareDTO();
			if (skucheck != null && skucheck.length > i) {
				orderPreloading.setSku(skucheck[i]);
			}
			if (goodsNumberInput != null && goodsNumberInput.length > i) {
				orderPreloading.setPcount(goodsNumberInput[i]);
			}
			if (cart != null && cart.length > i) {
				orderPreloading.setCartId(cart[i]);
			}
			orderPreloadings.add(orderPreloading);
		}
		session.setAttribute("orderPreloadings", orderPreloadings);

		// 订单预览信息
		ReqResponse<List<OrderPreviewInfoDTO>> result = mallOrderService.getOrderPreviewInfo(orderPreloadings);

		if (result.getCode() == 0) {
			session.setAttribute("OrderPreviewInfodata", result.getData());
			mv.addObject("data", result.getData());
		}
		String provinceId = "";

		// 用户地址
		ReqResponse<MallUserAddressDTO> add = null;
		if (addressid == null) {
			add = buyAddressService.getDefaultAddress(user.getuId());
		} else {
			add = buyAddressService.getAddressById(user.getuId(), addressid);
		}
		if (add.getCode() == 0) {
			if (add.getData() != null) {
				provinceId = add.getData().getProvince() + "";
			}
		}

		// 店铺商品运费
		ReqResponse<List<MallShopWareFreight>> addr = mallFreightService.getWareFreights(orderPreloadings, provinceId);
		mv.addObject("freights", addr.getData());

		mv.setViewName(basePath + "my/cartorderproduct.btl");
		return mv;
	}

	/**
	 * 收货地址列表
	 */
	@RequestMapping(value = "/addressList")
	@ResponseBody
	public ModelAndView addressList(ModelAndView mv, MallUserAddressDTO mallUserAddressDTO, HttpSession session)
			throws Exception {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		ReqResponse<List<MallUserAddressDTO>> req = buyAddressService.getAddressList(user.getuId());
		if (req.getCode() == 0)
			mv.addObject("datas", req.getData());
		mv.setViewName(basePath + "my/cartshopaddress.btl");
		return mv;
	}

	/**
	 * 增加收货地址
	 */
	@RequestMapping(value = "/addaddress")
	@ResponseBody
	public ReqResponse<String> addaddress(MallUserAddressDTO mallUserAddressDTO, HttpSession session) throws Exception {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);

		ReqResponse<String> r = buyAddressService.getAddressCount(user.getuId());
		if (r.getCode() == 0) {
			mallUserAddressDTO.setUid(user.getuId());
			r = buyAddressService.addAddress(mallUserAddressDTO);
		}

		return r;
	}

	/**
	 * 收货地址管理
	 */
	@RequestMapping(value = "/address")
	@ResponseBody
	public ModelAndView address(ModelAndView mv, String id, HttpSession session) throws Exception {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);

		ReqResponse<List<MallUserAddressDTO>> req = buyAddressService.getAddressList(user.getuId());
		if (req.getCode() == 0) {
			mv.addObject("datas", req.getData());

			List provinces = systemServiceImpl.getAllProvince();
			mv.addObject("provinces", provinces);

			if (!StringUtils.isEmpty(id)) {
				ReqResponse<MallUserAddressDTO> dtoreq;
				try {
					dtoreq = buyAddressService.getAddressById(user.getuId(), Integer.valueOf(id));
					mv.addObject("dto", dtoreq.getData());
				} catch (Exception e) {
					MallUserAddressDTO dto = new MallUserAddressDTO();
					mv.addObject("dto", dto);
				}
			} else {
				MallUserAddressDTO dto = new MallUserAddressDTO();
				mv.addObject("dto", dto);
			}

			mv.setViewName(basePath + "my/address.btl");
		} else {
			mv.setViewName("500");
		}

		return mv;
	}

	/**
	 * 设置默认地址
	 * 
	 * @param id
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/setAddressAllDefaultById")
	@ResponseBody
	public Map<String, String> setAddressAllDefaultById(int id, HttpSession session) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		ReqResponse<String> req = buyAddressService.setAddressAllDefaultById(user.getuId(), id);
		if (req.getCode() == 0) {
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} else {
			map.put(Const.ERROR_INFO, req.getMsg());
		}
		return map;
	}

	/**
	 * 修改收货地址
	 * 
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateAddress")
	@ResponseBody
	public ReqResponse<String> updateAddress(MallUserAddressDTO address, HttpSession session) throws Exception {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		address.setUid(user.getuId());
		ReqResponse<String> req = buyAddressService.updateAddress(address);
		return req;
	}

	/**
	 * 删除收货地址
	 * 
	 * @param id
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteAddress")
	@ResponseBody
	public Map<String, String> deleteAddress(int id, HttpSession session) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		ReqResponse<String> req = buyAddressService.deleteAddress(user.getuId(), id);
		if (req.getCode() == 0) {
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} else {
			map.put(Const.ERROR_INFO, req.getMsg());
		}
		return map;
	}

	/**
	 * 下单
	 */
	@RequestMapping(value = "/joinorder")
	@ResponseBody
	public Map<String, Object> joinorder(HttpSession session, Integer addressId, Integer couponId, Integer eCardId,
			Integer invoiceId, Integer notPutInvoice, String[] remark) throws Exception {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		Map<String, Object> map = new HashMap<String, Object>();

		OrderSettlementDTO orderSettlementInfo = new OrderSettlementDTO();
		orderSettlementInfo.setAddressId(addressId);
		List<OrderPreviewInfoDTO> freights = (List<OrderPreviewInfoDTO>) session.getAttribute("OrderPreviewInfodata");
		List<OrderWareDTO> orderPreloadings = (List<OrderWareDTO>) session.getAttribute("orderPreloadings");

		if (freights == null) {
			map.put("code", 1);
			map.put("msg", "下单失败，请稍后再试！");
			return map;
		}
		List<OrderSettlementShopDTO> shops = new ArrayList<>();
		int i = 0;
		for (OrderPreviewInfoDTO opid : freights) {

			OrderSettlementShopDTO ossd = new OrderSettlementShopDTO();
			ossd.setInvoiceId(invoiceId);
			ossd.setShopid(opid.getShopid());
			ossd.setNotPutInvoice(notPutInvoice);
			// 订单备注
			if (remark != null && remark.length > i) {
				ossd.setRemark(remark[i]);
			}

			if (opid.getWareList() != null && opid.getWareList().size() > 0) {
				List<OrderWareDTO> wares = new ArrayList<>();
				for (OrderPreviewWareInfoDTO opwi : opid.getWareList()) {
					OrderWareDTO owd = new OrderWareDTO();
					owd.setSku(opwi.getSku());
					owd.setPcount(opwi.getNumber());

					if (orderPreloadings != null && orderPreloadings.size() > 0) {
						for (OrderWareDTO dto : orderPreloadings) {
							if (opwi.getSku().equals(dto.getSku())) {
								owd.setCartId(dto.getCartId());
							}
						}
					}

					wares.add(owd);
				}
				ossd.setWares(wares);
			}
			shops.add(ossd);
		}

		orderSettlementInfo.setShops(shops);

		ReqResponse<OrderPayConfirmDTO> result = mallOrderService.settlement(user.getuId(), orderSettlementInfo);

		if (result.getCode() == 0) {
			map.put("orderId", result.getData().getOrderId());
			map.put("time", new Date().getTime());
		}

		map.put("code", result.getCode());
		map.put("msg", result.getMsg());

		return map;
	}

	/**
	 * 跳转支付页面
	 */
	@RequestMapping(value = "goPay")
	@ResponseBody
	public ModelAndView goPay(ModelAndView mv, String orderId, String time, String type, HttpSession session) {
		if (StringUtils.isEmpty(orderId) || StringUtils.isEmpty(time)) {
			mv.setViewName("500");
			return mv;
		}
		mv.addObject("orderId", orderId);

		try {
			long count = new Date().getTime() - Long.valueOf(time);
			if (count > 0) {
				count = 24 * 3600 - count / 1000;
				if (count > 0) {
					mv.addObject("time", count);
				} else {
					mv.addObject("time", 0);
				}
			} else {
				mv.addObject("time", 0);
			}
		} catch (Exception e) {
			mv.setViewName("500");
			return mv;
		}
		mv.addObject("type", type);
		mv.setViewName(basePath + "my/ordersubmission.btl");
		return mv;
	}

	/**
	 * 下单 支付
	 */
	@RequestMapping(value = "/pay")
	@ResponseBody
	public ModelAndView pay(ModelAndView mv, String orderId, Integer method, String type) throws Exception {
		if (method == null || StringUtils.isEmpty(orderId)) {
			return new ModelAndView("500");
		}
		String payment_type = "";
		if (method == 1) {
			payment_type = PaymentType.WEIXINPAY;
		} else if (method == 2) {
			payment_type = PaymentType.ALIPAY;
		} else {
			payment_type = PaymentType.TENPAY;
		}

		String payment_method = PaymentMethod.DEFAULT;
		String order_type = OrderType.WARES;
		if ("2".equals(type)) {
			order_type = OrderType.WARE;
		}

		String order_id = orderId;
		String sign = MD5Util.hexSALT(payment_type + payment_method + order_type + order_id);
		// 需要访问的接口路径
		String payUrl = UrlUtil.getPayUrl();

		mv.addObject("payUrl", payUrl + "pay.html");
		mv.addObject("payment_type", payment_type);
		mv.addObject("payment_method", payment_method);
		mv.addObject("order_type", order_type);
		mv.addObject("order_id", order_id);
		mv.addObject("sign", sign);

		mv.setViewName(basePath + "my/pay.btl");
		return mv;
	}

	@RequestMapping(value = "buysuccess")
	@ResponseBody
	public ModelAndView buysuccess(ModelAndView mv, String orderId, String total_fee, String order_type, String token) {
		mv.setViewName("500");
		if (!StringUtils.isEmpty(orderId) && !StringUtils.isEmpty(total_fee) && !StringUtils.isEmpty(order_type)) {
			if (token.equals(MD5Util.hexSALT(orderId + total_fee + order_type))) {
				mv.setViewName(basePath + "my/buysucceeds.btl");
			}
		}

		return mv;
	}

	/**
	 * 收藏店铺
	 */
	@RequestMapping(value = "/joinbookmark")
	@ResponseBody
	public ReqResponse<String> joinbookmark(int shopid, HttpSession session) throws Exception {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		ReqResponse<String> r = mallFollowVenderService.addFollowVender(user.getuId(), shopid);
		return r;
	}

	/**
	 * 取消收藏店铺
	 */
	@RequestMapping(value = "/deleteFollowVender")
	@ResponseBody
	public ReqResponse<String> deleteFollowVender(String shopid, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		ReqResponse<String> r = mallFollowVenderService.deleteFollowVender(user.getuId(), shopid);
		return r;
	}

	/**
	 * 关注店铺列表
	 * 
	 * @param mv
	 * @param currentPage
	 *            当前页
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/shopcollect")
	@ResponseBody
	public ModelAndView shopcollect(ModelAndView mv, Integer currentPage, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);

		if (currentPage == null) {
			currentPage = 1;
		}
		ReqResponse<Page> req = mallFollowVenderService.getFollowVenderList(user.getuId(), currentPage);

		if (req.getCode() == 0) {
			mv.addObject("page", req.getData());
			mv.setViewName(basePath + "my/user/shopcollect.btl");
		} else {
			mv.setViewName("500");
		}

		return mv;
	}

	/**
	 * 用户是否已关注商品
	 */
	@RequestMapping(value = "/isFollowVender")
	@ResponseBody
	public ReqResponse<Boolean> isFollowVender(String shopid, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		ReqResponse<Boolean> r = mallFollowVenderService.isFollowVender(user.getuId(), Integer.valueOf(shopid));
		return r;
	}

	/**
	 * 收藏商品
	 */
	@RequestMapping(value = "/joinsku")
	@ResponseBody
	public ReqResponse<String> joinsku(int sku, HttpSession session) throws Exception {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		ReqResponse<String> r = mallFollowWareService.addFollowWare(user.getuId(), sku);
		return r;
	}

	/**
	 * 批量收藏商品
	 */
	@RequestMapping(value = "/joinskus")
	@ResponseBody
	public ReqResponse<String> joinskus(int sku[], HttpSession session) throws Exception {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		ReqResponse<String> r = mallFollowWareService.addFollowWare(user.getuId(), sku);
		return r;
	}

	/**
	 * 删除用户关注商品
	 */
	@RequestMapping(value = "/deleteFollowWare")
	@ResponseBody
	public ReqResponse<String> deleteFollowWare(String sku, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		ReqResponse<String> r = mallFollowWareService.deleteFollowWare(user.getuId(), sku);
		return r;
	}

	/**
	 * 用户是否已关注商品
	 */
	@RequestMapping(value = "/isFollowWare")
	@ResponseBody
	public ReqResponse<Boolean> isFollowWare(String sku, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		ReqResponse<Boolean> r = mallFollowWareService.isFollowWare(user.getuId(), Integer.valueOf(sku));
		return r;
	}

	/**
	 * 关注商品列表
	 * 
	 * @param mv
	 * @param currentPage
	 *            当前页
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/goodscollect")
	@ResponseBody
	public ModelAndView goodscollect(ModelAndView mv, Integer currentPage, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);

		if (currentPage == null) {
			currentPage = 1;
		}
		ReqResponse<Page> req = mallFollowWareService.getFollowWareList(user.getuId(), currentPage);

		if (req.getCode() == 0) {
			mv.addObject("page", req.getData());
			mv.setViewName(basePath + "my/user/goodscollect.btl");
		} else {
			mv.setViewName("500");
		}

		return mv;
	}

	/**
	 * 批量删除购物车
	 */
	@RequestMapping(value = "/deleteskus")
	@ResponseBody
	public ReqResponse<String> deleteskus(String skus, HttpSession session) throws Exception {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		ReqResponse<String> r = mallCartService.deleteCartWare(user.getuId(), skus);
		return r;
	}

	/**
	 * 修改发票
	 */
	@RequestMapping(value = "/updateInvoice")
	@ResponseBody
	public ReqResponse<String> updateInvoice(MallUserInvoiceDTO address, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		address.setUserId(user.getuId());
		ReqResponse<String> r = null;
		if (address.getId() != null && address.getId() > 0) {
			r = mallUserInvoiceService.updateInvoice(address);
		} else {
			r = mallUserInvoiceService.addInvoice(address);
		}
		return r;
	}

	/**
	 * 删除发票
	 */
	@RequestMapping(value = "/deleteInvoice")
	@ResponseBody
	public ReqResponse<String> deleteInvoice(Integer id, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		ReqResponse<String> r = mallUserInvoiceService.deleteInvoice(user.getuId(), id);
		return r;
	}

	/**
	 * 查询用户订单
	 * 
	 * @param mv
	 * @param currentPage
	 *            当前页
	 * @param status
	 *            订单状态（0：等待付款；1：等待发货；2：等待收货；3：交易成功；4：取消订单；5：交易关闭；6：退货；）【可为空】
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/order")
	public ModelAndView order(ModelAndView mv, Integer currentPage, Integer state, Integer commentm,
			HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);

		if (currentPage == null) {
			currentPage = 1;
		}
		if (state != null && (state < 0 || state > 3)) {
			state = null;
		}
		if (state != null && state == 3) {
			commentm = 2;
		}

		mv.addObject("state", state);

		ReqResponse<Page> req = mallOrderService.getOrderList(user.getuId(), "", state, commentm, currentPage);
		if (req.getCode() == 0) {
			mv.addObject("page", req.getData());
			mv.setViewName(basePath + "my/order/orderinfo.btl");
			return mv;
		} else {
			mv.setViewName("500");
			return mv;
		}
	}

	/**
	 * 订单详情
	 * 
	 * @param mv
	 * @param orderId
	 *            订单ID
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "getOrderInfo")
	@ResponseBody
	public ModelAndView getOrderInfo(ModelAndView mv, String orderId, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		ReqResponse<OrderInfoDTO> req = mallOrderService.getOrderInfo(user.getuId(), orderId);

		if (req.getCode() == 0) {
			if (req.getData() != null && !StringUtils.isEmpty(req.getData().getOrderId())) {
				ReqResponse<List<OrderInfoLogDTO>> logreq = mallOrderService
						.getOrderInfoLogs(req.getData().getOrderId());

				if (logreq.getData() != null) {
					mv.addObject("logs", logreq.getData());
				}
			}

			List<List<ExpressTraceDTO>> expressTracess = new ArrayList<List<ExpressTraceDTO>>();
			for (OrderExpressDTO express : req.getData().getExpress()) {
				ReqResponse<List<ExpressTraceDTO>> exreq = expressService.getExpressTrace(express.getExpressCode(),
						express.getExpressNumber());

				if (exreq.getCode() == 0) {
					expressTracess.add(exreq.getData());
				}
			}
			mv.addObject("expressTracess", expressTracess);

			mv.addObject("orderInfo", req.getData());
			mv.setViewName(basePath + "my/order/orderdetail.btl");
		} else {
			mv.setViewName("500");
		}

		return mv;
	}

	/**
	 * 取消订单
	 * 
	 * @param order_id
	 *            订单ID
	 * @param reason
	 *            取消原因
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "cancelOrder")
	@ResponseBody
	public ReqResponse<String> cancelOrder(String order_id, int reason, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);

		ReqResponse<String> req = mallOrderService.cancelOrder(user.getuId(), order_id, reason);
		return req;

	}

	/**
	 * 申请退款
	 * 
	 * @param order_id
	 *            订单ID
	 * @param reason
	 *            退款原因
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "orderRefund")
	@ResponseBody
	public ReqResponse<String> orderRefund(String order_id, int reason, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);

		ReqResponse<String> req = mallOrderService.orderRefund(user.getuId(), order_id, reason);
		return req;
	}

	/**
	 * 确认收货
	 * 
	 * @param order_id
	 *            订单ID
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "orderConfirm")
	@ResponseBody
	public ReqResponse<String> orderConfirm(String order_id, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);

		ReqResponse<String> req = mallOrderService.orderConfirm(user.getuId(), order_id);
		return req;
	}

	/**
	 * 跳转订单评论页面
	 */
	@RequestMapping(value = "comment")
	@ResponseBody
	public ModelAndView comment(ModelAndView mv, String orderId, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);

		ReqResponse<OrderInfoDTO> req = mallOrderService.getOrderInfo(user.getuId(), orderId);
		if (req.getCode() == 0) {
			mv.addObject("orderInfo", req.getData());
			mv.setViewName(basePath + "my/order/comment.btl");
		} else {
			mv.setViewName("500");
		}

		return mv;
	}

	/**
	 * 订单评论
	 */
	@RequestMapping(value = "saveComment")
	@ResponseBody
	public ReqResponse<String> saveComment(OrderShopCommentDTO orderComment, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);

		orderComment.setUserId(user.getuId());
		orderComment.setReceiveName(user.getuName());

		if (orderComment.getWareComments() != null) {
			for (OrderWareCommentDTO dto : orderComment.getWareComments()) {
				dto.setOrderid(orderComment.getOrderid());
				dto.setShopid(orderComment.getShopid());
				dto.setUserId(orderComment.getUserId());
				dto.setReceiveName(orderComment.getReceiveName());
			}
		}

		ReqResponse<String> req = mallOrderService.commentOrder(orderComment);
		return req;
	}

	/**
	 * 跳转订单退款页面
	 */
	@RequestMapping(value = "refund")
	@ResponseBody
	public ModelAndView refund(ModelAndView mv, String orderId, String sku, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);

		mv.addObject("orderId", orderId);
		mv.addObject("sku", sku);
		mv.setViewName(basePath + "my/order/refund.btl");

		return mv;
	}

	/**
	 * 订单退换货
	 */
	@RequestMapping(value = "saveRefund")
	@ResponseBody
	public ReqResponse<String> saveRefund(ServiceApplyDTO serviceApply, HttpSession session) {
		ReqResponse<String> req = new ReqResponse<String>();

		if (StringUtils.isEmpty(serviceApply.getOrder_id()) || StringUtils.isEmpty(serviceApply.getWareId() + "")) {
			req.setCode(1);
			req.setMsg("【申请售后】异常");
		}

		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);

		serviceApply.setUserId(user.getuId());
		req = mallOrderService.serviceApply(serviceApply);
		return req;
	}

	/**
	 * 订单退款详情
	 */
	@RequestMapping(value = "refundDetail")
	@ResponseBody
	public ModelAndView refundDetail(ModelAndView mv, String orderId, String sku, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);

		mv.setViewName(basePath + "my/order/refundDetail.btl");
		return mv;
	}

	/**
	 * 我的世峰
	 */
	@RequestMapping(value = "/index")
	@ResponseBody
	public ModelAndView index(ModelAndView mv, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);

		mv.addObject("user", user);
		mv.setViewName(basePath + "my/user/index.btl");
		return mv;
	}

	/**
	 * 用户个人信息
	 */
	@RequestMapping(value = "/userInfo")
	@ResponseBody
	public ModelAndView userInfo(ModelAndView mv, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);

		try {
			List provinces = systemServiceImpl.getAllProvince();
			mv.addObject("provinces", provinces);
		} catch (Exception e) {
			e.printStackTrace();
		}

		mv.addObject("user", user);
		mv.setViewName(basePath + "my/user/userInfo.btl");
		return mv;
	}

	/**
	 * 修改用户个人信息
	 */
	@RequestMapping(value = "/updateUserInfo")
	@ResponseBody
	public ReqResponse<String> updateUserInfo(SysUser sysUser, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);

		sysUser.setId(Integer.valueOf(user.getuId()));
		ReqResponse<String> req = sysUserService.updateUserInfo(sysUser);
		if (req.getCode() == 0) {
			if (!StringUtils.isEmpty(sysUser.getPortrait()) && !sysUser.getPortrait().equals(user.getPortrait())) {
				req = sysUserService.updateHeadImg(user.getuId(), sysUser.getPortrait());
			}

			user.setAddress(sysUser.getAddress());
			user.setBirthday(sysUser.getBirthday());
			user.setCity(sysUser.getCity());
			user.setProvince(sysUser.getProvince());
			user.setRegion(sysUser.getRegion());
			user.setSex(sysUser.getSex());
			user.setuName(sysUser.getName());
			user.setPortrait(sysUser.getPortrait());

			session.setAttribute(Const.MALL_SESSION_USER, user);
		}

		return req;
	}

	/**
	 * 用户安全
	 */
	@RequestMapping(value = "/userSecurity")
	@ResponseBody
	public ModelAndView userSecurity(ModelAndView mv, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);

		mv.addObject("phone", user.getPhone().substring(0, 3) + "****" + user.getPhone().substring(7, 11));
		mv.setViewName(basePath + "my/user/userSecurity.btl");
		return mv;
	}

	/**
	 * 用户修改密码
	 */
	@RequestMapping(value = "/password")
	@ResponseBody
	public ModelAndView password(ModelAndView mv, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);

		mv.addObject("phone", user.getPhone().substring(0, 3) + "****" + user.getPhone().substring(7, 11));
		mv.setViewName(basePath + "my/user/changePassword.btl");
		return mv;
	}

	/**
	 * 修改密码发送手机验证码
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/updatePassYzm", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> updatePassYzm(HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);

		Map<String, String> map = new HashMap<String, String>();
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);

		yzmServiceImpl.postYzmTime(map, user.getPhone(), 3);
		return map;
	}

	/**
	 * 修改密码
	 * 
	 * @param yzm
	 * @param newPassword
	 *            用户新密码
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/updatePassword")
	@ResponseBody
	public ReqResponse<String> updatePassword(String yzm, String newPassword, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);

		boolean bool = yzmServiceImpl.postYzm(user.getPhone(), yzm, 3);

		ReqResponse<String> req = new ReqResponse<String>();
		if (bool) {
			req = sysUserService.updatePasswordByPhone(user.getPhone(), newPassword);
		} else {
			req.setCode(1);
			req.setMsg("验证码错误！");
		}
		return req;
	}

	/**
	 * 用户修改手机
	 */
	@RequestMapping(value = "/phone")
	@ResponseBody
	public ModelAndView phone(ModelAndView mv, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);

		mv.addObject("phone", user.getPhone().substring(0, 3) + "****" + user.getPhone().substring(7, 11));
		mv.setViewName(basePath + "my/user/changePhone.btl");
		return mv;
	}

	/**
	 * 修改手机号发送验证码
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/updatePhoneYzm", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> updatePhoneYzm(HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);

		Map<String, String> map = new HashMap<String, String>();
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);

		yzmServiceImpl.postYzmTime(map, user.getPhone(), 4);
		return map;
	}

	/**
	 * 验证旧手机验证码
	 */
	@RequestMapping(value = "verifyOldPhone")
	@ResponseBody
	public Map<String, String> verifyOldPhone(String yzm, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);

		Map<String, String> map = new HashMap<String, String>();
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);

		if (StringUtils.isEmpty(yzm)) {
			map.put(Const.ERROR_INFO, "请输入手机验证码!");
			return map;
		}

		boolean bool = yzmServiceImpl.postYzm(user.getPhone(), yzm, 4);
		if (!bool) {
			map.put(Const.ERROR_INFO, "手机验证码不正确!");
			return map;
		}
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		return map;
	}

	/**
	 * 修改手机号新手机号发送验证码
	 * 
	 * @param phone
	 *            新手机号
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/updateNewPhoneYzm", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> updateNewPhoneYzm(String phone, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		Map<String, String> map = new HashMap<String, String>();
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);

		if (yzmServiceImpl.check_oldphone(user.getPhone())) {
			yzmServiceImpl.postYzmTime(map, phone, 5);
			yzmServiceImpl.setPhone(user.getPhone(), phone);
		} else {
			map.put(Const.ERROR_INFO, "本次修改已失效，请刷新后重试");
		}

		return map;
	}

	/**
	 * 修改手机号
	 */
	@RequestMapping(value = "updatePhone")
	@ResponseBody
	public Map<String, String> updatePhone(String newPhone, String yzm, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		Map<String, String> map = new HashMap<String, String>();
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);

		boolean bool = yzmServiceImpl.verifyPhone(user.getPhone(), newPhone);
		if (bool) {
			bool = yzmServiceImpl.postYzm(newPhone, yzm, 5);
		} else {
			map.put(Const.ERROR_INFO, "该号码不是接受验证码的手机号!");
			return map;
		}

		if (bool) {
			ReqResponse<String> req = sysUserService.updatePhone(user.getPhone(), newPhone);
			if (req.getCode() == 0) {
				user.setPhone(newPhone);
				session.setAttribute(Const.MALL_SESSION_USER, user);
				map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
			} else {
				map.put(Const.ERROR_INFO, req.getMsg());
			}
		} else {
			map.put(Const.ERROR_INFO, "手机验证码不正确！");
		}

		return map;
	}

	/**
	 * 意见反馈
	 */
	@RequestMapping(value = "feedback")
	@ResponseBody
	public ModelAndView feedback(ModelAndView mv) {
		mv.setViewName(basePath + "my/feedback/feedback.btl");
		return mv;
	}

	/**
	 * 新增意见反馈
	 */
	@RequestMapping(value = "saveFeedback")
	@ResponseBody
	public ReqResponse<String> saveFeedback(MallFeedbackDTO mallFeedback, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);

		mallFeedback.setUser_id(user.getuId());
		mallFeedback.setSource(2);
		ReqResponse<String> req = mallFeedbackService.addFeedback(mallFeedback);

		return req;
	}
	
	/**
	 * 我的分销商
	 */
	@RequestMapping(value = "distributor")
	@ResponseBody
	public ModelAndView distributor(ModelAndView mv) {
		mv.setViewName(basePath + "my/distributor/distributor.btl");
		return mv;
	}
	
	/**
	 * 我的分销商列表
	 */
	@RequestMapping(value = "distributorList")
	@ResponseBody
	public ModelAndView distributorList(ModelAndView mv,String name,String phone,Integer currentPage, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		
		if(currentPage==null){
			currentPage = 1;
		}
		ReqResponse<Page> req = distributorService.getDistributorList(user.getuId(), name, phone, currentPage);

		mv.addObject("name", name);
		mv.addObject("page", req.getData());
		mv.setViewName(basePath + "my/distributor/distributorList.btl");
		return mv;
	}
	
	/**
	 * 我的分销订单
	 */
	@RequestMapping(value = "distributorOrder")
	@ResponseBody
	public ModelAndView distributorOrder(ModelAndView mv, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		ReqResponse<FxTotalDTO> req = mallFxService.getFxTotal(user.getuId());
		mv.addObject("data", req.getData());
		mv.setViewName(basePath + "my/distributor/distributorOrder.btl");
		return mv;
	}
	
	/**
	 * 我的分销订单列表
	 */
	@RequestMapping(value = "distributorOrderList")
	@ResponseBody
	public ModelAndView distributorOrderList(ModelAndView mv,String day,String userId,Integer currentPage, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		
		if(currentPage==null){
			currentPage = 1;
		}
		ReqResponse<Page> req = mallFxService.getMyFxOrderList(user.getuId(), day, userId, currentPage);

		mv.addObject("day", day);
		mv.addObject("userId", userId);
		mv.addObject("page", req.getData());
		mv.setViewName(basePath + "my/distributor/distributorOrderList.btl");
		return mv;
	}
	
	/**
	 * 分销提现页面
	 */
	@RequestMapping(value = "withdraw")
	@ResponseBody
	public ModelAndView withdraw(ModelAndView mv, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		
		ReqResponse<FxUserMoneyDTO> req = mallFxService.getMyFxCommission(user.getuId());

		mv.addObject("data", req.getData());
		mv.setViewName(basePath + "my/distributor/withdraw.btl");
		return mv;
	}
	
	/**
	 * 分销提现
	 */
	@RequestMapping(value = "exchange")
	@ResponseBody
	public ReqResponse<String> exchange(double money,int type, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		ReqResponse<String> req = mallFxService.exchange(user.getuId(), money, type);
		return req;
	}
	
	/**
	 * 跳转分销商编辑页
	 */
	@RequestMapping(value = "distributorEdit")
	@ResponseBody
	public ModelAndView distributorEdit(ModelAndView mv,String id, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		
		FxUserDTO data = new FxUserDTO();
		mv.addObject("data", data);
		if(!StringUtils.isEmpty(id)){
			ReqResponse<FxUserDTO> req = distributorService.getDistributorById(user.getuId(), id);
			if(req.getCode()==0){
				mv.addObject("data", req.getData());
			}
		}
		
		mv.setViewName(basePath + "my/distributor/distributorEdit.btl");
		return mv;
	}
	
	/**
	 * 新增分销商
	 */
	@RequestMapping(value = "saveDistributor")
	@ResponseBody
	public ReqResponse<String> saveDistributor(FxUserDTO dto, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		ReqResponse<String> req = distributorService.addDistributor(user.getuId(), dto.getName(), dto.getPhone(), dto.getRemark());
		return req;
	}
	
	/**
	 * 编辑分销商
	 */
	@RequestMapping(value = "updateDistributor")
	@ResponseBody
	public ReqResponse<String> updateDistributor(FxUserDTO dto, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		ReqResponse<String> req = distributorService.updateDistributor(user.getuId(), dto.getRecommended_userid(), dto.getName(), dto.getRemark());
		return req;
	}
	
	/**
	 * 删除分销商
	 */
	@RequestMapping(value = "deleteDistributor")
	@ResponseBody
	public ReqResponse<String> deleteDistributor(String id, HttpSession session) {
		Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
		ReqResponse<String> req = distributorService.deleteDistributor(user.getuId(), id);
		return req;
	}
	
	
	
}
