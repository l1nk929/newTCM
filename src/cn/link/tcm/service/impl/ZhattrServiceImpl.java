package cn.link.tcm.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;

import cn.link.tcm.mapper.AttrallMapper;
import cn.link.tcm.mapper.ZhattrallMapper;
import cn.link.tcm.mapper.ZhguifanZhattrVoMapper;
import cn.link.tcm.mapper.ZzguifanAttrVoMapper;
import cn.link.tcm.po.Attrall;
import cn.link.tcm.po.AttrallLevel;
import cn.link.tcm.po.AttrallListVo;
import cn.link.tcm.po.BindSelectVo;
import cn.link.tcm.po.ZhBindSelectVo;
import cn.link.tcm.po.Zhattrall;
import cn.link.tcm.po.ZhattrallLevel;
import cn.link.tcm.po.ZhattrallListVo;
import cn.link.tcm.po.ZhguifanZhattrVo;
import cn.link.tcm.po.Zhguifan_Zhattr;
import cn.link.tcm.po.ZzguifanAttrVo;
import cn.link.tcm.po.Zzguifan_Attr;
import cn.link.tcm.service.AttrService;
import cn.link.tcm.service.ZhattrService;

public class ZhattrServiceImpl implements ZhattrService{

	@Autowired
	private ZhguifanZhattrVoMapper zhguifanZhattrVoMapper;
	
	@Autowired
	private ZhattrallMapper zhattrallMapper;
	
	@Override
	public ZhguifanZhattrVo findZhguifanZhattrVoById(int id) {
		
		
		return zhguifanZhattrVoMapper.findZhguifanZhattrVoById(id);
	}

	@Override
	public List<ZhattrallListVo> findParentsByZhattrall(List<Zhattrall> list) {
		
		List<ZhattrallListVo> tempList = new ArrayList<ZhattrallListVo>();
		for (Zhattrall zhattr : list) {
			ZhattrallListVo zhattrallListVo = new ZhattrallListVo();
			zhattrallListVo.setParents(new ArrayList<Zhattrall>());
			zhattrallListVo.setNow(zhattr);
			Zhattrall tempzhattr = zhattr;
			while(tempzhattr.getLevel()!=1){
				Zhattrall parentZhattr = zhattrallMapper.findZhattrallById(tempzhattr.getParent_id());
				zhattrallListVo.getParents().add(0, parentZhattr);
				tempzhattr =parentZhattr;
				
				
			}
			tempList.add(zhattrallListVo);
		}
		
		
		return tempList;
	}

	@Override
	public ZhattrallLevel getZhattrallLevel() {
		ZhattrallLevel zhattrallLevel = new ZhattrallLevel();
		List<Zhattrall> allList = zhattrallMapper.findAllZhattrall();
		zhattrallLevel.setZhattr_name("root");
		zhattrallLevel.setCode(0);
		zhattrallLevel.setSub(new ArrayList<ZhattrallLevel>());
		HashMap<Integer, ZhattrallLevel> map = new HashMap<Integer, ZhattrallLevel>();
		for(Zhattrall zhattrall:allList){
				ZhattrallLevel tempZhattrallLevel = new ZhattrallLevel();
				tempZhattrallLevel.setZhattr_name(zhattrall.getZhattr_name());
				tempZhattrallLevel.setCode(zhattrall.getId());
				tempZhattrallLevel.setSub(new ArrayList<ZhattrallLevel>());
				map.put(zhattrall.getId(), tempZhattrallLevel);
		}
		for(Zhattrall zhattrall:allList){
			if(zhattrall.getParent_id()==0){
				zhattrallLevel.getSub().add(map.get(zhattrall.getId()));
			}else{
				map.get(zhattrall.getParent_id()).getSub().add(map.get(zhattrall.getId()));
			}
		}
	
		
		return zhattrallLevel;
	}

	@Override
	public void deleteZhattrallByid(int zhguifanid, int zhattrid) {
		Zhguifan_Zhattr zhguifan_Zhattr = new Zhguifan_Zhattr();
		zhguifan_Zhattr.setZhguifan_id(zhguifanid);
		zhguifan_Zhattr.setZhattr_id(zhattrid);
		
		zhguifanZhattrVoMapper.deleteZhguifanZhattrById(zhguifan_Zhattr);
		return;
		
	}

	@Override
	public void bindZhattr(ZhBindSelectVo zhbindSelectVo) {
		int zhattr_id = 0;
		if(zhbindSelectVo.getBl1()!=0){
			zhattr_id = zhbindSelectVo.getBl1();
		}
		if(zhbindSelectVo.getBl2()!=0){
			zhattr_id = zhbindSelectVo.getBl2();
		}
		if(zhbindSelectVo.getBl3()!=0){
			zhattr_id = zhbindSelectVo.getBl3();
		}
		if(zhbindSelectVo.getBl4()!=0){
			zhattr_id = zhbindSelectVo.getBl4();
		}
		if(zhbindSelectVo.getBl5()!=0){
			zhattr_id = zhbindSelectVo.getBl5();
		}
		if(zhbindSelectVo.getBl6()!=0){
			zhattr_id = zhbindSelectVo.getBl6();
		}
		if(zhbindSelectVo.getBl7()!=0){
			zhattr_id = zhbindSelectVo.getBl7();
		}
		Zhguifan_Zhattr zhguifan_Zhattr = new Zhguifan_Zhattr();
		zhguifan_Zhattr.setZhattr_id(zhattr_id);
		zhguifan_Zhattr.setZhguifan_id(zhbindSelectVo.getZhguifanid());
		System.out.println(zhbindSelectVo);
		System.out.println(zhguifan_Zhattr);
		Zhguifan_Zhattr result = zhguifanZhattrVoMapper.findZhguifanZhattrById(zhguifan_Zhattr);
		System.out.println(result);
		if(result==null)
			zhguifanZhattrVoMapper.addZhguifanZhattrById(zhguifan_Zhattr);
		return;
		
	}

	@Override
	public void addZhattr(ZhBindSelectVo zhbindSelectVo) {
		int zhattr_id = 0;
		if(zhbindSelectVo.getBl1()!=0){
			zhattr_id = zhbindSelectVo.getBl1();
		}
		if(zhbindSelectVo.getBl2()!=0){
			zhattr_id = zhbindSelectVo.getBl2();
		}
		if(zhbindSelectVo.getBl3()!=0){
			zhattr_id = zhbindSelectVo.getBl3();
		}
		if(zhbindSelectVo.getBl4()!=0){
			zhattr_id = zhbindSelectVo.getBl4();
		}
		if(zhbindSelectVo.getBl5()!=0){
			zhattr_id = zhbindSelectVo.getBl5();
		}
		if(zhbindSelectVo.getBl6()!=0){
			zhattr_id = zhbindSelectVo.getBl6();
		}
		if(zhbindSelectVo.getBl7()!=0){
			zhattr_id = zhbindSelectVo.getBl7();
		}
		Zhattrall zhattrall = new Zhattrall();
		zhattrall.setZhattr_dependency(" ÷π§");
		zhattrall.setZhattr_name(zhbindSelectVo.getZhattr_name());
		if(zhattr_id!=0){
			Zhattrall parent = zhattrallMapper.findZhattrallById(zhattr_id);
			zhattrall.setLevel(parent.getLevel()+1);
			zhattrall.setParent_id(parent.getId());
			zhattrallMapper.addZhattrall(zhattrall);
		}else{
			zhattrall.setLevel(1);
			zhattrallMapper.addZhattrallWithNullParent(zhattrall);
		}
		
		
		
		
		
		
		return;
		
	}

	
}
