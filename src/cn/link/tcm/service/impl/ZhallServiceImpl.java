package cn.link.tcm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.link.tcm.mapper.ZhallMapper;
import cn.link.tcm.mapper.ZzallMapper;
import cn.link.tcm.po.Zhall;
import cn.link.tcm.po.ZhallPageVo;
import cn.link.tcm.po.Zzall;
import cn.link.tcm.po.ZzallPageVo;
import cn.link.tcm.service.ZhallService;
import cn.link.tcm.service.ZzallService;

public class ZhallServiceImpl implements ZhallService {

	@Autowired
	private ZhallMapper zhallMapper;
	
	@Override
	public List<Zhall> findZhallByType(int type) {
		List<Zhall> tempList = new ArrayList<Zhall>();
		
		List<Zhall> list = zhallMapper.findAllZhall();
		for(Zhall zhall:list){
			if(zhall.getType()==type)
				tempList.add(zhall);
		}
		
		
		return tempList;
		
	}

	@Override
	public List<Zhall> findAllZhallByTypeAndPage(ZhallPageVo page) {
		List<Zhall> tempList = zhallMapper.findAllZhallByTypeAndPage(page);
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
	public void updateTypeById(int zhallid, int type){
		Zhall zhall = zhallMapper.findZhallById(zhallid);
		if(zhall==null)
			return;
		System.out.println(zhall);
		zhall.setType(type);
		zhallMapper.updateZhallType(zhall);
		System.out.println(zhall);
		return;
	}

}
