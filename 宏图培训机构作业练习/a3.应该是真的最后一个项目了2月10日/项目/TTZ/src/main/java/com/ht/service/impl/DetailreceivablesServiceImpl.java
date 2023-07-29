package com.ht.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.dao.DetailreceivablesDao;
import com.ht.service.DetailreceivablesService;
@Service
public class DetailreceivablesServiceImpl implements DetailreceivablesService{
	@Resource
	private DetailreceivablesDao drDao;
}
