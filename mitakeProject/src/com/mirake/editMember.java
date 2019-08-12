package com.mirake;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mirake.server.bo.Mt4ForxUtil;
import com.mirake.server.bo.mirakeBo;

/**
 * Servlet implementation class editMember
 */
@WebServlet("/editMember")
public class editMember extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("username");
		String userPhone = request.getParameter("userPhone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String expirationTimer = request.getParameter("custMemberDataTime");
		String custId = request.getParameter("hiddenVal");

		try {
			if (!expirationTimer.isEmpty()) {
				expirationTimer = Mt4ForxUtil.timeFormat(expirationTimer);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("權益到期間:" + expirationTimer);

		HashMap<String, Object> editVal = new HashMap<>();
		editVal.put("USERNAME", userName);
		editVal.put("USERPHONE", userPhone);
		editVal.put("USEREMAIL", email);
		editVal.put("ADDRESS", address);
		editVal.put("CUST_MEMBER_DATATIME", expirationTimer == null ? "" : expirationTimer);
		editVal.put("CUSTOMERNUMBER", custId);

		String resultCdoe = mirakeBo.editMember(editVal);

		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		if (resultCdoe.equals("0")) {
			String str = "{\"code\":\"0\",\"message\":\"編輯成功\"}";
			out.println(str);
		} else

		{
			out.write("[{\"code\":-1,\"message\":錯誤}]");
			String str = "{\"code\":\"-1\",\"message\":\"錯誤\"}";
			out.println(str);
		}
		out.flush();
		out.close();

	}

}
