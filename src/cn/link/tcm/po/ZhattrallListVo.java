package cn.link.tcm.po;

import java.util.List;

public class ZhattrallListVo {

	private Zhattrall now;
	private List<Zhattrall> parents;
	public Zhattrall getNow() {
		return now;
	}
	public void setNow(Zhattrall now) {
		this.now = now;
	}
	public List<Zhattrall> getParents() {
		return parents;
	}
	public void setParents(List<Zhattrall> parents) {
		this.parents = parents;
	}
	@Override
	public String toString() {
		return "ZhattrallListVo [now=" + now + ", parents=" + parents + "]";
	}
	
	
	
}
