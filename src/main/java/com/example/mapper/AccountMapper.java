package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.domain.AccountVO;
import com.example.domain.Criteria;

public interface AccountMapper {
	public List<AccountVO> list(Criteria cri);
	public AccountVO read(String ano);
	public void insert(AccountVO vo);
	public int totalCount();
	public List<AccountVO> listAll();
	public void updateBalance(@Param("ano") String ano,@Param("amount") double amount);
}
