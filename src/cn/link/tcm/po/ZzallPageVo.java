package cn.link.tcm.po;

public class ZzallPageVo {

	private static final int PAGE_TOTAL = 10;
	
	private int type;
	private int page_no;
	private int page_total;
	
	private int previous;
	private int next;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getPage_no() {
		return page_no;
	}
	public void setPage_no(int page_no) {
		this.page_no = page_no;
	}
	public int getPage_total() {
		return page_total;
	}
	public void setPage_total(int page_total) {
		this.page_total = page_total;
	}
	
	
	
	public int getPrevious() {
		return previous;
	}
	public void setPrevious(int previous) {
		this.previous = previous;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	public ZzallPageVo(int type, int page_no, int page_total) {
		super();
		this.type = type;
		this.page_no = page_no;
		this.page_total = PAGE_TOTAL;
	}
	
	public ZzallPageVo() {
		this.page_total = PAGE_TOTAL;
	}
	@Override
	public String toString() {
		return "ZzallPageVo [type=" + type + ", page_no=" + page_no
				+ ", page_total=" + page_total + ", previous=" + previous
				+ ", next=" + next + "]";
	}
	
	
	
	
	
	
	
}
