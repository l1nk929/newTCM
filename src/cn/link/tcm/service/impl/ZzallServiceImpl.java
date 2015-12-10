package cn.link.tcm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.link.tcm.mapper.ZzallMapper;
import cn.link.tcm.po.Zzall;
import cn.link.tcm.po.ZzallPageVo;
import cn.link.tcm.service.ZzallService;

public class ZzallServiceImpl implements ZzallService {

	@Autowired
	private ZzallMapper zzallMapper;
	
	@Override
	public List<Zzall> findZzallByType(int type) {
		List<Zzall> tempList = new ArrayList<Zzall>();
		
		List<Zzall> list = zzallMapper.findAllZzall();
		for(Zzall zzall:list){
			if(zzall.getType()==type)
				tempList.add(zzall);
		}
		
		
		return tempList;
		
	}

	@Override
	public List<Zzall> findAllZzallByTypeAndPage(ZzallPageVo page) {
		List<Zzall> tempList = zzallMapper.findAllZzallByTypeAndPage(page);
		if(tempList.size()<page.getPage_total())
		{
			page.setNext(-1);
		}
		else{
			page.setNext(page.getPage_no()+page.getPage_total());
		}
		if(page.getPage_no()==0){
			page.setPrevious(-1);
		}
		else{
			if(page.getPage_no()<=page.getPage_total())
				page.setPrevious(0);
			else
				page.setPrevious(page.getPage_no()-page.getPage_total());
		}
		
		return tempList;
	}

	@Override
	public void updateTypeById(int zzallid, int type){
		Zzall zzall = zzallMapper.findZzallById(zzallid);
		if(zzall==null)
			return;
		System.out.println(zzall);
		zzall.setType(type);
		zzallMapper.updateZzallType(zzall);
		System.out.println(zzall);
		return;
	}

}
