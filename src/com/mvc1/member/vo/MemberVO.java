package com.mvc1.member.vo;

public class MemberVO {

	//초기화
	private String Knum;
	private String Kname;
	private String Kid;
	private String Kpw;
	private String Kbirth;
	private String Kgender;
	private String Kemail;
	private String Kmobile;
	private String Kpostnum;
	private String Kaddr;
	private String Kdeleteyn;
	private String Kinsertdate;
	private String Kupdatedate;
	
	public MemberVO(String Knum, String Kname, String Kid, String Kpw, String Kbirth, String Kgender,
			String Kemail, String Kmobile, String Kpostnum, String Kaddr, String Kdeleteyn, String Kinsertdate,
			String Kupdatedate) {
		super();
		this.Knum = Knum;
		this.Kname = Kname;
		this.Kid = Kid;
		this.Kpw = Kpw;
		this.Kbirth = Kbirth;
		this.Kgender = Kgender;
		this.Kemail = Kemail;
		this.Kmobile = Kmobile;
		this.Kpostnum = Kpostnum;
		this.Kaddr = Kaddr;
		this.Kdeleteyn = Kdeleteyn;
		this.Kinsertdate = Kinsertdate;
		this.Kupdatedate = Kupdatedate;
	}
	public MemberVO() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UesrVO [Knum=" + Knum + ", Kname=" + Kname + ", Kid=" + Kid + ", Kpw=" + Kpw + ", Kbirth="
				+ Kbirth + ", Kgender=" + Kgender + ", Kemail=" + Kemail + ", Kmobile=" + Kmobile
				+ ", Kpostnum=" + Kpostnum + ", Kaddr=" + Kaddr + ", Kdeleteyn=" + Kdeleteyn + ", Kinsertdate="
				+ Kinsertdate + ", Kupdatedate=" + Kupdatedate + "]";
	}
	public String getKnum() {
		return Knum;
	}
	public void setKnum(String Knum) {
		this.Knum = Knum;
	}
	public String getKname() {
		return Kname;
	}
	public void setKname(String Kname) {
		this.Kname = Kname;
	}
	public String getKid() {
		return Kid;
	}
	public void setKid(String Kid) {
		this.Kid = Kid;
	}
	public String getKpw() {
		return Kpw;
	}
	public void setKpw(String Kpw) {
		this.Kpw = Kpw;
	}
	public String getKbirth() {
		return Kbirth;
	}
	public void setKbirth(String Kbirth) {
		this.Kbirth = Kbirth;
	}
	public String getKgender() {
		return Kgender;
	}
	public void setKgender(String Kgender) {
		this.Kgender = Kgender;
	}
	public String getKemail() {
		return Kemail;
	}
	public void setKemail(String Kemail) {
		this.Kemail = Kemail;
	}
	public String getKmobile() {
		return Kmobile;
	}
	public void setKmobile(String Kmobile) {
		this.Kmobile = Kmobile;
	}
	public String getKpostnum() {
		return Kpostnum;
	}
	public void setKpostnum(String Kpostnum) {
		this.Kpostnum = Kpostnum;
	}
	public String getKaddr() {
		return Kaddr;
	}
	public void setKaddr(String Kaddr) {
		this.Kaddr = Kaddr;
	}
	public String getKdeleteyn() {
		return Kdeleteyn;
	}
	public void setKdeleteyn(String Kdeleteyn) {
		this.Kdeleteyn = Kdeleteyn;
	}
	public String getKinsertdate() {
		return Kinsertdate;
	}
	public void setKinsertdate(String Kinsertdate) {
		this.Kinsertdate = Kinsertdate;
	}
	public String getKupdatedate() {
		return Kupdatedate;
	}
	public void setKupdatedate(String Kupdatedate) {
		this.Kupdatedate = Kupdatedate;
	}
	
	
	
}
