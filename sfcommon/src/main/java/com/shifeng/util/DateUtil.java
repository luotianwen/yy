package com.shifeng.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author WinZhong
 *
 */
public class DateUtil {
	

	private final static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");

	private final static SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");

	private final static SimpleDateFormat sdfMonth = new SimpleDateFormat("yyyy_MM");
	
	private final static SimpleDateFormat sdfDays = new SimpleDateFormat("yyyyMMdd");
	
	private final static SimpleDateFormat sdfTimes = new SimpleDateFormat("yyyyMMddHHmmss");

	public final static SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private final static SimpleDateFormat sdfE = new SimpleDateFormat("E");
	public static final SimpleDateFormat ymFormat = new SimpleDateFormat("yyyy_MM");

	public static void main(String[] args) {
		System.out.println(YYYY_MM_DDgetBeforDay(7));
		System.out.println(currentDayResidueTime());
		System.out.println(YYYY_MM_DDgetBeforDay(1));
		System.out.println("当天时间：" + sdfTime.format(getTimesnight()));
		System.out.println("当天0点时间：" + sdfTime.format(getTimesmorning()));
		System.out.println("昨天0点时间：" + sdfTime.format(getYesterdaymorning()));
		System.out.println("近7天时间：" + sdfTime.format(getWeekFromNow()));
		System.out.println("本周周一0点时间：" + sdfTime.format(getTimesWeekmorning()));
		System.out.println("本周周日时间：" + sdfTime.format(getTimesWeeknight()));
		System.out.println("本月初0点时间：" + sdfTime.format(getTimesMonthmorning()));
		System.out.println("本月未时间：" + sdfTime.format(getTimesMonthnight()));
		System.out.println("上月初0点时间：" + sdfTime.format(getLastMonthStartMorning()));
		System.out.println("本季度开始点时间：" + sdfTime.format(getCurrentQuarterStartTime()));
		System.out.println("本季度结束点时间：" + sdfTime.format(getCurrentQuarterEndTime()));
		
		System.out.println(daysBetween("2017-05-11 10:10:10","2017-05-15 00:00:00"));  
		
		System.out.println(DateUtil.sdfTime.format(DateUtil.beforeOrAfterNumberDay("2017-05-11 10:10:10", 60))); 
		 
		Date date_01 = new Date();
		Date date_02 = DateUtil.beforeOrAfterNumberDay(date_01, 7);
			       
        System.out.println(date_01.before(date_02)); //true，当 date_01 小于 date_02 时，为 true，否则为 false
        System.out.println(date_02.after(date_01)); //true，当 date_02 大于 date_01 时，为 true，否则为 false
        System.out.println(date_01.compareTo(date_02)); //-1，当 date_01 小于 date_02 时，为 -1
        System.out.println(date_02.compareTo(date_01)); //1，当 date_02 大于 date_01 时，为 1
        System.out.println(date_02.compareTo(date_02)); //0，当两个日期相等时，为 0
        
        System.out.println(YYYY_MM_DDgetAfterDay(60));  
        
	}
	
	 /**
    *  
    * 当前日期前(后)x天的日期 
    * @param date 当前日期 
    * @param day 天数（如果day数为负数,返回日期前的天数） 
    * @return Date 
    */  
   public static Date beforeOrAfterNumberDay(Date date, int day) {  
       Calendar c = Calendar.getInstance();  
       c.setTime(date);  
       c.add(Calendar.DAY_OF_YEAR, day);  
       return c.getTime();  
   }  
	
	 /**
   *  
   * 当前日期前(后)x天的日期 
   * @param date 当前日期 
   * @param day 天数（如果day数为负数,返回日期前的天数） 
   * @return Date 
   */  
  public static Date beforeOrAfterNumberDay(String date, int day) {
	  Date d;
	try {
		d = sdfTime.parse(date);
		return beforeOrAfterNumberDay(d, day);
	} catch (ParseException e) {
		e.printStackTrace();
	}
      return null;
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
	/**
	 * 获取月
	 * @param i
	 * @return
	 */
	public static String getYM(int i) {
		try {
			Calendar ca = Calendar.getInstance();
			ca.add(Calendar.DAY_OF_MONTH, -i);
			return ymFormat.format(ca.getTime());
		} catch (Exception e) {
		}
		return null;
	}
	/**
	 * 获取月
	 * @param time
	 * @return
	 */
	public static String getYM(Date time) {
		return ymFormat.format(time);
	}
	/**
	 * 获取月
	 * @param time
	 * @return
	 */
	public static String getYM(String time) {
		try {
			return ymFormat.format(sdfDay.parse(time));
		} catch (ParseException e) {
			e.printStackTrace();
			return ymFormat.format(new Date());
		}
	}
		/**
		 * 获取YYYY格式
		 * 
		 * @return
		 */
		public static String getYear() {
			return sdfYear.format(new Date());
		}


		/**
		 * 获取YYYY-MM-DD格式
		 * 
		 * @return
		 */
		public static String getYYYY_MM_DD() {
			return sdfDay.format(new Date());
		}

		/**
		 * 获取YYYY-MM-DD格式
		 * 
		 * @return
		 */
		public static String getYYYY_MM_DD(Date date) {
			return sdfDay.format(date);
		}
		
		/**
		 * 获取YYYYMMDD格式
		 * 
		 * @return
		 */
		public static String getDays(){
			return sdfDays.format(new Date());
		}

		/**
		 * 获取YYYY-MM-DD HH:mm:ss格式
		 * 
		 * @return
		 */
		public static String getTime() {
			return sdfTime.format(new Date());
		}

		/**
		 * 获取YYYYMMDDHHmmss格式
		 * 
		 * @return
		 */
		public static String getTimes() {
			return sdfTimes.format(new Date());
		}

		/**
		 * 获取YYYY-MM-DD HH:mm:ss格式
		 * 
		 * @return
		 */
		public static String getTime(Date date) {
			return sdfTime.format(date);
		}
		
		/**
		* @Title: compareDate
		* @Description: TODO(日期比较，如果s>=e 返回true 否则返回false)
		* @param s
		* @param e
		* @return boolean  
		* @throws
		 */
		public static boolean compareDate(String s, String e) {
			if(fomatDate(s)==null||fomatDate(e)==null){
				return false;
			}
			return fomatDate(s).getTime() >=fomatDate(e).getTime();
		}
		
		/**
		* @Title: compareDate
		* @Description: TODO(日期比较，如果s>=e 返回true 否则返回false)
		* @param s
		* @param e
		* @return boolean  
		* @throws
		 */
		public static boolean compareDate(Date s, String e) {
			if(s==null||fomatDate(e)==null){
				return false;
			}
			return s.getTime() >=fomatDate(e).getTime();
		}
		
		/**
		* @Title: compareDate
		* @Description: TODO(日期比较，如果s>=e 返回true 否则返回false)
		* @param e
		* @return boolean  
		* @throws
		 */
		public static boolean compareDate(String e) {
			Date date = fomatDate(e); 
		    // System.out.println(date);  
			if(date==null){
				return false;
			}
			long nowTime = new Date().getTime();
			long gq = date.getTime();
			/* // 格式化显示  
		     String str = sdfTime.format(gq);  
		     System.out.println(str);  
			System.out.println(nowTime+"========"+gq);*/
			return nowTime >= gq;
		}
	/**
	 * 判断选择的日期本月的第几天
	 *//*
	public int getWeeksByChooseDay(){
		return calSelected.get(Calendar.DAY_OF_MONTH);
	}*/
	/**
		 * 格式化日期
		 * 
		 * @return
		 */
		public static Date fomatDate(String date) {
			try {
				return sdfTime.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		}

		/**
		 * 格式化日期 YYYY_MM_DD
		 * 
		 * @return
		 */
		public static Date YYYY_MM_DDfomatDate(String date) {
			try {
				return sdfDay.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		}

		/**
		 * 校验日期是否合法
		 * 
		 * @return
		 */
		public static boolean isValidDate(String s) {
			DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
			try {
				fmt.parse(s);
				return true;
			} catch (Exception e) {
				// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
				return false;
			}
		}

		/**
		 * 校验日期是否合法  "yyyy-MM-dd HH:mm:ss"
		 * 
		 * @return
		 */
		public static boolean isValidDateYYYY_MM_DD_HH_MM_SS(String s) {
			DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				fmt.parse(s);
				return true;
			} catch (Exception e) {
				// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
				return false;
			}
		}
		public static int getDiffYear(String startTime,String endTime) {
			DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
			try {
				long aa=0;
				int years=(int) (((fmt.parse(endTime).getTime()-fmt.parse(startTime).getTime())/ (1000 * 60 * 60 * 24))/365);
				return years;
			} catch (Exception e) {
				// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
				return 0;
			}
		}
		  /**
	     * <li>功能描述：时间相减得到天数
	     * @param beginDateStr
	     * @param endDateStr
	     * @return
	     * long 
	     */
	    public static long getDaySub(String beginDateStr,String endDateStr){
	        long day=0;
	        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
	        java.util.Date beginDate = null;
	        java.util.Date endDate = null;
	        
	            try {
					beginDate = format.parse(beginDateStr);
					endDate= format.parse(endDateStr);
				} catch (ParseException e) {
					e.printStackTrace();
				}
	            day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000);
	            //System.out.println("相隔的天数="+day);
	      
	        return day;
	    }
		  /**
	     * <li>功能描述：两个日期中间间隔的天数（不包括这两天在内）
	     * @param beginDate
	     * @param endDate
	     * @return
	     * long 
	     */
	    public static long getDaySub(Date beginDate,Date endDate){
	        long day=0;
	        day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000);
	        return day;
	    }
	    
	    /**
	     * 得到n天之后的日期  yyyy-MM-dd HH:mm:ss
	     * @param days
	     * @return
	     */
	    public static String getAfterDayDate(String days) {
	    	int daysInt = Integer.parseInt(days);
	    	
	        Calendar canlendar = Calendar.getInstance(); // java.util包
	        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
	        Date date = canlendar.getTime();
	        
	        String dateStr = sdfTime.format(date);
	        
	        return dateStr;
	    }
	/**
	 * 得到n天之前的日期  yyyy-MM-dd
	 * @param daysInt
	 * @return
	 */
	public static String YYYY_MM_DDgetBeforDay(int daysInt) {
		Calendar canlendar = Calendar.getInstance(); // java.util包
		int day = canlendar.get(Calendar.DAY_OF_MONTH)-1;
		//canlendar.add(Calendar.DATE, day>Math.abs(daysInt)?daysInt*-1:day*-1); // 日期减 如果不够减会将变成当月天
		canlendar.add(Calendar.DATE,  daysInt*-1 ); // 日期减 如果不够减会将变成当月天
		Date date = canlendar.getTime();
		String dateStr = sdfDay.format(date);
		return dateStr;
	}
	/**
	     * 得到n天之后的日期  yyyy-MM-dd
	     * @param daysInt
	     * @return
	     */
	    public static String YYYY_MM_DDgetAfterDay(int daysInt) {
	        Calendar canlendar = Calendar.getInstance(); // java.util包
			int day = canlendar.get(Calendar.DAY_OF_MONTH);
			System.out.println(day>=Math.abs(daysInt)?daysInt:day*-1);
			canlendar.add(Calendar.DATE, day>=Math.abs(daysInt)?daysInt:day*-1); // 日期减 如果不够减会将变成当月天
	        Date date = canlendar.getTime();
	        String dateStr = sdfDay.format(date);
	        return dateStr;
	    }    
	    /**
	     * 得到n天之后的日期  yyyyMMdd
	     * @param days
	     * @return
	     */
	    public static String YYYYMMDDgetAfterDay(String days) {
	    	int daysInt = Integer.parseInt(days);
	    	
	        Calendar canlendar = Calendar.getInstance(); // java.util包
	        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
	        Date date = canlendar.getTime();
	        
	        String dateStr = sdfDays.format(date);
	        
	        return dateStr;
	    }
	    
	    /**
	     * 得到n小时之后的日期  yyyyMMdd HH:mm:ss
	     * @param days
	     * @return
	     */
	    public static String YYYYMMDDgetAfterHour(Date date,String hour) {
	    	int hourInt = Integer.parseInt(hour);
	    	
	        Calendar canlendar = Calendar.getInstance(); // java.util包
	        canlendar.setTime(date);
	        canlendar.add(Calendar.HOUR, hourInt); // 日期减 如果不够减会将月变动
	        
	        date = canlendar.getTime();
	        String dateStr = sdfTime.format(date);
	        
	        return dateStr;
	    }
	    
	    /**
	     * 得到n分钟之后的日期  yyyyMMdd HH:mm:ss
	     * @param days
	     * @return
	     */
	    public static String getAfterMinute(Date date,int Minute) {
	     
	        Calendar canlendar = Calendar.getInstance(); // java.util包
	        canlendar.setTime(date);
	        canlendar.add(Calendar.MINUTE, Minute);  
	        date = canlendar.getTime();
	        return sdfTime.format(date);
	    }
	    
	    /**
	     * 得到n天之后是周几
	     * @param days
	     * @return
	     */
	    public static String getAfterDayWeek(String days) {
	    	int daysInt = Integer.parseInt(days);
	    	
	        Calendar canlendar = Calendar.getInstance(); // java.util包
	        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
	        Date date = canlendar.getTime();
	        
	        String dateStr = sdfE.format(date);
	        
	        return dateStr;
	    }
	  
	    
	    /**
	     * 转换日期为周几
	     * @param days
	     * @return
	     */
	    public static String getDayWeek(Date date) {
	        
	        String dateStr = sdfE.format(date);
	        
	        return dateStr;
	    }
	    
	    /**
	     * Solr 日期查询格式化
	     * @param date
	     * @return
	     */
	    public static String UTCFormat(Date date){
			TimeZone timeZone = TimeZone.getTimeZone("UTC");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd^hh:mm:ss");
			format.setTimeZone(timeZone);
			String temp = format.format(date).replace("^", "T");
			temp+="Z";
			return temp;
		}
	    
	    /**
	     * 将传入的日期转换为"日期当天"的最后一秒.
	     * @param date
	     * @return
	     */
	    public static Date  ENDDayTime(Date date){
	    	Calendar calendar=Calendar.getInstance();
	    	calendar.setTime(date);
	    	calendar.set(Calendar.HOUR_OF_DAY, 23);
	    	calendar.set(Calendar.MINUTE, 59);
	    	calendar.set(Calendar.SECOND, 59);
	    	return calendar.getTime();
	    }
	    
	    /**
	     * 计算时间差   秒
	     * @param begin 开始时间
	     * @param end   结束时间
	     * @return
	     */
	    public static long Sdifference(Date begin,Date end){
	    	return (end.getTime()-begin.getTime())/1000;
	    }
	    
	    /**
	     * 计算当天到24点还剩下多少毫秒
	     * @return
	     */
	    public static long currentDayResidueTime(){
			long hour = 60 * 60 * 1000;
			long time = System.currentTimeMillis();
			time += 8 * hour; 
			time %= 24 * hour;
			time = 24 * hour - time;
	    	return time;
	    }
	   


		/**
		 * 判断日期格式是否为 yyyy-MM-DD HH:mm:ss
		 * @param date
		 * @return
		 */
		public static boolean isDate(String date)
		{
			/**
			 * 判断日期格式和范围
			 */
			String rexp = "^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))\\s+([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";
			
			Pattern pat = Pattern.compile(rexp);  
			
			Matcher mat = pat.matcher(date);  
			
			boolean dateType = mat.matches();

			return dateType;
		}
		
		

		/**
		 * 获取n后时间
		 * 
		 * @return
		 */
		public static String getYearAfter(Date date,int year) {
			Calendar canlendar = Calendar.getInstance();
			//设置日期
			canlendar.setTime(date);
			//几年以后  
			canlendar.add(Calendar.YEAR, year);  
			return sdfDay.format(canlendar.getTime());
		}
		
		/**
		 * 获得当天0点时间
		 * @return
		 */
		public static Date getTimesmorning() {
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.MILLISECOND, 0);
			return cal.getTime();


		}
		/**
		 * 获得昨天0点时间
		 * @return
		 */
		public static Date getYesterdaymorning() {
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(getTimesmorning().getTime()-3600*24*1000);
			return cal.getTime();
		}
		/**
		 * 获得当天近7天时间 
		 * @return
		 */
		public static Date getWeekFromNow() {
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis( getTimesmorning().getTime()-3600*24*1000*7);
			return cal.getTime();
		}

		/**
		 * 获得当天24点时间
		 * @return
		 */
		public static Date getTimesnight() {
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.HOUR_OF_DAY, 24);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.MILLISECOND, 0);
			return cal.getTime();
		}

		/**
		 * 获得本周一0点时间
		 * @return
		 */
		public static Date getTimesWeekmorning() {
/*			Calendar cal = Calendar.getInstance();
			cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
			cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			return cal.getTime();*/
			
			  Calendar c = Calendar.getInstance();
			  int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
			  if (day_of_week == 0)
			   day_of_week = 7;
			  c.add(Calendar.DATE, -day_of_week + 1);
			  return  c.getTime();
		}

		/**
		 * 获得本周日时间
		 * @return
		 */
		public static Date getTimesWeeknight() {
			/*Calendar cal = Calendar.getInstance();
			cal.setTime(getTimesWeekmorning());
			cal.add(Calendar.DAY_OF_WEEK, 7);
			return cal.getTime();*/
			Calendar c = Calendar.getInstance();
			//c.setTime(DateUtil.beforeOrAfterNumberDay("2017-05-18 10:10:10", 1));
			
			int day_of_week = c.get(Calendar.DAY_OF_WEEK)-1;
			//System.out.println(day_of_week);
			if (day_of_week < 7){
				day_of_week = 7-day_of_week;
			}
			c.add(Calendar.DATE, day_of_week);
			return c.getTime();
		}

		/**
		 * 获得本月第一天0点时间
		 * @return
		 */
		public static Date getTimesMonthmorning() {
			Calendar cal = Calendar.getInstance();
			cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
			cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
			return cal.getTime();
		}

		/**
		 * 获得本月最后一天结束时间
		 * @return
		 */
		public static Date getTimesMonthnight() {
			Calendar cal = Calendar.getInstance();
			cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
			cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
			cal.set(Calendar.HOUR_OF_DAY, 24);
			cal.add(Calendar.DATE, -1);
			cal.add(Calendar.HOUR, 23);
			cal.add(Calendar.MINUTE, 59);
			cal.add(Calendar.SECOND, 59);
			return cal.getTime();
		}

		/**
		 * 上月初0点时间
		 * @return
		 */
		public static Date getLastMonthStartMorning() {
			Calendar cal = Calendar.getInstance();
			cal.setTime(getTimesMonthmorning());
			cal.add(Calendar.MONTH, -1);
			return cal.getTime();
		}

		/**
		 * 本季度开始点时间
		 * @return
		 */
		public static Date getCurrentQuarterStartTime() {
			Calendar c = Calendar.getInstance();
			int currentMonth = c.get(Calendar.MONTH) + 1;
			SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
			Date now = null;
			try {
				if (currentMonth >= 1 && currentMonth <= 3)
					c.set(Calendar.MONTH, 0);
				else if (currentMonth >= 4 && currentMonth <= 6)
					c.set(Calendar.MONTH, 3);
				else if (currentMonth >= 7 && currentMonth <= 9)
					c.set(Calendar.MONTH, 4);
				else if (currentMonth >= 10 && currentMonth <= 12)
					c.set(Calendar.MONTH, 9);
				c.set(Calendar.DATE, 1);
				now = longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return now;
		}

		/**
		 * 本季度结束点时间，即2017-03-31 23:59:59
		 *
		 * @return
		 */
		public static Date getCurrentQuarterEndTime() {
			Calendar cal = Calendar.getInstance();
			cal.setTime(getCurrentQuarterStartTime());
			cal.add(Calendar.MONTH, 3);
			return cal.getTime();
		}

	    /**  
	     * 计算两个日期之间相差的天数  
	     * @param smdate 较小的时间 
	     * @param bdate  较大的时间 
	     * @return 相差天数 
	     * @throws ParseException  
	     */    
	    public static int daysBetween(Date smdate,Date bdate){    
	        try {
				smdate=sdfTime.parse(sdfTime.format(smdate));
			} catch (ParseException e) {
				e.printStackTrace();
			}  
	        try {
				bdate=sdfTime.parse(sdfTime.format(bdate));
			} catch (ParseException e) {
				e.printStackTrace();
			}  
	        Calendar cal = Calendar.getInstance();    
	        cal.setTime(smdate);    
	        long time1 = cal.getTimeInMillis();                 
	        cal.setTime(bdate);    
	        long time2 = cal.getTimeInMillis();         
	        long between_days=(time2-time1)/(1000*3600*24);  
	            
	       return Integer.parseInt(String.valueOf(between_days));           
	    }    
	      
	/** 
	*字符串的日期格式的计算 
	*/  
	    public static int daysBetween(String smdate,String bdate){  
	        Calendar cal = Calendar.getInstance();    
	        try {
				cal.setTime(sdfTime.parse(smdate));
			} catch (ParseException e) {
				e.printStackTrace();
			}    
	        long time1 = cal.getTimeInMillis();                 
	        try {
				cal.setTime(sdfTime.parse(bdate));
			} catch (ParseException e) {
				e.printStackTrace();
			}    
	        long time2 = cal.getTimeInMillis();         
	        long between_days=(time2-time1)/(1000*3600*24);  
	            
	       return Integer.parseInt(String.valueOf(between_days));     
	    }  
 
	    
	}

