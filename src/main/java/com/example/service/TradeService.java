package com.example.service;

import java.util.List;

import com.example.domain.TradeVO;

public interface TradeService {
	public void insert(TradeVO vo);
	public List<TradeVO> list(String ano);
}
