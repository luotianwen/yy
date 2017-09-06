package com.shifeng.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author WinZhong
 *
 */
public class DateUtil {
	static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Calendar canlendar = Calendar.getInstance(); // java.util包
	     canlendar.setTime(new Date());
	     // 3小时以后  
	     canlendar.add(Calendar.HOUR_OF_DAY, 3);  
	     // 格式化显示  
	     String str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS")).format(canlendar.getTime());  
	     System.out.println(str);  
	}
	
	/**
	 * 获取日期几小时后的时间
	 * @param date
	 * @param hour
	 * @return
	 */
	 public static Date getAfterHour(Date date,int hour) {
		 Calendar canlendar = Calendar.getInstance();
		 //设置日期
	     canlendar.setTime(date);
	     //几小时以后  
	     canlendar.add(Calendar.HOUR_OF_DAY, hour);  
	     return canlendar.getTime();
	 }
	// 获得本周一
	public static String  getTimesWeekmorning() {
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return sdf.format(cal.getTime());
	}
	// 获得当天近几天时间
	public static String getbeforeday(int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(System.currentTimeMillis()-3600*24*1000*day);
		return sdf.format(cal.getTime());
	}

}
