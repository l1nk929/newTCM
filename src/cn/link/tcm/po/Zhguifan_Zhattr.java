package cn.link.tcm.po;

public class Zhguifan_Zhattr {

	private int zhguifan_id;
	private int zhattr_id;
	private int id;
	private int type;
	public int getZhguifan_id() {
		return zhguifan_id;
	}
	public void setZhguifan_id(int zhguifan_id) {
		this.zhguifan_id = zhguifan_id;
	}
	public int getZhattr_id() {
		return zhattr_id;
	}
	public void setZhattr_id(int zhattr_id) {
		this.zhattr_id = zhattr_id;
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
		return "Zhguifan_Zhattr [zhguifan_id=" + zhguifan_id + ", zhattr_id="
				+ zhattr_id + ", id=" + id + ", type=" + type + "]";
	}
	
	
}
