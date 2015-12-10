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
import cn.link.tcm.po.ZhBindSelectVo;
import cn.link.tcm.po.ZhattrallLevel;
import cn.link.tcm.po.ZhattrallListVo;
import cn.link.tcm.po.ZhguifanZhattrVo;
import cn.link.tcm.po.Zzall;
import cn.link.tcm.po.ZzallPageVo;
import cn.link.tcm.po.ZzallZzguifanVo;
import cn.link.tcm.po.ZzguifanAttrVo;
import cn.link.tcm.service.AttrService;
import cn.link.tcm.service.ZhattrService;
import cn.link.tcm.service.ZzallService;
import cn.link.tcm.service.ZzguifanService;


@Controller
public class ZhattrallController {

	
	@Autowired
	private ZhattrService zhattrService;
	
	@RequestMapping(value="/zhright")
	public String findZhall(int zhguifanid,Model model,HttpSession session){
		
		ZhguifanZhattrVo zhguifanZhattrVo = zhattrService.findZhguifanZhattrVoById(zhguifanid);
		List<ZhattrallListVo> zhattrallVoList = null;
		if(zhguifanZhattrVo!=null){
			zhattrallVoList  = zhattrService.findParentsByZhattrall(zhguifanZhattrVo.getList());
		}
		
		
		model.addAttribute("zhattrallVoList", zhattrallVoList);
		model.addAttribute("zhguifanZhattrVo", zhguifanZhattrVo);
		
		return "zhrightReal";
		
	}
	@RequestMapping("/requestZhattrJson")
	public @ResponseBody List<ZhattrallLevel> requestZhattrJson(){
		ZhattrallLevel zhattrallLevel = zhattrService.getZhattrallLevel();
		
		return zhattrallLevel.getSub();
		
	}
	
	@RequestMapping("/deleteZhattrall")
	public String deleteZhattrall(int zhguifanid,int zhattrid,Model model){
		
		zhattrService.deleteZhattrallByid(zhguifanid,zhattrid);
		return "redirect:zhright.action?zhguifanid="+zhguifanid;
	}
	
	@RequestMapping("/bindZhattrall")
	public String bindZhattrall(ZhBindSelectVo zhbindSelectVo,Model model){
		
		/**
		 * BindSelectVo [bl1=1, bl2=101, bl3=-1, bl4=0, bl5=0, bl6=0, bl7=0, zzguifanid=6, level=1, attr_name=, action=1]
		 */
		//绑定操作
		System.out.println(zhbindSelectVo);
		if(zhbindSelectVo.getAction()==1){
			zhattrService.bindZhattr(zhbindSelectVo);
		}//添加操作
		else if(zhbindSelectVo.getAction()==2){
			zhattrService.addZhattr(zhbindSelectVo);
		}
		return "redirect:zhright.action?zhguifanid="+zhbindSelectVo.getZhguifanid();
	}
}
