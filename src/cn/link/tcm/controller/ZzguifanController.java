package cn.link.tcm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.link.tcm.po.Source;
import cn.link.tcm.po.Zzall;
import cn.link.tcm.po.ZzallPageVo;
import cn.link.tcm.po.ZzallZzguifanVo;
import cn.link.tcm.po.Zzguifan;
import cn.link.tcm.service.ZzallService;
import cn.link.tcm.service.ZzguifanService;


@Controller
public class ZzguifanController {

	@Autowired
	private ZzguifanService  zzguifanService;
	
	
	
	@RequestMapping(value="/center")
	public String findZzall(int zzallid,Model model,HttpSession session){
		ZzallZzguifanVo zzallZzguifanVo = zzguifanService.findZzallZzguifanVoById(zzallid);
		Source source = zzguifanService.findSourceByZzallZzguifanVo(zzallZzguifanVo);
		model.addAttribute("source", source);
		model.addAttribute("zzallZzguifanVo", zzallZzguifanVo);
		return "centerReal";
		
	}
	@RequestMapping(value="/findZzguifan")
	public String findZzguifan(String zhengzhuang_name,Model model){
		
		List<Zzguifan> zzguifanList = zzguifanService.findZzguifanByLikeName(zhengzhuang_name);
		model.addAttribute("zzguifanList", zzguifanList);
		System.out.println(zzguifanList.size());
		return "bleft";
		
	}
	
	@RequestMapping(value="/addZzguifan")
	public String addZzguifan(String zhengzhuang_name,Model model){
		
		
		zzguifanService.saveZzguifanByzhengzhuangname(zhengzhuang_name);
		
		return "bright";
		
	}
	@RequestMapping(value="/bindzzguifan")
	public String bindzzguifan(int zzid,String zzname,int zzallid,Model model){
		
		zzguifanService.saveZzallZzguifan(zzid, zzname,zzallid);
		
		return "redirect:center.action?zzallid="+zzallid;
	}
	
	@RequestMapping("/deleteZzguifan")
	public String deleteZzguifan(int zzallid,int zzguifanid,Model model){
		
		zzguifanService.deleteZzguifan(zzallid,zzguifanid);
		return "redirect:center.action?zzallid="+zzallid;
	}
}
