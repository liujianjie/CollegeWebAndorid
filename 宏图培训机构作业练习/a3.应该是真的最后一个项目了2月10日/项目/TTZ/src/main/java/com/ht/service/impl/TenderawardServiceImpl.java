package com.ht.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.dao.TenderawardDao;
import com.ht.service.TenderawardService;
@Service
public class TenderawardServiceImpl implements TenderawardService{
	@Resource
	TenderawardDao ten;
}
