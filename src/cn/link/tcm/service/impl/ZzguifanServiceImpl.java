package cn.link.tcm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.link.tcm.mapper.SourceMapper;
import cn.link.tcm.mapper.ZzallZzguifanVoMapper;
import cn.link.tcm.mapper.ZzguifanMapper;
import cn.link.tcm.po.Source;
import cn.link.tcm.po.ZzallZzguifanVo;
import cn.link.tcm.po.Zzall_Zzguifan;
import cn.link.tcm.po.Zzguifan;
import cn.link.tcm.service.ZzguifanService;

public class ZzguifanServiceImpl implements ZzguifanService {

	@Autowired
	private ZzallZzguifanVoMapper  zzallZzguifanVoMapper;
	@Autowired
	private ZzguifanMapper zzguifanMapper;
	@Autowired
	private SourceMapper sourceMapper;
	
	@Override
	public ZzallZzguifanVo findZzallZzguifanVoById(int id) {
		
		return zzallZzguifanVoMapper.findZzallZzguifanVoById(id);
	}

	@Override
	public List<Zzguifan> findZzguifanByLikeName(String zhengzhuang_name) {
		
		List<Zzguifan> tempList = new ArrayList<Zzguifan>();
		List<Zzguifan> list = zzguifanMapper.findAllZzguifan();
		
		for(Zzguifan zzguifan:list){
			if(zzguifan.getZhengzhuang_name().contains(zhengzhuang_name))
				tempList.add(zzguifan);
		}
		
		
		return tempList;
	}

	@Override
	public void saveZzguifanByzhengzhuangname(String zhengzhuang_name) {
		zhengzhuang_name = zhengzhuang_name.trim();
		List<Zzguifan> list = zzguifanMapper.findAllZzguifan();
		for(Zzguifan zzguifan:list){
			if(zzguifan.getZhengzhuang_name().equals(zhengzhuang_name))
				return;
		}
		Zzguifan zzguifan = new Zzguifan();
		zzguifan.setZhengzhuang_name(zhengzhuang_name);
		zzguifanMapper.addZzguifan(zzguifan);
		return;
		
	}

	@Override
	public void saveZzallZzguifan(int id, String zhengzhuang_name,int zzallid) {
		Zzguifan zzguifan = zzguifanMapper.findZzguifanById(id);
		System.out.println("-----------------------------");
		if(zzguifan==null)
			return;
		System.out.println(zzguifan);
		System.out.println(zhengzhuang_name);
		if(!zzguifan.getZhengzhuang_name().equals(zhengzhuang_name))
			return;
		
		ZzallZzguifanVo zzallZzguifanVo = zzallZzguifanVoMapper.findZzallZzguifanVoById(zzallid);
		
		System.out.println(zzallZzguifanVo);
		zzallZzguifanVoMapper.deleteZzallZzguifanVo(zzallZzguifanVo);
		zzallZzguifanVo.getList().add(zzguifan);
		zzallZzguifanVoMapper.addZzallZzguifanVo(zzallZzguifanVo);
			return;
	}

	@Override
	public Source findSourceByZzallZzguifanVo(ZzallZzguifanVo zzallZzguifanVo) {
		
		return sourceMapper.findSourceById(zzallZzguifanVo.getSource_id());
	}

	@Override
	public void deleteZzguifan(int zzallid, int zzguifanid) {
		Zzall_Zzguifan zzall_Zzguifan = new Zzall_Zzguifan();
		zzall_Zzguifan.setZzall_id(zzallid);
		zzall_Zzguifan.setZzguifan_id(zzguifanid);
		zzallZzguifanVoMapper.deleteByZzallIdZzguifanId(zzall_Zzguifan);
		return;
	}
	
	

}
