package com.shifeng.provide.solr.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.plugin.page.Page;
import com.shifeng.provide.entity.solr.SolrProductDTO;
import com.shifeng.provide.entity.solr.SolrProductRulesDTO;
import com.shifeng.provide.entity.solr.SolrProductSkuDTO;
import com.shifeng.provide.solr.SolrService;
import com.shifeng.solr.MyHttpSolrClient;

/**
 * Solr搜索服务
 * @author Win
 *
 */
@Service("solrService")
public class SolrServiceImpl implements SolrService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

    @Resource(name = "productSolrClient")
    private MyHttpSolrClient productSolrClient;
	
	/**
	 * 数据全量导入
	 */
	public void dataFullImport() {
		long startTime = System.currentTimeMillis();    //获取开始时间
			Page page = new Page();
			page.setPageSize(200);
			dataFullImportSku(page);
	       if(page.getTotalPage()>1){
				//总页数
				int totalPage = page.getTotalPage();
				for(int i = 2;i<=totalPage;i++){
					page.setCurrentPage(i);
					dataFullImportSku(page);
				}
			 
			} 
	 
		 long endTime = System.currentTimeMillis();    //获取结束时间

		 System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
	}
	
	private void dataFullImportSku(Page page){
		try {
			List<SolrProductSkuDTO> skuList = (List<SolrProductSkuDTO>)dao.findForList("solrProductMapper.getProductSkuPage",page);
			System.out.println(page.getCurrentPage()+"==="+skuList);
			
			if(skuList != null){
				Collection<SolrInputDocument> docList = new ArrayList<SolrInputDocument>();
				for(SolrProductSkuDTO sku:skuList){
					// 创建doc文档
			        SolrInputDocument doc = new SolrInputDocument();
		             //sku
			        doc.addField("id",sku.getSku());
			        //商品编号
			        doc.addField("pid",sku.getPid());
			        //库存
			        doc.addField("stocks",sku.getStocks());
			        //重量
			        //doc.addField("weight",sku.getweight);
			        //进货价
			        /*doc.addField("costprice",sku.getcostprice);*/
			        //市场价
			        doc.addField("marketprice",sku.getMarketprice());
			        //世峰价
			        doc.addField("price",sku.getPrice());
			        //商品货号
			        //doc.addField("number",sku.getnumber);
			        //最后修改时间
			        doc.addField("lasttime",sku.getLasttime());
			        //颜色
			        doc.addField("colorid",sku.getColorid());
			        //规格
			        doc.addField("specid",sku.getSpecid());
			        //开始时间
			        doc.addField("starttime",sku.getStarttime());
			        //结束时间
			        doc.addField("endtime",sku.getEndtime());
			        //活动类型
			        doc.addField("activitytype",sku.getActivitytype());
			        //活动价
			        doc.addField("activityprice",sku.getActivityprice());
			        //活动数量
			        doc.addField("activitystocks",sku.getActivitystocks());
			        
				  	  SolrProductRulesDTO rules = sku.getRules();
				  	  SolrProductDTO product = sku.getProduct();
				  	  
			        //颜色名称
			        doc.addField("colorName",rules.getColorName());
			        //规格名称
			        doc.addField("specName",rules.getSpecName());
		     		  //颜色主图
			        doc.addField("colorPic",rules.getColorPic());
			        //店铺编号
			        doc.addField("shopid",product.getShopid());
		              //店铺名称
			        doc.addField("shopName",product.getShopName());
		              //店铺logo
			        doc.addField("shopLogo",product.getShopLogo());
			        //品牌编号
			        doc.addField("brandid",product.getBrandid());
			        //父分类属性编号
			        doc.addField("pcid",product.getPcid());
			        //分类属性编号
			        doc.addField("cid",product.getCid());
			        //商品名称
			        doc.addField("pName",product.getpName());
			        //商品状态(1在售2下架3删除)
			        doc.addField("state",product.getState());
			        //售后服务
			        doc.addField("after_service",product.getAfter_service());
			        //副标题
			        doc.addField("goods_subtitle",product.getGoods_subtitle());
			        //商品主图
			        doc.addField("logo",product.getLogo());
			        //是否支持7天退换货
			        doc.addField("is_seven_return",product.getIs_seven_return());
			        //关键字
			        doc.addField("keywords",product.getKeywords());
			        //发货地ID
			        doc.addField("originId",product.getOriginId());
			        //发货地名称
			        doc.addField("originName",product.getOriginName()); 
			        // 属性值ID
			        doc.addField("propertyValueId",sku.getProperty());
		            
		            
					docList.add(doc);
				}
				
			 	HttpSolrClient httpSolrClient  = productSolrClient.getHttpSolrClient();
			 	//httpSolrClient.deleteByQuery("*:*");
	            // 添加doc文档
	            UpdateResponse response = null;
				try {
					response = httpSolrClient.add(docList.iterator());
				} catch (Exception e) {
					e.printStackTrace();
				}
				
	            //对索引进行优化
				//httpSolrClient.optimize();
	            //提交
	            httpSolrClient.commit();
	            //输出统计信息
	            System.out.println("Query Time："+ response.getQTime());
	            System.out.println("Elapsed Time："+ response.getElapsedTime());
	            System.out.println("Status："+ response.getStatus());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/**
	 * 数据增量导入
	 */
	public void dataDeltaImport() {
		
	}
	
	

}
