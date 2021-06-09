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
		//���
		String ano=vo.getAno(); //���� ���
		String tradeNo = vo.getTradeNo(); //�޴»��
		vo.setType("���");
		mapper.insert(vo);
		aMapper.updateBalance(ano, (vo.getAmount() * -1));
		
		//�Ա�
		vo.setAno(tradeNo); //�������
		vo.setTradeNo(ano); //�������
		vo.setType("�Ա�");
		mapper.insert(vo);
		aMapper.updateBalance(tradeNo, vo.getAmount());
	
	}

	@Override
	public List<TradeVO> list(String ano) {
		// TODO Auto-generated method stub
		return null;
	}

}
