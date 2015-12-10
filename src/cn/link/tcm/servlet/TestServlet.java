package cn.link.tcm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import cn.link.tcm.service.ZzallService;

public class TestServlet extends HttpServlet{

	@Autowired
	private ZzallService zzallService;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
		int a = zzallService.findZzallByType(10).size();
		System.out.println("aaaaaaa"+a);
		resp.getWriter().write("a");
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	
}
