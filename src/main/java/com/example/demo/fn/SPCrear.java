package com.example.demo.fn;

import static java.sql.Types.BIGINT;
import static java.sql.Types.TIMESTAMP;
import static java.sql.Types.VARCHAR;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Component;

import com.example.demo.tdo.DataBean;

@Component
public class SPCrear extends StoredProcedure {

	private Logger logger = LoggerFactory.getLogger(SPCrear.class);

	private static final String SPROC_NAME = "sp_crear";
	
	private static final String P_NOMBRE = "p_nombre";
	private static final String P_FEC_REGISTRO = "p_fec_registro";

	private static final String R_RESULT = "R_RESULT";

	@Autowired
	public SPCrear(DataSource datasource) {
		super(datasource, SPROC_NAME);
		logger.debug("datasource={}", datasource);
		
		declareParameter(new SqlParameter(P_NOMBRE, VARCHAR));
		declareParameter(new SqlParameter(P_FEC_REGISTRO, TIMESTAMP));

		declareParameter(new SqlOutParameter(R_RESULT, BIGINT));

		compile();
	}

	public Long execute( //
			DataBean bean //
	) {
		logger.trace("execute()");
		Map<String, Object> input = new HashMap<>();
		
		input.put(P_NOMBRE, bean.getNombre());
		input.put(P_FEC_REGISTRO, bean.getFec_registro());

		logger.debug("input={}", input);
		Map<String, Object> results = super.execute(input);
		logger.debug("results={}", results);

		return (Long) results.get(R_RESULT);
	}

}
