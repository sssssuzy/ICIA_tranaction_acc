package com.example.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TradeVO extends AccountVO{
	private int tno;
	private String ano;
	private String type;
	private String tradeNo;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone="Asia/Seoul")
	private Date tradeDate;
	private double amount;
	
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	public Date getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "TradeVO [tno=" + tno + ", ano=" + ano + ", type=" + type + ", tradeNo=" + tradeNo + ", tradeDate="
				+ tradeDate + ", amount=" + amount + "]";
	}
	
}
