package com.mirake;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Decoder.BASE64Decoder;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;




/**
 * Servlet implementation class SmSend
 */
@WebServlet("/SmSend")
public class SmSend extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String jsonStr = "";
		String orderval = request.getParameter("orderval");
		System.out.println("取得參數:" + orderval);

		if (!orderval.isEmpty()) {

			BASE64Decoder decoder = new BASE64Decoder();
			try {
				byte[] byt64 = decoder.decodeBuffer(orderval);
				orderval = new String(byt64);
				System.out.println(orderval);
			} catch (IOException e) {				e.printStackTrace();
			}
			jsonStr = orderval;
			java.util.Date d1 = null;
			JSONArray jsonArray = JSONArray.fromObject(jsonStr);
			List<Object[]> batchArgs = new ArrayList<>();

			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jUser = jsonArray.getJSONObject(i);
				String dateformat = jUser.getString("OrderOpenTime").toString();
				String yearDate = dateformat.substring(0, dateformat.indexOf(","));
				String hourDate = dateformat.substring(dateformat.indexOf(","), dateformat.length()).replace(",", "");
				yearDate = yearDate.replace(".", "-");
				String orderDateformat = yearDate + " " + hourDate;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					d1 = sdf.parse(orderDateformat);
					System.out.println("取出來之後的時間是" + d1);
				} catch (ParseException e) {
					System.out.println("轉換sqlDate對象失敗:" + e);
				}
				batchArgs.add(new Object[] { jUser.get("OrderSymbol").toString(), jUser.get("OrderType").toString(),
						jUser.get("OrderOpenPrice").toString(), jUser.get("OrderStopLoss").toString(),
						jUser.get("OrderTakeProfit").toString(), d1, 15221, jUser.get("OrderLots").toString(),
						jUser.get("OrderTicket").toString() });
			}
			System.out.println("取得" + batchArgs);
		}

	}

}
