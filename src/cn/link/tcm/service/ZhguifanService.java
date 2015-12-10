package cn.link.tcm.service;

import java.util.List;

import cn.link.tcm.po.Source;
import cn.link.tcm.po.ZhallZhguifanVo;
import cn.link.tcm.po.Zhguifan;
import cn.link.tcm.po.ZzallZzguifanVo;
import cn.link.tcm.po.Zzguifan;

public interface ZhguifanService {

	
	public ZhallZhguifanVo findZhallZhguifanVoById(int id);
	
	public List<Zhguifan> findZhguifanByLikeName(String zhenghou_name);
	
	public void saveZhguifanByzhenghouname(String zhenghou_name);
	
	public void saveZhallZhguifan(int id,String zhenghou_name,int zhallid);
	
	public Source findSourceByZhallZhguifanVo(ZhallZhguifanVo zhallZhguifanVo);

	public void deleteZhguifan(int zhallid, int zhguifanid);
	
}
