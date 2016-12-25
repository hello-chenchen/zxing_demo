package com.hellochenchen.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.zxing.WriterException;

import com.hellochenchen.util.QRCodeUtil;


/**  
 * ClassName: QRCode <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason: TODO ADD REASON. <br/>  
 * date: 2016年12月4日 下午11:47:21 <br/>  
 *  
 * @author hello_chenchen  
 * @version   
 * @since JDK 1.8.0_111  
 */
public class QRCode extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String website = request.getParameter("website");
		QRCodeUtil qrcode = new QRCodeUtil();
		try {
		    qrcode.createQRCode(website, response.getOutputStream());
		} catch (WriterException e) {
			e.printStackTrace();
		}
		//String website = request.getAttribute("website").toString();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
