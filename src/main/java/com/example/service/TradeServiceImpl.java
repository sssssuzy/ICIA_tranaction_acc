package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.TradeVO;
import com.example.mapper.AccountMapper;
import com.example.mapper.TradeMapper;

@Service
public class TradeServiceImpl implements TradeService {

	@Autowired
	TradeMapper mapper;
	
	@Autowired
	AccountMapper aMapper;
	
	@Transactional
	@Override
	public void insert(TradeVO vo) {
		//출금
		String ano=vo.getAno(); //보낸 사람
		String tradeNo = vo.getTradeNo(); //받는사람
		vo.setType("출금");
		mapper.insert(vo);
		aMapper.updateBalance(ano, (vo.getAmount() * -1));
		
		//입금
		vo.setAno(tradeNo); //받은사람
		vo.setTradeNo(ano); //보낸사람
		vo.setType("입금");
		mapper.insert(vo);
		aMapper.updateBalance(tradeNo, vo.getAmount());
	
	}

	@Override
	public List<TradeVO> list(String ano) {
		// TODO Auto-generated method stub
		return null;
	}

}
