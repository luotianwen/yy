package com.shifeng.provide.product.dao;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import org.apache.log4j.Logger;

/** 
 * 商品图片表(p_images) DAO
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-17 13:40:55 
 */  
@Service("imagesDao")
public class ImagesDao{

	protected Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
}
