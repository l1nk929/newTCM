package cn.link.tcm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.link.tcm.po.Zhall;
import cn.link.tcm.po.ZhallPageVo;
import cn.link.tcm.po.Zzall;
import cn.link.tcm.po.ZzallPageVo;
import cn.link.tcm.service.ZhallService;
import cn.link.tcm.service.ZzallService;


@Controller
public class ZhallController {

	@Autowired
	private ZhallService zhallService;
	
	@RequestMapping(value="/zhleft")
	public String findZhall(ZhallPageVo pageVo,Model model,HttpSession session){
		System.out.println(pageVo);
		List<Zhall> zhallList =  zhallService.findAllZhallByTypeAndPage(pageVo);
		System.out.println(zhallList.size());
		System.out.println(pageVo);
		model.addAttribute("zhallList", zhallList);
		model.addAttribute("pageVo", pageVo);
		return "zhleftReal";
		
	}
	
	@RequestMapping("/zhchangeType")
	public String changeType(Model model,int type,int zhallid){
		
		
		System.out.println(type+"------------"+zhallid);
		zhallService.updateTypeById(zhallid,type);
		return "success";
	}
}
