package com.mirake.server.bo;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import com.mirake.PhoneNewsletter;

class mitakeTest {

	@Test
	void test() {
		
		String messageContents ="訊息本身";
		String messageTransferNumber = "51445";
		
		HashMap<String, Object> mitakLoginVal = new HashMap<String, Object>();
		try {
			mitakLoginVal = mirakeBo.getMitakeSettingVal();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PhoneNewsletter.MT4oederSMSMessage(messageContents, messageTransferNumber, mitakLoginVal);
	}

}
