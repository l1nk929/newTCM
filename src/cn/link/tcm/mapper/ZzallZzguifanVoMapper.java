package cn.link.tcm.mapper;

import cn.link.tcm.po.ZzallZzguifanVo;
import cn.link.tcm.po.Zzall_Zzguifan;

public interface ZzallZzguifanVoMapper {

	public ZzallZzguifanVo findZzallZzguifanVoById(int id);
	
	public void deleteZzallZzguifanVo(ZzallZzguifanVo vo);
	
	public void addZzallZzguifanVo(ZzallZzguifanVo vo);

	public void deleteByZzallIdZzguifanId(Zzall_Zzguifan zz);
	
	//public void updateZzallZzguifanVo(ZzallZzguifanVo vo);
}
