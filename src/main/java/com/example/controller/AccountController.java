package com.example.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.Criteria;
import com.example.domain.PageMaker;
import com.example.domain.TradeVO;
import com.example.mapper.AccountMapper;
import com.example.mapper.TradeMapper;
import com.example.service.TradeService;

@Controller
public class AccountController {
		@Autowired
		AccountMapper mapper;
		
		@Autowired
		TradeMapper tMapper;
		
		@Autowired
		TradeService service;
		
		@RequestMapping("list")
		public String list(Model model,Criteria cri){
			//��� ���
			cri.setPerPageNum(2);
			
			//����¡ ���ֱ�
			PageMaker pm = new PageMaker();
			pm.setCri(cri);
			pm.setTotalCount(mapper.totalCount());
			
			model.addAttribute("pm",pm);
			model.addAttribute("cri",cri);
			model.addAttribute("list",mapper.list(cri));
			return "list";
		}
		
		//��ü�ϱ�
		@RequestMapping(value="trade", method=RequestMethod.POST)
		@ResponseBody //�������� ���� �� �׳� ������ ó���� �ϰ������ ���
		public void trade(TradeVO vo){
			service.insert(vo);
		}
		
		@RequestMapping("read")
		public String read(String ano,Model model){
			model.addAttribute("vo",mapper.read(ano));
			model.addAttribute("list",mapper.listAll());
			return "read";
		}
		
		//��ü�������
		@RequestMapping("tradeList")
		@ResponseBody
		public HashMap<String,Object> tradeList(String ano,Criteria cri){
			HashMap<String,Object> map = new HashMap<String,Object>();
			cri.setPerPageNum(5);
			PageMaker pm = new PageMaker();
			pm.setCri(cri);
			pm.setTotalCount(tMapper.totalCount(ano));
			
			map.put("pm",pm);
			map.put("cri", cri);
			map.put("list", tMapper.list(ano, cri));
			
			return map;
		}

}
