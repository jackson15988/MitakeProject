package com.mirake.server.bo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Map.Entry;

public class Mt4ForxUtil {
		
	
	public static void main(String[] args) {
		String dx;
		try {
			dx = Mt4ForxUtil.timeFormat("31-July-2019 06:50");
		
		System.out.println("正確" + dx);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String forexCorrectName(String Symbol) {

		String chineseName = "";

		HashMap<String, String> correct = new HashMap<>();
		correct.put("EURUSD", "歐美兌");
		correct.put("GBPUSD", "磅美兌");
		correct.put("USDCHF", "美瑞兌");
		correct.put("USDJPY", "美日兌");
		correct.put("USDCAD", "美加兌");
		correct.put("AUDUSD", "澳美兌");
		correct.put("EURGBP", "歐磅兌");
		correct.put("EURAUD", "歐澳兌");
		correct.put("EURCHF", "歐瑞兌");
		correct.put("EURJPY", "歐日兌");
		correct.put("GBPCHF", "磅瑞兌");
		correct.put("CADJPY", "加日兌");
		correct.put("GBPJPY", "磅日兌");
		correct.put("AUDNZD", "澳紐兌");
		correct.put("AUDCAD", "澳加兌");
		correct.put("AUDCHF", "奧瑞兌");
		correct.put("AUDJPY", "澳日兌");
		correct.put("CHFJPY", "瑞日兌");
		correct.put("EURNZD", "歐紐兌");
		correct.put("EURCAD", "歐加兌");
		correct.put("CADCHF", "加瑞兌");
		correct.put("NZDJPY", "紐日兌");
		correct.put("NZDUSD", "紐美兌");
		correct.put("XAUUSD", "黃金兌美元");

		for (Entry<String, String> entry : correct.entrySet()) {

			if (entry.getKey().contains(Symbol.toUpperCase())) {
				chineseName = entry.getValue();
			}

		}

		if (chineseName.isEmpty()) {
			return Symbol;
		} else {

			return chineseName;
		}
	}

	public static boolean like(String str, String expr) {
		expr = expr.toLowerCase();// ignoring locale for now
		expr = expr.replace(".", ".");// "" is escaped to"" (thanks, Alan M)
		// ... escape any other potentially problematic characters here
		expr = expr.replace("?", ".");
		expr = expr.replace("%", ".*");
		str = str.toLowerCase();
		return str.matches(expr);
	}

	public String getSymbolChineseType(String type) {

		String chineseType = "";
		switch (type) {
		case "0":
			chineseType = "買入(Buy)";

			break;
		case "1":
			chineseType = "賣出(Sell)";
			break;
		case "2":
			chineseType = "預掛反彈買單(Buy Limit)";
			break;
		case "3":
			chineseType = "預掛反彈賣單(Sell Limit)";
			break;
		case "4":
			chineseType = "預掛買單(Buy Stop)";
			break;
		case "5":
			chineseType = "預掛賣單(Sell Stop)";
			break;
		}

		return chineseType;

	}

	public static String stringtoUnicode(String string) {

		if (StringUtils.isBlank(string)) {
			return null;
		}

		char[] bytes = string.toCharArray();
		StringBuffer unicode = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			char c = bytes[i];

			// 标准ASCII范围内的字符，直接输出
			if (c >= 0 && c <= 127) {
				unicode.append(c);
				continue;
			}
			String hexString = Integer.toHexString(bytes[i]);

			unicode.append("\\u");

			// 不够四位进行补0操作
			if (hexString.length() < 4) {
				unicode.append("0000".substring(hexString.length(), 4));
			}
			unicode.append(hexString);
		}
		return unicode.toString();

	}

	public static String timeFormat(String getData) throws ParseException {
		
		
		Locale locale = Locale.US; 
    
        SimpleDateFormat frm = new SimpleDateFormat("dd-MMM-yyyy HH:mm",Locale.ENGLISH); 
        Date date = frm.parse(getData); 
        
     

        SimpleDateFormat frm1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale); 
        System.out.println("reformat : " +  frm1.format(date));
		return   frm1.format(date); 
		

	}

}
