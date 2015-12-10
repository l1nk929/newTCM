package cn.link.tcm.mapper;

import java.util.List;

import cn.link.tcm.po.Attrall;

public interface AttrallMapper {

	/**
	 * private int id;
	private String attr_name;
	private String attr_dependency;
	private int parent_id;
	private String code;
	private int level;
	 */
	
	public Attrall findAttrallById(int id);
	
	public void addAttrall(Attrall attrall);
	
	public List<Attrall> findAttrsByParentId(int id);

	public List<Attrall> findAllAttrall();

	public void addAttrallWithNullParent(Attrall attrall);

	
}
