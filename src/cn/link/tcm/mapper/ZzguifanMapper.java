package cn.link.tcm.mapper;

import java.util.List;

import cn.link.tcm.po.Zzguifan;

public interface ZzguifanMapper {

	public List<Zzguifan> findAllZzguifan();
	
	public Zzguifan findZzguifanById(int id);
	
	public void addZzguifan(Zzguifan zzguifan);
	
	public void updateZzguifanZhengzhuangName(Zzguifan zzguifan);
	
	public void deleteZzguifanById(int id);
}
