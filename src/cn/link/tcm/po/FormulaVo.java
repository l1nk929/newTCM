package cn.link.tcm.po;

public class FormulaVo {

	private int id;
	private String source_detail;
	private int source_id;
	private String zhifadetail;
	private String formula_detail;
	
	private int zhall_id;
	private int zzall_id;
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
	public int getZhall_id() {
		return zhall_id;
	}
	public void setZhall_id(int zhall_id) {
		this.zhall_id = zhall_id;
	}
	public int getZzall_id() {
		return zzall_id;
	}
	public void setZzall_id(int zzall_id) {
		this.zzall_id = zzall_id;
	}
	@Override
	public String toString() {
		return "FormulaVo [id=" + id + ", source_detail=" + source_detail
				+ ", source_id=" + source_id + ", zhifadetail=" + zhifadetail
				+ ", formula_detail=" + formula_detail + ", zhall_id="
				+ zhall_id + ", zzall_id=" + zzall_id + "]";
	}
	
	
}
