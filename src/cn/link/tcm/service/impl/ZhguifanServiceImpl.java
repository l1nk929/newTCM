package cn.link.tcm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.link.tcm.mapper.SourceMapper;
import cn.link.tcm.mapper.ZhallZhguifanVoMapper;
import cn.link.tcm.mapper.ZhguifanMapper;
import cn.link.tcm.mapper.ZzallZzguifanVoMapper;
import cn.link.tcm.mapper.ZzguifanMapper;
import cn.link.tcm.po.Source;
import cn.link.tcm.po.ZhallZhguifanVo;
import cn.link.tcm.po.Zhall_Zhguifan;
import cn.link.tcm.po.Zhguifan;
import cn.link.tcm.po.ZzallZzguifanVo;
import cn.link.tcm.po.Zzall_Zzguifan;
import cn.link.tcm.po.Zzguifan;
import cn.link.tcm.service.ZhguifanService;
import cn.link.tcm.service.ZzguifanService;

public class ZhguifanServiceImpl implements ZhguifanService {

	@Autowired
	private ZhallZhguifanVoMapper  zhallZhguifanVoMapper;
	@Autowired
	private ZhguifanMapper zhguifanMapper;
	@Autowired
	private SourceMapper sourceMapper;
	
	@Override
	public ZhallZhguifanVo findZhallZhguifanVoById(int id) {
		
		return zhallZhguifanVoMapper.findZhallZhguifanVoById(id);
	}

	@Override
	public List<Zhguifan> findZhguifanByLikeName(String zhenghou_name) {
		
		List<Zhguifan> tempList = new ArrayList<Zhguifan>();
		List<Zhguifan> list = zhguifanMapper.findAllZhguifan();
		
		for(Zhguifan zhguifan:list){
			if(zhguifan.getZhenghou_name().contains(zhenghou_name))
				tempList.add(zhguifan);
		}
		
		
		return tempList;
	}

	@Override
	public void saveZhguifanByzhenghouname(String zhenghou_name) {
		zhenghou_name = zhenghou_name.trim();
		List<Zhguifan> list = zhguifanMapper.findAllZhguifan();
		for(Zhguifan zhguifan:list){
			if(zhguifan.getZhenghou_name().equals(zhenghou_name))
				return;
		}
		Zhguifan zhguifan = new Zhguifan();
		zhguifan.setZhenghou_name(zhenghou_name);
		zhguifanMapper.addZhguifan(zhguifan);
		return;
		
	}

	@Override
	public void saveZhallZhguifan(int id, String zhenghou_name,int zhallid) {
		Zhguifan zhguifan = zhguifanMapper.findZhguifanById(id);
		System.out.println("-----------------------------");
		if(zhguifan==null)
			return;
		System.out.println(zhguifan);
		System.out.println(zhenghou_name);
		if(!zhguifan.getZhenghou_name().equals(zhenghou_name))
			return;
		
		ZhallZhguifanVo zhallZhguifanVo = zhallZhguifanVoMapper.findZhallZhguifanVoById(zhallid);
		
		System.out.println(zhallZhguifanVo);
		zhallZhguifanVoMapper.deleteZhallZhguifanVo(zhallZhguifanVo);
		zhallZhguifanVo.getList().add(zhguifan);
		zhallZhguifanVoMapper.addZhallZhguifanVo(zhallZhguifanVo);
			return;
	}

	@Override
	public Source findSourceByZhallZhguifanVo(ZhallZhguifanVo zhallZhguifanVo) {
		
		return sourceMapper.findSourceById(zhallZhguifanVo.getSource_id());
	}

	@Override
	public void deleteZhguifan(int zhallid, int zhguifanid) {
		Zhall_Zhguifan zhall_Zhguifan = new Zhall_Zhguifan();
		zhall_Zhguifan.setZhall_id(zhallid);
		zhall_Zhguifan.setZhguifan_id(zhguifanid);
		zhallZhguifanVoMapper.deleteByZhallIdZhguifanId(zhall_Zhguifan);
		return;
	}
	
	

}
