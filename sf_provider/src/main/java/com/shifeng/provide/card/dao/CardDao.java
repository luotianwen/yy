package com.shifeng.provide.card.dao;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.card.Card;
import com.shifeng.entity.card.UserCard;
import com.shifeng.response.ReqResponse;
import com.shifeng.util.Const;
import com.shifeng.util.DateUtil;
import com.shifeng.util.GenerateCode;

@Service("cardDao")
public class CardDao {
	@Resource(name = "baseDaoImpl")
    private BaseDao dao;
	
	/**
	 * 银币兑换E卡
	 * @param userId
	 * @param money
	 * @param req
	 * @throws Exception
	 */
	public void silverCoinExchangeECard(String userId,double money,ReqResponse<String> req) throws Exception{
		UserCard usercard = (UserCard)dao.findForObject("usercardMapper.findUsercardByUserId", userId);
		
		Card card = new Card();
		if(usercard!=null){
			//用户已绑定e卡则修改e卡信息
			card.setNumber(usercard.getCardnumber());
			card.setSdate(DateUtil.getYYYY_MM_DD());
			card.setEdate(DateUtil.getYearAfter(new Date(), 3));
			card.setMoney(money+usercard.getMoney());
			
			//分销提现修改用户e卡
			dao.update("usercardMapper.updatefxCard", card);
		}else{
			//用户未绑定e卡则新增e卡
			card.setUserid(userId);
			card.setSdate(DateUtil.getYYYY_MM_DD());
			card.setEdate(DateUtil.getYearAfter(new Date(), 3));
			card.setStatus(2);
			card.setMoney(money);
			card.setCount(1);
			card.setRemark("分销用户提现");
			
			saveCard(card);
			
			//用户绑定当前新增e卡
			dao.save("usercardMapper.savebindUser",card);
		}
		DecimalFormat df = new DecimalFormat("######0.00");
		req.setCode(0);
        req.setMsg("卡号："+card.getNumber()+"，余额："+df.format(card.getMoney()));
	}
	
	/**
	 * 新增世峰e卡
	 * @param dto
	 * @throws Exception
	 */
	public void saveCard(Card card) throws Exception{
		List<Card> list = new ArrayList<Card>();
		if(Const.CARDBATCH==0){
			Const.CARDBATCH = findMaxBatch();
		}
		Const.CARDBATCH++;
		String cardnumber = "";
		for(int i=0,len=card.getCount();i<len;i++){
			Card newCard = new Card();
			
			String number = i+1+Const.CARDBATCH*1000+"";
			while(number.length()<8)
				number = "0"+number;
			
			cardnumber = number;
			newCard.setNumber(number);
			newCard.setBatch(Const.CARDBATCH);
			newCard.setRemark(card.getRemark());
			newCard.setPassword(GenerateCode.genCodes(8));
			newCard.setSdate(card.getSdate());
			newCard.setEdate(card.getEdate()+" 23:59:59");
			newCard.setMoney(card.getMoney());
			newCard.setUserid(card.getUserid());
			
			list.add(newCard);
			
			if(list.size()>=100){
				dao.save("cardMapper.saveCard", list);
				list.clear();
			}
		}
		
		if(list.size()>0){
			dao.save("cardMapper.saveCard", list);
		}
		
		if(card.getCount()==1){
			card.setNumber(cardnumber);
		}
	}
	
	/**
	 * 获取当前最大批次号
	 */
	public int findMaxBatch() throws Exception{
		String number = (String)dao.findForObject("cardMapper.findMaxBatch");
		if(StringUtils.isEmpty(number)){
			return 0;
		}else{
			return Integer.valueOf(number);
		}
	}
	
}
