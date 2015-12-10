package cn.link.tcm.mapper;

import java.util.List;

import cn.link.tcm.po.Zhall;
import cn.link.tcm.po.ZhallPageVo;

public interface ZhallMapper {

	public void insertZhall(Zhall zhall);
	
	public Zhall findZhallById(int id);
	
	public List<Zhall> findAllZhall();
	
	public void updateZhallType(Zhall zhall);
	
	public List<Zhall> findAllZhallByTypeAndPage(ZhallPageVo page);

	
}
