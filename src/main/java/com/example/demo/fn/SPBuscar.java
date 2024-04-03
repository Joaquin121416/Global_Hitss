package com.example.demo.fn;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Component;

import com.example.demo.fn.mapper.BeanDemo;
import com.example.demo.tdo.DataBean;

@Component
public class SPBuscar extends StoredProcedure {

	private Logger logger = LoggerFactory.getLogger(SPBuscar.class);

	private static final String SPROC_NAME = "sp_buscar";
	private static final String R_RESULT = "R_RESULT";

	@Autowired
	public SPBuscar(DataSource datasource) {
		super(datasource, SPROC_NAME);
		logger.debug("datasource={}", datasource);
		declareParameter(new SqlOutParameter(R_RESULT, Types.OTHER, new BeanDemo()));
		compile();
	}

	@SuppressWarnings("unchecked")
	public List<DataBean> execute() {
		logger.trace("execute()");

		Map<String, Object> results = super.execute();
		logger.debug("results={}", results);

		return (List<DataBean>) results.get(R_RESULT);
	}

}
