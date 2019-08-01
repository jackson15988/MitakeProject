package com.mirake.server.bo;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import com.mirake.PhoneNewsletter;

class mitakeTest {

	@Test
	void test() {
		
		String messageContents ="感謝與祝福~年年money多，天天happy多，平安健康多，萬事皆可達!永遠如意*^_^*";
		String messageTransferNumber = "1510009831";
		
		HashMap<String, Object> mitakLoginVal = new HashMap<String, Object>();
		try {
			mitakLoginVal = mirakeBo.getMitakeSettingVal();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PhoneNewsletter.MT4oederSMSMessage(messageContents, messageTransferNumber, mitakLoginVal);
	}
	
	
	@Test
	void test2() {
		Mt4ForxUtil  utl = new Mt4ForxUtil();
		String ex = utl.forexCorrectName("EURJPY");
		
		System.out.println(ex);
	}

}
