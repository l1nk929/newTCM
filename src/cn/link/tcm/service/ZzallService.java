package cn.link.tcm.service;

import java.util.List;

import cn.link.tcm.po.Zzall;
import cn.link.tcm.po.ZzallPageVo;

public interface ZzallService {

	public List<Zzall> findZzallByType(int type);
	
	public List<Zzall> findAllZzallByTypeAndPage(ZzallPageVo page);

	public void updateTypeById(int zzallid, int type);
}
