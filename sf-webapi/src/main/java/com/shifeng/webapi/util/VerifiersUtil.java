package com.shifeng.webapi.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.apache.commons.lang.StringUtils;

import com.shifeng.response.ReqResponse;
import com.shifeng.webapi.common.ErrorMsg;

/**
 * 验证工具类
 * @author Win
 *
 */
public class VerifiersUtil{
	//密码长度只能在6-20位字符之间 由英文、数字及标点符号组成
	private static final String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[A-Za-z0-9\\W_]{6,20}$";

	/**
	 *不能全是相同的数字或者字母（如：000000、111111、aaaaaa）
	 *@param numOrStr numOrStr.length()>0
	 *@return 全部相同返回true
	 */
	public static boolean equalStr(String numOrStr) {
		boolean flag = true;
		char str = numOrStr.charAt(0);
		for (int i = 0; i < numOrStr.length(); i++) {
			if (str != numOrStr.charAt(i)) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	/**
	 *不能是连续的数字--递增（如：123456、12345678）
	 *@param numOrStr 
	 *@return 连续数字返回true
	 */
	public static boolean isOrderNumeric(String numOrStr) {
		boolean flag = true;// 如果全是连续数字返回true
		boolean isNumeric = true;
		// 如果全是数字返回true
		for (int i = 0; i < numOrStr.length(); i++) {
			if (!Character.isDigit(numOrStr.charAt(i))) {
				isNumeric = false;
				break;
			}
		}
		if (isNumeric) {
			// 如果全是数字则执行是否连续数字判断
			for (int i = 0; i < numOrStr.length(); i++) {
				if (i > 0) {
					// 判断如123456
					int num = Integer.parseInt(numOrStr.charAt(i) + "");
					int num_ = Integer.parseInt(numOrStr.charAt(i - 1) + "") + 1;
					if (num != num_) {
						flag = false;
						break;
					}
				}
			}
		} else {
			flag = false;
		}
		return flag;
	}

	/**
	 *不能是连续的数字--递减（如：987654、876543） 
	 *@param numOrStr
	 *@return 连续数字返回true
	 */
	public static boolean isOrderNumeric_(String numOrStr) {
		boolean flag = true;
		// 如果全是连续数字返回true
		boolean isNumeric = true;
		// 如果全是数字返回true
		for (int i = 0; i < numOrStr.length(); i++) {
			if (!Character.isDigit(numOrStr.charAt(i))) {
				isNumeric = false;
				break;
			}
		}
		if (isNumeric) {
			// 如果全是数字则执行是否连续数字判断
			for (int i = 0; i < numOrStr.length(); i++) {
				if (i > 0) {
					// 判断如654321
					int num = Integer.parseInt(numOrStr.charAt(i) + "");
					int num_ = Integer.parseInt(numOrStr.charAt(i - 1) + "") - 1;
					if (num != num_) {
						flag = false;
						break;
					}
				}
			}
		} else {
			flag = false;
		}
		return flag;
	}

	/**
	 * 密码校验
	 * @param password
	 * @return 通过TRUE  
	 */
	public static boolean passwordVerifiers(String password,ReqResponse<?> req){
		if(StringUtils.isBlank(password)){
			req.setCode(ErrorMsg.FAIL.getCode());
			req.setMsg("密码不能为空");
			return false;
		}
		if(equalStr(password)){
			req.setCode(ErrorMsg.FAIL.getCode());
			req.setMsg("密码不能全为相同的字符");
			return false;
		}
		if(isOrderNumeric(password)){
			req.setCode(ErrorMsg.FAIL.getCode());
			req.setMsg("密码不能是连续的数字");
			return false;
		}
		if(isOrderNumeric_(password)){
			req.setCode(ErrorMsg.FAIL.getCode());
			req.setMsg("密码不能是连续的数字");
			return false;
		}
		if(!password.matches(regex)){
			req.setCode(ErrorMsg.FAIL.getCode());
			req.setMsg("密码必须是6-20位字符，建议由字母，数字和符号两种以上组合");
			return false;
		}
		return true;
	}
/*	移动号段：
	134 135 136 137 138 139 147 150 151 152 157 158 159 172 178 182 183 184 187 188
	联通号段：
	130 131 132 145 155 156  171 175 176 185 186
	电信号段：
	133 153 173 177 180 181 189
	虚拟运营商:
	170 
	
	 /^0?(13[0-9]|15[012356789]|17[013678]|18[0-9]|14[57])[0-9]{8}$/
	*
	*/
    /** 
     * 手机号码11位数，匹配格式：前三位固定格式+后8位任意数 
     * 13+任意数 
     * 15+除4的任意数 
     * 18+除1和4的任意数 
     * 17+除9的任意数 
     * 147 
     */  
    public static boolean validatePhone(String phone){  
        String regExp = "^0?(13[0-9]|15[012356789]|17[013678]|18[0-9]|14[57])[0-9]{8}$";
        		//"^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";  
       /* Pattern p = Pattern.compile(regExp);  
        Matcher m = p.matcher(phone);  */
        return phone.matches(regExp);  
    }  
	
	
	public static void main(String[] args) {
		String str = "123456";
		boolean flag = isOrderNumeric(str);
		System.out.println(flag);
		System.out.println(isOrderNumeric_("654321"));
		System.out.println(equalStr("哈哈哈"));
		String value = "a.123456";  // 长度不够
		System.out.println(value.matches(regex));
		System.out.println(validatePhone("18610813725"));
	}

}