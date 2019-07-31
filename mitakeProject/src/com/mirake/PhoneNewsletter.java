package com.mirake;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

public class PhoneNewsletter {

	public static void main(String[] args) throws ProtocolException {

		// reqUrl.append("http://smsapi.mitake.com.tw/api/mtk/SmSend?"); �蝑�陛閮撘�
		/**
		 * http://smsapi.mitake.com.tw/api/mtk/SmSend?username=55779783&&password=536225ab&dstaddr=0908137867&smbody=1515&CharsetURL=UTF-8
		 */
//		try {
//			StringBuffer reqUrl = new StringBuffer();
////			reqUrl.append("http://smsapi.mitake.com.tw/b2c/mtk/SmSend?");
//			reqUrl.append("http://smsapi.mitake.com.tw/api/mtk/SmSend?");
//			reqUrl.append("username=55779783");
//			reqUrl.append("&password=536225ab");
//			reqUrl.append("&dstaddr=0908137867");
//			reqUrl.append("&smbody=" + URLEncoder.encode("this.istest ", "UTF-8"));
//			reqUrl.append("&CharsetURL=UTF-8");
//			URL url = new URL(reqUrl.toString());
//			HttpURLConnection  urlConnection = (HttpURLConnection) url.openConnection();
//			urlConnection.setRequestMethod("GET");
//			int code= urlConnection.getResponseCode();
//			String ex = urlConnection.getResponseMessage();
//			System.out.println("�����Ⅳ:"+code);
//			System.out.println("����閮:"+ex);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		URL url;
		try {
			url = new URL(
					"http://smsapi.mitake.com.tw/api/mtk/SmBulkSend?username=55779783&password=536225ab&Encoding_PostIn=UTF-8");
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("POST");
			urlConnection.setDoOutput(true);
			DataOutputStream out = new DataOutputStream(urlConnection.getOutputStream());
			StringBuffer body = new StringBuffer();

			body.append("82555$$0908137867$$$$$$$$$$訊號傳送").append("\r\n");
			body.append("98547$$0966302982$$$$$$$$$$訊號傳送").append("\r\n");
			out.write(body.toString().getBytes("UTF-8"));

			BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			System.out.println(response.toString());

			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// HTTP POST霂瑟��
	public static void sendPost() throws Exception {
		String USER_AGENT = "Mozilla/5.0";
		String url = "http://smsapi.mitake.com.tw/api/mtk/SmBulkSend";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// 瘛餃�窈瘙仍
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String urlParameters = "username=55779783&password=536225ab&Encoding_PostIn=utf-8&objectID=154";

		// ���ost霂瑟��
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());

		StringBuffer body = new StringBuffer();
		body.append(urlParameters);
		body.append("001$$0908137867$$20170101000000$$20170102000000$$$$$$蝪∟�mBulkSend皜祈岫").append("\r\n");
		body.append("002$$0923551951$$20170101000000$$20170102000000$$$$$$蝪∟�mBulkSend皜祈岫").append("\r\n");
//		wr.writeBytes(urlParameters);
		wr.write(body.toString().getBytes("UTF-8"));
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		String respMessage = con.getResponseMessage();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters:" + urlParameters);
		System.out.println("Response Code : " + responseCode);
		System.out.println("Response Message : " + respMessage);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// ��蝏��
		System.out.println(response.toString());

	}

	/**
	 * 
	 * @param messageContents       ��閬����摰�
	 * @param messageTransferNumber ����隞����
	 * @param mitakLoginVal
	 * @return
	 */
	public static String sendSMSmessaging(String messageContents, String messageTransferNumber,
			HashMap<String, Object> mitakLoginVal) {
		URL url;

		try {
			url = new URL(
					"http://smsapi.mitake.com.tw/api/mtk/SmBulkSend?username=55779783&password=536225ab&Encoding_PostIn=UTF-8");
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("POST");
			urlConnection.setDoOutput(true);
			DataOutputStream out = new DataOutputStream(urlConnection.getOutputStream());
			StringBuffer body = new StringBuffer();
			body.append("82555$$0985803583$$$$$$$$$$" + messageContents).append("\r\n");
			body.append("98547$$0920323591$$$$$$$$$$" + messageContents).append("\r\n");
			out.write(body.toString().getBytes("UTF-8"));
			BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			System.out.println(response.toString());

			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public static String MT4oederSMSMessage(String messageContents, String messageTransferNumber,
			HashMap<String, Object> mitakLoginVal) {
		URL url;
		try {
			url = new URL("" + mitakLoginVal.get("") + "?username=" + mitakLoginVal.get("") + "&password="
					+ mitakLoginVal.get("") + "&Encoding_PostIn=UTF-8");
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("POST");
			urlConnection.setDoOutput(true);
			DataOutputStream out = new DataOutputStream(urlConnection.getOutputStream());
			StringBuffer body = new StringBuffer();
			
			
			
			
			body.append("82555$$0908137867$$$$$$$$$$"+messageContents+"").append("\r\n");
			body.append("98547$$0966302982$$$$$$$$$$"+messageContents+"").append("\r\n");
			out.write(body.toString().getBytes("UTF-8"));

			BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			System.out.println(response.toString());

			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return messageTransferNumber;
	}

}
