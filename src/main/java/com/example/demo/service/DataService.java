package com.example.demo.service;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.DataDao;
import com.example.demo.tdo.DataBean;

@Service
public class DataService {

	@Autowired
	private DataDao dataDao;

	@Transactional(propagation = REQUIRED)
	public Long registrar(DataBean bean) {
		return dataDao.insert(bean);
	}

	@Transactional(propagation = REQUIRED)
	public List<DataBean> buscar() {
		return dataDao.select();
	}
}