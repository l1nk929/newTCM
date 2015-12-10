package cn.link.tcm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.link.tcm.service.ZzallService;

@Controller()
public class Testcontroller {

	@Autowired
	private ZzallService zzallService;
	
	
	@RequestMapping("/index.action")
	public String index()throws Exception{
		return "index";
	}
	
}
