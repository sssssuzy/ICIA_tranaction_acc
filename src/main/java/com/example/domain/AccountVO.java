package com.example.domain;

import java.util.Date;

public class AccountVO {
	private String ano;
	private String aname;
	private Date openDate;
	private double balance;
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "AccountVO [ano=" + ano + ", aname=" + aname + ", openDate=" + openDate + ", balance=" + balance + "]";
	}
	
	
}
