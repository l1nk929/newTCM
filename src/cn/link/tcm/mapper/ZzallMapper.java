package cn.link.tcm.mapper;

import java.util.List;

import cn.link.tcm.po.Zzall;
import cn.link.tcm.po.ZzallPageVo;

public interface ZzallMapper {

	public Zzall findZzallById(int id);
	
	public List<Zzall> findAllZzall();
	
	public void updateZzallType(Zzall zzall);
	
	public List<Zzall> findAllZzallByTypeAndPage(ZzallPageVo page);

	
	
}
