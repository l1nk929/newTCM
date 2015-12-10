package cn.link.tcm.po;

public class Attrall {

	private int id;
	private String attr_name;
	private String attr_dependency;
	private int parent_id;
	private String code;
	private int level;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAttr_name() {
		return attr_name;
	}
	public void setAttr_name(String attr_name) {
		this.attr_name = attr_name;
	}
	public String getAttr_dependency() {
		return attr_dependency;
	}
	public void setAttr_dependency(String attr_dependency) {
		this.attr_dependency = attr_dependency;
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
		return "Attrall [id=" + id + ", attr_name=" + attr_name + ", attr_dependency=" + attr_dependency
				+ ", parent_id=" + parent_id + ", code=" + code + ", level=" + level + "]";
	}
	
	
}
