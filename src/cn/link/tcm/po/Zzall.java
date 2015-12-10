package cn.link.tcm.po;

public class Zzall {

	private int id;
	private String zhengzhuang_name;
	private int source_id;
	private int type;
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
	@Override
	public String toString() {
		return "Zzall [id=" + id + ", zhengzhuang_name=" + zhengzhuang_name
				+ ", source_id=" + source_id + ", type=" + type + "]";
	}
	
	
}
