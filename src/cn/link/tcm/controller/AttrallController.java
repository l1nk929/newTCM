package cn.link.tcm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.link.tcm.po.Attrall;
import cn.link.tcm.po.AttrallLevel;
import cn.link.tcm.po.AttrallListVo;
import cn.link.tcm.po.BindSelectVo;
import cn.link.tcm.po.Zzall;
import cn.link.tcm.po.ZzallPageVo;
import cn.link.tcm.po.ZzallZzguifanVo;
import cn.link.tcm.po.ZzguifanAttrVo;
import cn.link.tcm.service.AttrService;
import cn.link.tcm.service.ZzallService;
import cn.link.tcm.service.ZzguifanService;


@Controller
public class AttrallController {

	
	@Autowired
	private AttrService attrService;
	
	@RequestMapping(value="/right")
	public String findZzall(int zzguifanid,Model model,HttpSession session){
		
		ZzguifanAttrVo zzguifanAttrVo = attrService.findZzguifanAttrVoById(zzguifanid);
		
		List<AttrallListVo> attrallVoList  = attrService.findParentsByAttrall(zzguifanAttrVo.getList());
		
		model.addAttribute("attrallVoList", attrallVoList);
		model.addAttribute("zzguifanAttrVo", zzguifanAttrVo);
		System.out.println(attrallVoList);
		
		return "rightReal";
		
	}
	@RequestMapping("/requestAttrJson")
	public @ResponseBody List<AttrallLevel> requestAttrJson(){
		AttrallLevel attrallLevel = attrService.getAttrallLevel();
		
		return attrallLevel.getSub();
		
	}
	
	@RequestMapping("/deleteAttrall")
	public String deleteAttrall(int zzguifanid,int attrid,Model model){
		
		attrService.deleteAttrallByid(zzguifanid,attrid);
		return "redirect:right.action?zzguifanid="+zzguifanid;
	}
	
	@RequestMapping("/bindAttrall")
	public String bindAttrall(BindSelectVo bindSelectVo,Model model){
		
		/**
		 * BindSelectVo [bl1=1, bl2=101, bl3=-1, bl4=0, bl5=0, bl6=0, bl7=0, zzguifanid=6, level=1, attr_name=, action=1]
		 */
		//绑定操作
		System.out.println(bindSelectVo);
		if(bindSelectVo.getAction()==1){
			attrService.bindAttr(bindSelectVo);
		}//添加操作
		else if(bindSelectVo.getAction()==2){
			attrService.addAttr(bindSelectVo);
		}
		return "redirect:right.action?zzguifanid="+bindSelectVo.getZzguifanid();
	}
}
