package cn.link.tcm.po;

import java.util.List;

public class ZhattrallLevel {

	private int code;
	private String zhattr_name;
	
	private List<ZhattrallLevel> sub;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getZhattr_name() {
		return zhattr_name;
	}

	public void setZhattr_name(String zhattr_name) {
		this.zhattr_name = zhattr_name;
	}

	public List<ZhattrallLevel> getSub() {
		return sub;
	}

	public void setSub(List<ZhattrallLevel> sub) {
		this.sub = sub;
	}

	@Override
	public String toString() {
		return "ZhattrallLevel [code=" + code + ", zhattr_name=" + zhattr_name
				+ ", sub=" + sub + "]";
	}
	

	
	
}
