package com.mirake.server.bo;

import java.util.HashMap;
import java.util.LinkedList;

public class Mt4ForxUtil {

	
	
	public String forexCorrectName(String Symbol) {		
		
		HashMap<String, String>  correct = new HashMap<>();
		correct.put("", "歐美兌");
		correct.put("", "磅美兌");
		correct.put("", "澳日兌");
		correct.put("", "歐美兌");
		correct.put("", "歐美兌");
		correct.put("", "歐美兌");
		correct.put("", "歐美兌");
		correct.put("", "歐美兌");
		correct.put("", "歐美兌");
		return null;
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

}
