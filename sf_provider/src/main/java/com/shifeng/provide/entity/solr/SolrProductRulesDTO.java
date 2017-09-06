package com.shifeng.provide.entity.solr;

public class SolrProductRulesDTO {
	
	//颜色名称
 	 private String colorName;
	//颜色主图
 	 private String colorPic;
	//规格名称
 	 private String specName;
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public String getColorPic() {
		return colorPic;
	}
	public void setColorPic(String colorPic) {
		this.colorPic = colorPic;
	}
	public String getSpecName() {
		return specName;
	}
	public void setSpecName(String specName) {
		this.specName = specName;
	}
	@Override
	public String toString() {
		return "SolrProductRulesDTO [colorName=" + colorName + ", colorPic=" + colorPic + ", specName=" + specName
				+ "]";
	}
  
 	 
 	 

}
