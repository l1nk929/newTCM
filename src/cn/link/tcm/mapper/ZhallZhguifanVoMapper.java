package cn.link.tcm.mapper;

import cn.link.tcm.po.ZhallZhguifanVo;
import cn.link.tcm.po.Zhall_Zhguifan;
import cn.link.tcm.po.ZzallZzguifanVo;
import cn.link.tcm.po.Zzall_Zzguifan;

public interface ZhallZhguifanVoMapper {

	public ZhallZhguifanVo findZhallZhguifanVoById(int id);
	
	public void deleteZhallZhguifanVo(ZhallZhguifanVo vo);
	
	public void addZhallZhguifanVo(ZhallZhguifanVo vo);

	public void deleteByZhallIdZhguifanId(Zhall_Zhguifan zz);
	
	//public void updateZzallZzguifanVo(ZzallZzguifanVo vo);
}
