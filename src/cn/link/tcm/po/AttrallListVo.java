package cn.link.tcm.po;

import java.util.List;

public class AttrallListVo {

	private Attrall now;
	private List<Attrall> parents;
	public Attrall getNow() {
		return now;
	}
	public void setNow(Attrall now) {
		this.now = now;
	}
	public List<Attrall> getParents() {
		return parents;
	}
	public void setParents(List<Attrall> parents) {
		this.parents = parents;
	}
	@Override
	public String toString() {
		return "AttrallListVo [now=" + now + ", parents=" + parents + "]";
	}
	
	
}
