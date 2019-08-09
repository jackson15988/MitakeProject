package com.mirake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.mirake.server.bo.mirakeBo;

/**
 * Servlet implementation class delectUser
 */
@WebServlet("/delectUser")
public class delectUser extends HttpServlet {
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		BufferedReader reader = request.getReader();
		String json = reader.readLine();
		JSONObject jsonVal = JSONObject.parseObject(json);
		String userNumber = (String) jsonVal.get("userNumber");

		
		Connection conn = mirakeBo.getJDBCConneciton();
		PrintWriter out = response.getWriter();

		try {
			Statement stmt = conn.createStatement();
			String sql = "DELETE FROM fo_customerlist where CUSTOMERNUMBER='" + userNumber + "'";
			System.out.println(sql);
			int sc = stmt.executeUpdate(sql);


			System.out.println(json);
			reader.close();

			String str = "{\"code\":\"0\",\"message\":\"新增成功\"}";
			out.write(str);
			out.close();

		} catch (SQLException e) {
			out.write("[{\"code\":-1,\"message\":錯誤}]");
			out.close();
			try {
				conn.rollback();
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {

				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

}
