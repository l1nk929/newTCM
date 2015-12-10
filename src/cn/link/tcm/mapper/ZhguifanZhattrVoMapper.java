package cn.link.tcm.mapper;

import cn.link.tcm.po.ZhguifanZhattrVo;
import cn.link.tcm.po.Zhguifan_Zhattr;


public interface ZhguifanZhattrVoMapper {

	public ZhguifanZhattrVo findZhguifanZhattrVoById(int id);

	public void deleteZhguifanZhattrVo(ZhguifanZhattrVo vo);
	
	public void addZhguifanZhattrVo(ZhguifanZhattrVo vo);

	public void deleteZhguifanZhattrById(Zhguifan_Zhattr zhguifan_Zhattr);

	public Zhguifan_Zhattr findZhguifanZhattrById(Zhguifan_Zhattr zhguifan_Zhattr);

	public void addZhguifanZhattrById(Zhguifan_Zhattr zhguifan_Zhattr);
}
