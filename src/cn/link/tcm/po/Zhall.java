package cn.link.tcm.po;

public class Zhall {

	private int id;
	private String zhenghou_name;
	private int source_id;
	private int type;
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
		return "Zhall [id=" + id + ", zhenghou_name=" + zhenghou_name
				+ ", source_id=" + source_id + ", type=" + type + "]";
	}
	
	
	
}
