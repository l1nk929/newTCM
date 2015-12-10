package cn.link.tcm.po;

import java.util.List;

public class ZzguifanAttrVo {

	private int id;
	private String zhengzhuang_name;
	
	private List<Attrall> list;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getZhengzhuang_name() {
		return zhengzhuang_name;
	}

	public void setZhengzhuang_name(String zhengzhuang_name) {
		this.zhengzhuang_name = zhengzhuang_name;
	}

	public List<Attrall> getList() {
		return list;
	}

	public void setList(List<Attrall> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "ZzguifanAttrVo [id=" + id + ", zhengzhuang_name="
				+ zhengzhuang_name + ", list=" + list + "]";
	}
	
	
}
