package cn.link.tcm.po;

public class Zhall_Zhguifan {

	private int zhall_id;
	private int zhguifan_id;
	private int id;
	private int type;
	public int getZhall_id() {
		return zhall_id;
	}
	public void setZhall_id(int zhall_id) {
		this.zhall_id = zhall_id;
	}
	public int getZhguifan_id() {
		return zhguifan_id;
	}
	public void setZhguifan_id(int zhguifan_id) {
		this.zhguifan_id = zhguifan_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Zhall_Zhguifan [zhall_id=" + zhall_id + ", zhguifan_id="
				+ zhguifan_id + ", id=" + id + ", type=" + type + "]";
	}
	
	
}
