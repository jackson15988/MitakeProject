package com.mirake.server.bo;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.mirake.PhoneNewsletter;

/**
 * 
 * @author IMI-JAVA-Ryan 此為傳送至客戶手機訊號的多執行續用法
 *
 */
public class mirakeSmsThread extends Thread {

	private HashMap<String, Object> batchArgsMaps;

	public void setBatchArgsMaps(HashMap<String, Object> batchArgsMaps) {
		this.batchArgsMaps = batchArgsMaps;
	}

	
	public void run() {
		
		
		Mt4ForxUtil utl = new Mt4ForxUtil();
		String chineseSymbolName = utl.forexCorrectName(batchArgsMaps.get("OrderSymbol").toString());
		String SymbolType =  utl.getSymbolChineseType(batchArgsMaps.get("OrderType").toString());
		/* 這裡去組成下單資訊 */
		StringBuffer body = new StringBuffer();
		body.append("品種:" + chineseSymbolName + "//" + "價格:" + batchArgsMaps.get("OrderOpenPrice") +"//" + "止損:" + batchArgsMaps.get("OrderStopLoss") +"//" + "止盈:" + batchArgsMaps.get("OrderTakeProfit")
				+ "//Type:"+SymbolType);
		body.append("//平台時間:"+batchArgsMaps.get("OrderOpenTimer") + "//  警語 :  投資一定有風險，請嚴設停損。");
		String messageContents = body.toString();
		String messageTransferNumber = (String) batchArgsMaps.get("OrderTicket");

		// 取得三竹資訊的證券
		HashMap<String, Object> mitakLoginVal = new HashMap<>();
		try {
			mitakLoginVal = mirakeBo.getMitakeSettingVal();
			PhoneNewsletter phletter = new PhoneNewsletter();

			// 傳送三竹簡訊給客戶
			System.out.println("客戶接收到的訊息:" + messageContents);
			System.out.println("客戶接收到的單號:" + messageTransferNumber);

//			phletter.MT4oederSMSMessage(messageContents, messageTransferNumber , mitakLoginVal);
			
		} catch (SQLException e) {
			System.out.println("資料發生錯誤:" + e);
		}

	}

	

	

}
