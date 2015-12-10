package cn.link.tcm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.link.tcm.po.Zzall;
import cn.link.tcm.po.ZzallPageVo;
import cn.link.tcm.service.ZzallService;


@Controller
public class ZzallController {

	@Autowired
	private ZzallService zzallService;
	
	@RequestMapping(value="/left")
	public String findZzall(ZzallPageVo pageVo,Model model,HttpSession session){
		System.out.println(pageVo);
		List<Zzall> zzallList =  zzallService.findAllZzallByTypeAndPage(pageVo);
		System.out.println(zzallList.size());
		System.out.println(pageVo);
		model.addAttribute("zzallList", zzallList);
		model.addAttribute("pageVo", pageVo);
		return "leftReal";
		
	}
	
	@RequestMapping("/changeType")
	public String changeType(Model model,int type,int zzallid){
		
		
		System.out.println(type+"------------"+zzallid);
		zzallService.updateTypeById(zzallid,type);
		return "success";
	}
}
