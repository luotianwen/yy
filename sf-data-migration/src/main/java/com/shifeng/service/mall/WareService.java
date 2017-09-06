package com.shifeng.service.mall;

public interface WareService {
	
	/**
	 * 更新商品主图
	 * @param pid
	 * @param colorName
	 * @param imgPath
	 */
	void updateMainPic(String pid,String colorName,String imgPath);

}
