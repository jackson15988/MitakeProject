package com.mirake;

import java.io.IOException;
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

import com.mirake.server.bo.mirakeBo;

import net.sf.json.JSONArray;

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
			stmt = conn.createStatement();
			String sql = "SELECT * FROM fo_customerlist ;";
			ResultSet result = stmt.executeQuery(sql);
			HashMap<String, LinkedList<String>> maps = new HashMap<String, LinkedList<String>>();

			while (result.next()) {
				LinkedList<String> linkVal = new LinkedList<>();
				linkVal.add(result.getString("ID"));
				linkVal.add(result.getString("CUSTOMERNUMBER"));
				linkVal.add(result.getString("USERNAME"));
				linkVal.add(result.getString("USERPHONE"));
				maps.put(result.getString("CUSTOMERNUMBER"), linkVal);
			}
			JSONArray mJSONArray = new JSONArray(Arrays.asList(maps));
			System.out.println(mJSONArray);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
