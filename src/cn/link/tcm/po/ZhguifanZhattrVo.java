package cn.link.tcm.po;

import java.util.List;

public class ZhguifanZhattrVo {

	private int id;
	private String zhenghou_name;
	
	private List<Zhattrall> list;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getZhenghou_name() {
		return zhenghou_name;
	}

	public void setZhenghou_name(String zhenghou_name) {
		this.zhenghou_name = zhenghou_name;
	}

	public List<Zhattrall> getList() {
		return list;
	}

	public void setList(List<Zhattrall> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "ZhguifanZhattrVo [id=" + id + ", zhenghou_name="
				+ zhenghou_name + ", list=" + list + "]";
	}

	
	
	
}
