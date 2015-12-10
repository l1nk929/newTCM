package cn.link.tcm.po;

public class Zhguifan {

	private int id;
	private String zhenghou_name;
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Zhguifan [id=" + id + ", zhenghou_name=" + zhenghou_name
				+ ", type=" + type + "]";
	}
	
	
	
}
