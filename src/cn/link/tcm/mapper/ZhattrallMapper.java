package cn.link.tcm.mapper;

import java.util.List;

import cn.link.tcm.po.Attrall;
import cn.link.tcm.po.Zhattrall;

public interface ZhattrallMapper {

	/**
	 * private int id;
	private String zhattr_name;
	private String zhattr_dependency;
	private int parent_id;
	private String code;
	private int level;
	 */
	
	public Zhattrall findZhattrallById(int id);
	
	public void addZhattrall(Zhattrall zhattrall);
	
	public List<Zhattrall> findZhattrsByParentId(int id);

	public List<Zhattrall> findAllZhattrall();

	public void addZhattrallWithNullParent(Zhattrall zhattrall);

	
}
