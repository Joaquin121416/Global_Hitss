package com.example.demo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.fn.SPBuscar;
import com.example.demo.fn.SPCrear;
import com.example.demo.tdo.DataBean;

@Repository
public class DataDao {
	@Autowired
	DataSource dataSource;

	@Autowired
	SPCrear spCrear;

	@Autowired
	SPBuscar spBuscar;

	public List<DataBean> select() {
		return spBuscar.execute();
	}

	public Long insert(DataBean bean) {
		return spCrear.execute(bean);
	}
}
