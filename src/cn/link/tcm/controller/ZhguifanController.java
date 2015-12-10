package cn.link.tcm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.link.tcm.po.Source;
import cn.link.tcm.po.ZhallZhguifanVo;
import cn.link.tcm.po.Zhguifan;
import cn.link.tcm.po.Zzall;
import cn.link.tcm.po.ZzallPageVo;
import cn.link.tcm.po.ZzallZzguifanVo;
import cn.link.tcm.po.Zzguifan;
import cn.link.tcm.service.ZhguifanService;
import cn.link.tcm.service.ZzallService;
import cn.link.tcm.service.ZzguifanService;


@Controller
public class ZhguifanController {

	@Autowired
	private ZhguifanService  zhguifanService;
	
	
	
	@RequestMapping(value="/zhcenter")
	public String findZhall(int zhallid,Model model,HttpSession session){
		ZhallZhguifanVo zhallZhguifanVo = zhguifanService.findZhallZhguifanVoById(zhallid);
		Source source = zhguifanService.findSourceByZhallZhguifanVo(zhallZhguifanVo);
		model.addAttribute("source", source);
		model.addAttribute("zhallZhguifanVo", zhallZhguifanVo);
		return "zhcenterReal";
		
	}
	@RequestMapping(value="/findZhguifan")
	public String findZhguifan(String zhenghou_name,Model model){
		
		List<Zhguifan> zhguifanList = zhguifanService.findZhguifanByLikeName(zhenghou_name);
		model.addAttribute("zhguifanList", zhguifanList);
		System.out.println(zhguifanList.size());
		return "zhbleft";
		
	}
	
	@RequestMapping(value="/addZhguifan")
	public String addZhguifan(String zhenghou_name,Model model){
		
		
		zhguifanService.saveZhguifanByzhenghouname(zhenghou_name);
		
		return "zhbright";
		
	}
	@RequestMapping(value="/bindzhguifan")
	public String bindzhguifan(int zhid,String zhname,int zhallid,Model model){
		
		zhguifanService.saveZhallZhguifan(zhid, zhname,zhallid);
		
		return "redirect:zhcenter.action?zhallid="+zhallid;
	}
	
	@RequestMapping("/deleteZhguifan")
	public String deleteZhguifan(int zhallid,int zhguifanid,Model model){
		
		zhguifanService.deleteZhguifan(zhallid,zhguifanid);
		return "redirect:zhcenter.action?zhallid="+zhallid;
	}
}
