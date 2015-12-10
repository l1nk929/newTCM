package cn.link.tcm.po;

public class Source {

	private int id;
	private String source_name;
	private String type;
	private int sub_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSource_name() {
		return source_name;
	}
	public void setSource_name(String source_name) {
		this.source_name = source_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSub_id() {
		return sub_id;
	}
	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}
	@Override
	public String toString() {
		return "source [id=" + id + ", source_name=" + source_name + ", type="
				+ type + ", sub_id=" + sub_id + "]";
	}
	
	
}
