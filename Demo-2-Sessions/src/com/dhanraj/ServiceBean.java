package com.dhanraj;

public class ServiceBean {

	private String serno;
	private String sname;
	private String from;
	private String to;
	private String depature;
	private String arrival;
	private String availibity;
	
	public ServiceBean() {
		//0-param constructor;
	}
	
	public ServiceBean(String serno,String sname, String from, String to, String depature, String arrival, String availibity) {
		this.serno = serno;
		this.sname = sname;
		this.from = from;
		this.to = to;
		this.depature = depature;
		this.arrival = arrival;
		this.availibity = availibity;
	}
	
	public String getSerno() {
		return serno;
	}
	
	public void setSerno(String serno) {
		this.serno = serno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getDepature() {
		return depature;
	}
	public void setDepature(String depature) {
		this.depature = depature;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getAvailibity() {
		return availibity;
	}
	public void setAvailibity(String availibity) {
		this.availibity = availibity;
	}
	
	@Override
	public String toString() {
		return "ServiceBean [serno=" + serno + ", sname=" + sname + ", from=" + from + ", to=" + to + ", depature="
				+ depature + ", arrival=" + arrival + ", availibity=" + availibity + "]";
	}
	
	
	
}
