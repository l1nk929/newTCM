package cn.link.tcm.service;

import java.util.List;

import cn.link.tcm.po.Zhall;
import cn.link.tcm.po.ZhallPageVo;
import cn.link.tcm.po.Zzall;
import cn.link.tcm.po.ZzallPageVo;

public interface ZhallService {

	public List<Zhall> findZhallByType(int type);
	
	public List<Zhall> findAllZhallByTypeAndPage(ZhallPageVo page);

	public void updateTypeById(int zhallid, int type);
}
