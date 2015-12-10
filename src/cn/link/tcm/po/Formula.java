package cn.link.tcm.po;

public class Formula {

	private int id;
	private String source_detail;
	private int source_id;
	private String zhifadetail;
	private String formula_detail;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSource_detail() {
		return source_detail;
	}
	public void setSource_detail(String source_detail) {
		this.source_detail = source_detail;
	}
	public int getSource_id() {
		return source_id;
	}
	public void setSource_id(int source_id) {
		this.source_id = source_id;
	}
	public String getZhifadetail() {
		return zhifadetail;
	}
	public void setZhifadetail(String zhifadetail) {
		this.zhifadetail = zhifadetail;
	}
	public String getFormula_detail() {
		return formula_detail;
	}
	public void setFormula_detail(String formula_detail) {
		this.formula_detail = formula_detail;
	}
	@Override
	public String toString() {
		return "Formula [id=" + id + ", source_detail=" + source_detail
				+ ", source_id=" + source_id + ", zhifadetail=" + zhifadetail
				+ ", formula_detail=" + formula_detail + "]";
	}
	
	
	
}
