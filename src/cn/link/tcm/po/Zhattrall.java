package cn.link.tcm.po;

public class Zhattrall {

	private int id;
	private String zhattr_name;
	private String zhattr_dependency;
	private int parent_id;
	private String code;
	private int level;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getZhattr_name() {
		return zhattr_name;
	}
	public void setZhattr_name(String zhattr_name) {
		this.zhattr_name = zhattr_name;
	}
	public String getZhattr_dependency() {
		return zhattr_dependency;
	}
	public void setZhattr_dependency(String zhattr_dependency) {
		this.zhattr_dependency = zhattr_dependency;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "Zhattrall [id=" + id + ", zhattr_name=" + zhattr_name
				+ ", zhattr_dependency=" + zhattr_dependency + ", parent_id="
				+ parent_id + ", code=" + code + ", level=" + level + "]";
	}
	
	
	
}
