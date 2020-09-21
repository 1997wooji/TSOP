package com.tsop.util;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class HttpUtil {
	public static void forward(HttpServletRequest request, HttpServletResponse response, String path) {
		try {
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		} catch (Exception e) {
			System.out.println("오류발생 : " + e);
		}
	}
}
