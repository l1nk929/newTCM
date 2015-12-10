package cn.link.tcm.service;

import java.util.List;

import cn.link.tcm.po.Attrall;
import cn.link.tcm.po.AttrallLevel;
import cn.link.tcm.po.AttrallListVo;
import cn.link.tcm.po.BindSelectVo;
import cn.link.tcm.po.ZhBindSelectVo;
import cn.link.tcm.po.Zhattrall;
import cn.link.tcm.po.ZhattrallLevel;
import cn.link.tcm.po.ZhattrallListVo;
import cn.link.tcm.po.ZhguifanZhattrVo;
import cn.link.tcm.po.ZzguifanAttrVo;

public interface ZhattrService {

	public ZhguifanZhattrVo findZhguifanZhattrVoById(int id);
	
	public List<ZhattrallListVo> findParentsByZhattrall(List<Zhattrall> list);

	public ZhattrallLevel getZhattrallLevel();

	public void deleteZhattrallByid(int zhguifanid, int zhattrid);

	public void bindZhattr(ZhBindSelectVo ZhBindSelectVo);

	public void addZhattr(ZhBindSelectVo ZhBindSelectVo);
}
