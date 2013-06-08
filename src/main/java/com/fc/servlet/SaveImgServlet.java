package com.fc.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Decoder;

public class SaveImgServlet extends HttpServlet {

	private static final long serialVersionUID = 5766491565886652135L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String imgdata = request.getParameter("imgdata");
		BASE64Decoder decoder = new BASE64Decoder();
		try {
            // Base64解码
            byte[] bytes = decoder.decodeBuffer(imgdata);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            // 生成jpeg图片
            OutputStream out = new FileOutputStream("a.png");
            out.write(bytes);
            out.flush();
            out.close();
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
}
