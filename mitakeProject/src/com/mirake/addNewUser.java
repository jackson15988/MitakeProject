package com.mirake;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mirake.server.bo.mirakeBo;

/**
 * 
 * @author IMI-JAVA-Ryan �i�J��Ʈw�ϥΤ�k
 *
 */
@WebServlet("/addNewUser")
public class addNewUser extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("username");
		String userPhone = request.getParameter("userPhone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");

		HashMap<String, Object> inserVal = new HashMap<>();
		inserVal.put("USERNAME", userName);
		inserVal.put("USERPHONE", userPhone);
		inserVal.put("USEREMAIL", email);
		inserVal.put("ADDRESS", address);
		java.util.Random rnd = new java.util.Random();
		rnd.setSeed(System.currentTimeMillis());
		inserVal.put("CUSTOMERNUMBER", "MTK" + rnd.nextInt());

		String resultCdoe = mirakeBo.addNewMember(inserVal);
		System.out.println("�|���W��" + userName);
		System.out.println("�|�����" + userPhone);
		System.out.println("�|��EMAIL" + email);
		System.out.println("�|���a�}" + address);

		System.out.println("���\�X�P�_:" + resultCdoe);

		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		if (resultCdoe.equals("0")) {
			String str = "{\"code\":\"0\",\"message\":\"�|���s�W���\\"}";
			out.println(str);
		} else {
			out.write("[{\"code\":-1,\"message\":�|���s�W����}]");
			String str = "{\"code\":\"-1\",\"message\":\"�|���s�W����\"}";
			out.println(str);
		}
		out.flush();
		out.close();

	}

}
