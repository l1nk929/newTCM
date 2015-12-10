package cn.link.tcm.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;

import cn.link.tcm.mapper.AttrallMapper;
import cn.link.tcm.mapper.ZzguifanAttrVoMapper;
import cn.link.tcm.po.Attrall;
import cn.link.tcm.po.AttrallLevel;
import cn.link.tcm.po.AttrallListVo;
import cn.link.tcm.po.BindSelectVo;
import cn.link.tcm.po.ZzguifanAttrVo;
import cn.link.tcm.po.Zzguifan_Attr;
import cn.link.tcm.service.AttrService;

public class AttrServiceImpl implements AttrService{

	@Autowired
	private ZzguifanAttrVoMapper zzguifanAttrVoMapper;
	
	@Autowired
	private AttrallMapper attrallMapper;
	
	@Override
	public ZzguifanAttrVo findZzguifanAttrVoById(int id) {
		
		
		return zzguifanAttrVoMapper.findZzguifanAttrVoById(id);
	}

	@Override
	public List<AttrallListVo> findParentsByAttrall(List<Attrall> list) {
		
		List<AttrallListVo> tempList = new ArrayList<AttrallListVo>();
		for (Attrall attr : list) {
			AttrallListVo attrallListVo = new AttrallListVo();
			attrallListVo.setParents(new ArrayList<Attrall>());
			attrallListVo.setNow(attr);
			Attrall tempAttr = attr;
			while(tempAttr.getLevel()!=1){
				Attrall parentAttr = attrallMapper.findAttrallById(tempAttr.getParent_id());
				attrallListVo.getParents().add(0, parentAttr);
				tempAttr =parentAttr;
				
				
			}
			tempList.add(attrallListVo);
		}
		
		
		return tempList;
	}

	@Override
	public AttrallLevel getAttrallLevel() {
		AttrallLevel attrallLevel = new AttrallLevel();
		List<Attrall> allList = attrallMapper.findAllAttrall();
		attrallLevel.setAttr_name("root");
		attrallLevel.setCode(0);
		attrallLevel.setSub(new ArrayList<AttrallLevel>());
		HashMap<Integer, AttrallLevel> map = new HashMap<Integer, AttrallLevel>();
		for(Attrall attrall:allList){
				AttrallLevel tempAttrallLevel = new AttrallLevel();
				tempAttrallLevel.setAttr_name(attrall.getAttr_name());
				tempAttrallLevel.setCode(attrall.getId());
				tempAttrallLevel.setSub(new ArrayList<AttrallLevel>());
				map.put(attrall.getId(), tempAttrallLevel);
		}
		for(Attrall attrall:allList){
			if(attrall.getParent_id()==0){
				attrallLevel.getSub().add(map.get(attrall.getId()));
			}else{
				map.get(attrall.getParent_id()).getSub().add(map.get(attrall.getId()));
			}
		}
	
		
		return attrallLevel;
	}

	@Override
	public void deleteAttrallByid(int zzguifanid, int attrid) {
		Zzguifan_Attr zzguifan_Attr = new Zzguifan_Attr();
		zzguifan_Attr.setZzguifan_id(zzguifanid);
		zzguifan_Attr.setAttr_id(attrid);
		
		zzguifanAttrVoMapper.deleteZzguifanAttrById(zzguifan_Attr);
		return;
		
	}

	@Override
	public void bindAttr(BindSelectVo bindSelectVo) {
		int attr_id = 0;
		if(bindSelectVo.getBl1()!=0){
			attr_id = bindSelectVo.getBl1();
		}
		if(bindSelectVo.getBl2()!=0){
			attr_id = bindSelectVo.getBl2();
		}
		if(bindSelectVo.getBl3()!=0){
			attr_id = bindSelectVo.getBl3();
		}
		if(bindSelectVo.getBl4()!=0){
			attr_id = bindSelectVo.getBl4();
		}
		if(bindSelectVo.getBl5()!=0){
			attr_id = bindSelectVo.getBl5();
		}
		if(bindSelectVo.getBl6()!=0){
			attr_id = bindSelectVo.getBl6();
		}
		if(bindSelectVo.getBl7()!=0){
			attr_id = bindSelectVo.getBl7();
		}
		Zzguifan_Attr zzguifan_Attr = new Zzguifan_Attr();
		zzguifan_Attr.setAttr_id(attr_id);
		zzguifan_Attr.setZzguifan_id(bindSelectVo.getZzguifanid());
		System.out.println(bindSelectVo);
		System.out.println(zzguifan_Attr);
		Zzguifan_Attr result = zzguifanAttrVoMapper.findZzguifanAttrById(zzguifan_Attr);
		System.out.println(result);
		if(result==null)
			zzguifanAttrVoMapper.addZzguifanAttrById(zzguifan_Attr);
		return;
		
	}

	@Override
	public void addAttr(BindSelectVo bindSelectVo) {
		int attr_id = 0;
		if(bindSelectVo.getBl1()!=0){
			attr_id = bindSelectVo.getBl1();
		}
		if(bindSelectVo.getBl2()!=0){
			attr_id = bindSelectVo.getBl2();
		}
		if(bindSelectVo.getBl3()!=0){
			attr_id = bindSelectVo.getBl3();
		}
		if(bindSelectVo.getBl4()!=0){
			attr_id = bindSelectVo.getBl4();
		}
		if(bindSelectVo.getBl5()!=0){
			attr_id = bindSelectVo.getBl5();
		}
		if(bindSelectVo.getBl6()!=0){
			attr_id = bindSelectVo.getBl6();
		}
		if(bindSelectVo.getBl7()!=0){
			attr_id = bindSelectVo.getBl7();
		}
		Attrall attrall = new Attrall();
		attrall.setAttr_dependency(" ÷π§");
		attrall.setAttr_name(bindSelectVo.getAttr_name());
		if(attr_id!=0){
			Attrall parent = attrallMapper.findAttrallById(attr_id);
			attrall.setLevel(parent.getLevel()+1);
			attrall.setParent_id(parent.getId());
			attrallMapper.addAttrall(attrall);
		}else{
			attrall.setLevel(1);
			attrallMapper.addAttrallWithNullParent(attrall);
		}
		
		
		
		
		
		
		return;
		
	}

	
}
