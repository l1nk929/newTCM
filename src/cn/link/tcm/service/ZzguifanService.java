package cn.link.tcm.service;

import java.util.List;

import cn.link.tcm.po.Source;
import cn.link.tcm.po.ZzallZzguifanVo;
import cn.link.tcm.po.Zzguifan;

public interface ZzguifanService {

	
	public ZzallZzguifanVo findZzallZzguifanVoById(int id);
	
	public List<Zzguifan> findZzguifanByLikeName(String zhengzhuang_name);
	
	public void saveZzguifanByzhengzhuangname(String zhengzhuang_name);
	
	public void saveZzallZzguifan(int id,String zhengzhuang_name,int zzallid);
	
	public Source findSourceByZzallZzguifanVo(ZzallZzguifanVo zzallZzguifanVo);

	public void deleteZzguifan(int zzallid, int zzguifanid);
	
}
