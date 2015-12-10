package cn.link.tcm.mapper;

import java.util.List;

import cn.link.tcm.po.Zhguifan;
import cn.link.tcm.po.Zzguifan;

public interface ZhguifanMapper {

	public List<Zhguifan> findAllZhguifan();
	
	public Zhguifan findZhguifanById(int id);
	
	public void addZhguifan(Zhguifan zhguifan);
	
	public void updateZhguifanZhenghouName(Zhguifan zhguifan);
	
	public void deleteZhguifanById(int id);
}
