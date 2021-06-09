package com.example.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.domain.AccountVO;
import com.example.domain.Criteria;
import com.example.domain.TradeVO;
import com.example.mapper.AccountMapper;
import com.example.mapper.MysqlMapper;
import com.example.mapper.TradeMapper;
import com.example.service.TradeService;



@RunWith(SpringJUnit4ClassRunner.class) 
//먼저 SpringJUnit4ClassRunner.class import한다. 

@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MysqlTest {
	 @Autowired
	 private AccountMapper mapper;
	 
	 @Autowired
	 private TradeService service;
	 
	 @Autowired
	 private TradeMapper tMapper;
	 
	 @Test
	 public void trade(){
		 TradeVO vo = new TradeVO();
		 vo.setAno("A001");
		 vo.setTradeNo("A002");
		 vo.setAmount(20);
		 service.insert(vo);
	 }
	 
	@Test
	public void list(){
		Criteria cri = new Criteria();
		cri.setPerPageNum(5);
		tMapper.list("A002",cri);
	}
	
	@Test
	public void read(){
		mapper.read("A002");
	}
	
	@Test
	public void insert(){
		AccountVO vo = new AccountVO();
		vo.setAno("A004");
		vo.setAname("김수지");
		vo.setBalance(400);
		mapper.insert(vo);
	}
}
