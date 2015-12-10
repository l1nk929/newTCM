package cn.link.tcm.po;

import java.util.List;

public class ZhallZhguifanVo {

	private int id;
	private String zhenghou_name;
	private int source_id;
	private int type;
	
	private List<Zhguifan> list;

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

	public List<Zhguifan> getList() {
		return list;
	}

	public void setList(List<Zhguifan> list) {
		this.list = list;
	}

	
	
	
}
