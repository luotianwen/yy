package com.shifeng.mall.product.controller;

import com.alibaba.druid.util.StringUtils;
import com.shifeng.dto.mall.MallUserAddressDTO;
import com.shifeng.dto.mall.freight.MallShopWareFreight;
import com.shifeng.dto.mall.order.OrderWareDTO;
import com.shifeng.entity.ip.IpPosition;
import com.shifeng.entity.search.SkuInfo;
import com.shifeng.entity.search.WareSkuInfo;
import com.shifeng.mall.controller.BaseController;
import com.shifeng.mall.entity.user.Users;
import com.shifeng.mall.product.dto.ColorDTO;
import com.shifeng.mall.product.dto.SpecDTO;
import com.shifeng.mall.search.service.SearchService;
import com.shifeng.provide.mall.service.MallFreightService;
import com.shifeng.provide.system.service.SystemService;
import com.shifeng.provide.usercenter.service.BuyAddressService;
import com.shifeng.response.ReqResponse;
import com.shifeng.util.Const;
import com.shifeng.util.IPUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by yongshi on 2017/4/11.
 */
@Controller
public class DetailController extends BaseController  {
    @Resource(name="systemService")
    private SystemService systemServiceImpl;
    @Resource(name = "searchServiceImpl")
    protected SearchService searchService;
    //运费服务
    @Resource(name = "mallFreightService")
    private MallFreightService mallFreightService;
    //收货地址
    @Resource(name = "buyAddressService")
    protected BuyAddressService buyAddressService;
    /**
     *运费
     */
    @RequestMapping( value = "/detailWareFreights",method = RequestMethod.POST)
    @ResponseBody
    public double detailWareFreights(String sku ,String cityId,Integer pcount) throws Exception {
       return detailWareFreightsInfo(sku,cityId,pcount);
    }
    private double detailWareFreightsInfo(String sku ,String cityId,Integer pcount){
        //商品信息
        List<OrderWareDTO> orderPreloadings=new ArrayList<OrderWareDTO>();
        OrderWareDTO orderPreloading=new OrderWareDTO();
        orderPreloading.setSku(sku);
        orderPreloading.setPcount(pcount);
        orderPreloadings.add(orderPreloading);
        //订单预览信息
        ReqResponse<List<MallShopWareFreight>> result =mallFreightService.getWareFreights(orderPreloadings,cityId);
        return  result.getData().get(0).getFreight();
    }
    @RequestMapping(value = "detail/{sku}")
    public ModelAndView detail(ModelAndView mv, HttpSession session, HttpServletRequest request, @PathVariable String sku)throws Exception {
         //sku信息
        WareSkuInfo wareSkuInfo = searchService.getWareSkuInfo(sku);
        if(wareSkuInfo!=null&&wareSkuInfo.getState()==1)
        {
            mv.addObject("detail", wareSkuInfo);
            handle(mv,wareSkuInfo);
            mv.addObject("provinces", systemServiceImpl.getAllProvince());
            detailFreight(session,request, mv,sku);
            mv.addObject("provinces", systemServiceImpl.getAllProvince());
            mv.setViewName(basePath + "detail/sku.btl");
        }
        else{
            mv.setViewName(basePath + "sku404.btl");
        }


        return mv;
    }
    //运费
   private void  detailFreight(HttpSession session, HttpServletRequest request,ModelAndView mv,String sku){
       String province="",provinceName="";
       //登录用户地址
       Users user = (Users)session.getAttribute(Const.MALL_SESSION_USER);
       if(null!=user) {
           ReqResponse<MallUserAddressDTO> add = buyAddressService.getDefaultAddress(user.getuId());
           if(add.getCode()==0) {
               if(add.getData()!=null){
                   provinceName=add.getData().getProvinceName();
                   province=add.getData().getProvince()+"";
               }
           }
       }else{
           //未登录用户
           IpPosition p= IPUtil.getIp(request);
           if(p!=null){
        	   province=p.getRegion_id();
               provinceName=p.getRegion();
           }
       }
       double f=detailWareFreightsInfo(sku,province,1);
       mv.addObject("provinceName",provinceName);
       if(f==0d){
           mv.addObject("freight","免运费");
       }
       else {
           mv.addObject("freight", f);
       }
   }


    private void handle(ModelAndView mv,WareSkuInfo wareSkuInfo){
            List<SkuInfo> skuInfos=searchService.getSkuInfo(wareSkuInfo.getPid()+"");
            List<SpecDTO> specs = new ArrayList<SpecDTO>();
            List<ColorDTO> colors = new ArrayList<ColorDTO>();
            
            Map<Integer,String> cmap = new HashMap<Integer,String>();
            
            for (SkuInfo skuInfo:skuInfos ) {
                if(null!=skuInfo.getColorid()&&StringUtils.isEmpty(cmap.get(skuInfo.getColorid()))){
                	ColorDTO cd = new ColorDTO();
                    cd.setId(skuInfo.getSku());
                    cd.setName(skuInfo.getColorName());
                    cd.setImg(skuInfo.getColorPic());
                    if (null == skuInfo.getStocks() || 0 == skuInfo.getStocks()) {
                        cd.setStatus(0);
                    } else {
                        cd.setStatus(1);
                    }
                    
                    if(skuInfo.getColorid().equals(wareSkuInfo.getColorid())){
                    	cd.setCheck(1);
                    }
                    
                    colors.add(cd);
                    
                    cmap.put(skuInfo.getColorid(), skuInfo.getColorName());
                }
                
                if(null!=skuInfo.getColorid()&& skuInfo.getColorid().equals(wareSkuInfo.getColorid())){
                	SpecDTO sd = new SpecDTO();
                    sd.setId(skuInfo.getSku());
                    sd.setName(skuInfo.getSpecName());
                    if (null == skuInfo.getStocks() || 0 == skuInfo.getStocks()) {
                        sd.setStatus(0);
                    } else {
                        sd.setStatus(1);
                    }

                    if(null!=skuInfo.getSpecid()&&skuInfo.getSpecid().equals(wareSkuInfo.getSpecid())){
                    	sd.setCheck(1);
                    }
                    if(null!=skuInfo.getSpecid()) {
                        specs.add(sd);
                    }
                }
                
            }
            Collections.sort(colors, new Comparator<ColorDTO>() {
                        @Override
                        public int compare(ColorDTO colorDTO, ColorDTO t1) {
                            return Integer.parseInt(colorDTO.getId())>(Integer.parseInt(t1.getId()))?1:-1;
                        }
                    }
            );
            Collections.sort(specs, new Comparator<SpecDTO>() {
                        @Override
                        public int compare(SpecDTO colorDTO, SpecDTO t1) {
                            return Integer.parseInt(colorDTO.getId())>(Integer.parseInt(t1.getId()))?1:-1;
                        }
                    }
            );
            mv.addObject("specs", specs);
            mv.addObject("colors", colors);
            mv.addObject("skuInfos", skuInfos);
    }
}
