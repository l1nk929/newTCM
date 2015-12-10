package cn.link.tcm.po;

import java.util.List;

public class ZzallZzguifanVo {

	private int id;
	private String zhengzhuang_name;
	private int source_id;
	private int type;
	
	private List<Zzguifan> list;

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

	public int getSource_id() {
		return source_id;
	}

	public void setSource_id(int source_id) {
		this.source_id = source_id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<Zzguifan> getList() {
		return list;
	}

	public void setList(List<Zzguifan> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "ZzallZzguifanVo [id=" + id + ", zhengzhuang_name="
				+ zhengzhuang_name + ", source_id=" + source_id + ", type="
				+ type + ", list=" + list + "]";
	}
	
	
}
