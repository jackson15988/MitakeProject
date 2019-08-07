package com.mirake;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mirake.server.bo.mirakeBo;

/**
 * Servlet implementation class FindUserList
 */
@WebServlet("/FindUserList")
public class FindUserList extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Statement stmt = null;
		mirakeBo getConection = new mirakeBo();
		Connection conn = getConection.getJDBCConneciton();

		try {
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = new JSONObject();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM fo_customerlist ;";
			ResultSet result = stmt.executeQuery(sql);
			HashMap<String, LinkedList<String>> maps = new HashMap<String, LinkedList<String>>();
			PrintWriter out = response.getWriter();
			while (result.next()) {
				jsonObject.put("id", result.getString("ID"));
				jsonObject.put("customerNumber", result.getString("CUSTOMERNUMBER"));
				jsonObject.put("userName", result.getString("USERNAME"));
				jsonObject.put("UserPhone", result.getString("USERPHONE"));
				jsonArray.add(jsonObject);
			}
			response.setHeader("content-type", "text/html;charset=UTF-8");
			
			out.print(jsonArray);

			System.out.println(jsonArray);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
