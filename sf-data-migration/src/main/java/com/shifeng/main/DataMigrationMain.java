package com.shifeng.main;

import java.util.List;
import java.util.Objects;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;

import com.shifeng.entity.ProductImgs;
import com.shifeng.plugin.page.Page;
import com.shifeng.service.mall.WareService;
import com.shifeng.service.oldmall.OldProductService;

public class DataMigrationMain {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext.xml");
        context.start();
        System.out.println("================开始运行数据迁移程序================");
		System.out.println("      .::::.");
		System.out.println("    .::::::::.");
		System.out.println("   :::::::::::");
		System.out.println("..:::::::::::'");
		System.out.println("'::::::::::::'");
		System.out.println(".::::::::::");
		System.out.println("'::::::::::::::..");
		System.out.println("..::::::::::::.");
		System.out.println("``::::::::::::::::");
		System.out.println("::::``:::::::::'        .:::.");
		System.out.println("::::'   ':::::'       .::::::::.");
		System.out.println(".::::'      ::::     .:::::::'::::.");
		System.out.println(".:::'       :::::  .:::::::::' ':::::.");
		System.out.println(".::'        :::::.:::::::::'      ':::::.");
		System.out.println(".::'         ::::::::::::::'         ``::::.");
		System.out.println("...:::           ::::::::::::'              ``::.");
		System.out.println("```` ':.          ':::::::::'                  ::::..");
		System.out.println("      '.:::::'                    ':'````..");
		
		/**************导入品牌数据**************/ 
        
		/*
		
		System.out.println("================开始迁移品牌数据================");
		OldBrandService oldBrandService = (OldBrandService)context.getBean("oldBrandService");
		BrandService brandService = (BrandService)context.getBean("brandService");
		try {
			List<Brand> brandList = oldBrandService.getBrands();
			System.out.println(brandList.get(0));
			brandService.saveBrands(brandList);
			System.out.println("================品牌数据迁移完成================");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		*/
		
		/**************导入商品数据**************/ 
       /* System.out.println("================开始迁移商品数据================");
		OldProductService oldProductService = (OldProductService)context.getBean("oldProductServiceImpl");
		try {
			Page page = new Page();
			List<OldProduct> productList = oldProductService.getProduct(page);
			System.out.println(page);
			System.out.println(productList);

			System.out.println("================商品数据迁移完成================");
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/**************导入商品数据**************/ 
        System.out.println("================开始迁移商品图片数据================");
		OldProductService oldProductService = (OldProductService)context.getBean("oldProductServiceImpl");
		WareService wareService = (WareService)context.getBean("wareService");
		try {
			Page page = new Page();
			updateMainPic(oldProductService, wareService, page);
			if(page.getTotalPage()>1){
				//总页数
				int totalPage = page.getTotalPage();
				for(int i = 2;i<=totalPage;i++){
					page.setCurrentPage(i);
					updateMainPic(oldProductService, wareService, page);
				}
			 
			} 

			System.out.println("================商品图片数据迁移完成================");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		

	}
	
	public static void updateMainPic(OldProductService oldProductService,WareService wareService,Page page){
		List<ProductImgs> productList = oldProductService.getProductImages(page);
		System.out.println(page.getCurrentPage());
		for(ProductImgs img:productList){
			System.out.println(img.getiColor());
			System.out.println(img.getiPath());
			String[] colors = img.getiColor().split("\\|");
			String[] paths = img.getiPath().split("\\|");
			for(int i = 0;i<colors.length;i++){
				if(!Objects.equals("-1", colors[i])){
					try {
						String pid = img.getPid();
						String colorName = colors[i];
						String imgPath = "http://seebong-hangzhou.oss-cn-hangzhou.aliyuncs.com/"+paths[i];
						System.out.println(pid);
						System.out.println(colorName);
						System.out.println(imgPath);
						wareService.updateMainPic(pid, colorName, imgPath);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	

}
