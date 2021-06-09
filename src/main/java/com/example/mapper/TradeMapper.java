package com.example.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.domain.Criteria;
import com.example.domain.TradeVO;

public interface TradeMapper {
	public void insert(TradeVO vo);
	public List<TradeVO> list(@Param("ano") String ano,@Param("cri") Criteria cri);
	public int totalCount(String ano);
}
