package com.shifeng.webapi.dto.homepage;

import java.util.List;

/**
 * 首页数据DTO
 * @author WinZhong
 *
 */
public class HomePageDataDTO {
	
	//首页banner图列表
	private List<BannerDTO> bannerList;
	//首页广告列表
	private List<AdDTO> adList;
	
	/**
	 * 首页banner图列表
	 * @return
	 */
	public List<BannerDTO> getBannerList() {
		return bannerList;
	}
	/**
	 * 首页banner图列表
	 * @param bannerList
	 */
	public void setBannerList(List<BannerDTO> bannerList) {
		this.bannerList = bannerList;
	}
	/**
	 * 首页广告列表
	 * @return
	 */
	public List<AdDTO> getAdList() {
		return adList;
	}
	/**
	 * 首页广告列表
	 * @param adsList
	 */
	public void setAdList(List<AdDTO> adList) {
		this.adList = adList;
	}
	
	

}
