package cn.link.tcm.mapper;

import cn.link.tcm.po.ZzguifanAttrVo;
import cn.link.tcm.po.Zzguifan_Attr;


public interface ZzguifanAttrVoMapper {

	public ZzguifanAttrVo findZzguifanAttrVoById(int id);

	public void deleteZzguifanAttrVo(ZzguifanAttrVo vo);
	
	public void addZzguifanAttrVo(ZzguifanAttrVo vo);

	public void deleteZzguifanAttrById(Zzguifan_Attr zzguifan_Attr);

	public Zzguifan_Attr findZzguifanAttrById(Zzguifan_Attr zzguifan_Attr);

	public void addZzguifanAttrById(Zzguifan_Attr zzguifan_Attr);
}
