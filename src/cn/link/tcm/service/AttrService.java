package cn.link.tcm.service;

import java.util.List;

import cn.link.tcm.po.Attrall;
import cn.link.tcm.po.AttrallLevel;
import cn.link.tcm.po.AttrallListVo;
import cn.link.tcm.po.BindSelectVo;
import cn.link.tcm.po.ZzguifanAttrVo;

public interface AttrService {

	public ZzguifanAttrVo findZzguifanAttrVoById(int id);
	
	public List<AttrallListVo> findParentsByAttrall(List<Attrall> list);

	public AttrallLevel getAttrallLevel();

	public void deleteAttrallByid(int zzguifanid, int attrid);

	public void bindAttr(BindSelectVo bindSelectVo);

	public void addAttr(BindSelectVo bindSelectVo);
}
