package com.wlzx.action;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.wlzx.daoimpl.SelectStudentDaoImpl;


public class Select extends HttpServlet {

	public Select() {
		super();
	}

	public void destroy() {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		SelectStudentDaoImpl select = new SelectStudentDaoImpl();
		String studentNo = null;
		String weekString = null;
		studentNo = request.getParameter("studentNo");
		System.out.println(studentNo);
		weekString = request.getParameter("week");
		int week = Integer.parseInt(weekString);
		JSONArray array = select.selectStudent(studentNo, week);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		OutputStream out = null;
		try {
			out = response.getOutputStream();
			out.write(array.toString().getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	public void init() throws ServletException {
	}

}
