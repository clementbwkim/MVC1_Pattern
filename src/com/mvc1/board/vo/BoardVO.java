package com.mvc1.board.vo;

public class BoardVO {

	String kno;
	String ktitle;
	String kname;
	String kpw;
	String kcontent;
	String kdeleteyn;
	String kinsertdate;
	String kupdatedate;
	
	
	
	
	@Override
	public String toString() {
		return "BoardVO [kno=" + kno + ", ktitle=" + ktitle + ", kname=" + kname + ", kpw=" + kpw + ", kcontent="
				+ kcontent + ", kdeleteyn=" + kdeleteyn + ", kinsertdate=" + kinsertdate + ", kupdatedate="
				+ kupdatedate + "]";
	}
	public BoardVO(String kno, String ktitle, String kname, String kpw, String kcontent, String kdeleteyn,
			String kinsertdate, String kupdatedate) {
		super();
		this.kno = kno;
		this.ktitle = ktitle;
		this.kname = kname;
		this.kpw = kpw;
		this.kcontent = kcontent;
		this.kdeleteyn = kdeleteyn;
		this.kinsertdate = kinsertdate;
		this.kupdatedate = kupdatedate;
	}
	public BoardVO() {
		// TODO Auto-generated constructor stub
	}
	public String getKno() {
		return kno;
	}
	public void setKno(String kno) {
		this.kno = kno;
	}
	public String getKtitle() {
		return ktitle;
	}
	public void setKtitle(String ktitle) {
		this.ktitle = ktitle;
	}
	public String getKname() {
		return kname;
	}
	public void setKname(String kname) {
		this.kname = kname;
	}
	public String getKpw() {
		return kpw;
	}
	public void setKpw(String kpw) {
		this.kpw = kpw;
	}
	public String getKcontent() {
		return kcontent;
	}
	public void setKcontent(String kcontent) {
		this.kcontent = kcontent;
	}
	public String getKdeleteyn() {
		return kdeleteyn;
	}
	public void setKdeleteyn(String kdeleteyn) {
		this.kdeleteyn = kdeleteyn;
	}
	public String getKinsertdate() {
		return kinsertdate;
	}
	public void setKinsertdate(String kinsertdate) {
		this.kinsertdate = kinsertdate;
	}
	public String getKupdatedate() {
		return kupdatedate;
	}
	public void setKupdatedate(String kupdatedate) {
		this.kupdatedate = kupdatedate;
	}
	
	
	
}
