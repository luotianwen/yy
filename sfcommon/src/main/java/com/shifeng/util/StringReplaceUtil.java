package com.shifeng.util;

/**
 * 字符串替换
 * @author Win
 *
 */
public class StringReplaceUtil {
	
	public static void main(String[] args) {
		System.out.println(userNameReplaceWithStar("xdd"));
	}
	
	/**
     * 根据用户名的不同长度，来进行替换 ，达到匿名效果
     * @param userName 用户名
     * @return 替换后的用户名
     */
    public static String userNameReplaceWithStar(String userName) {
        String userNameAfterReplaced = "";

        if (userName == null){
            userName = "";
        }

        int nameLength = userName.length();

        if (nameLength <= 1) {
            userNameAfterReplaced = "*";
        } else if (nameLength == 2) {
            userNameAfterReplaced = replaceAction(userName, "(?<=\\w{1})\\w(?=\\w{0})");
        } else if (nameLength >= 3) {
            userNameAfterReplaced = replaceAction(userName, "(?<=\\w{1})\\w(?=\\w{1})");
        }

        return userNameAfterReplaced;

    }

    /**
     * 实际替换动作
     * @param username
     * @param regular  正则
     * @return
     */
    private static String replaceAction(String username, String regular) {
        return username.replaceAll(regular, "*");
    }

    /**
     * 身份证号替换，保留前四位和后四位
     * 如果身份证号为空 或者 null ,返回null ；否则，返回替换后的字符串；
     * @param idCard 身份证号
     * @return
     */
    public static String idCardReplaceWithStar(String idCard) {

        if (idCard.isEmpty() || idCard == null) {
            return null;
        } else {
            return replaceAction(idCard, "(?<=\\d{4})\\d(?=\\d{4})");
        }
    }

    /**
     * 银行卡替换，保留后四位
     * 如果银行卡号为空 或者 null ,返回null ；否则，返回替换后的字符串；
     * @param bankCard 银行卡号
     * @return
     */
    public static String bankCardReplaceWithStar(String bankCard) {

        if (bankCard.isEmpty() || bankCard == null) {
            return null;
        } else {
            return replaceAction(bankCard, "(?<=\\d{0})\\d(?=\\d{4})");
        }
    }
}
