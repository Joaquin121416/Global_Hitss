package com.example.demo.fn.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.tdo.DataBean;

public class BeanDemo implements RowMapper<DataBean> {

	@Override
	public DataBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		DataBean dataBean = new DataBean();
		int i = 1;

		dataBean.setId(rs.getInt(i++));
		dataBean.setNombre(rs.getString(i++));
		dataBean.setFec_registro(rs.getObject(i++, Timestamp.class));

		return dataBean;
	}

}