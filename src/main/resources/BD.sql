CREATE TABLE data_bean (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255),
    fec_registro TIMESTAMP
);

CREATE OR REPLACE FUNCTION sp_crear(p_nombre IN VARCHAR, p_fec_registro IN TIMESTAMP)
RETURNS BIGINT
LANGUAGE plpgsql
AS $$
DECLARE
    inserted_id BIGINT;
BEGIN
    INSERT INTO data_bean (nombre, fec_registro) VALUES (p_nombre, p_fec_registro) RETURNING id INTO inserted_id;
    RETURN inserted_id;
END;
$$;


CREATE OR REPLACE FUNCTION public.sp_buscar()
  RETURNS refcursor AS
$BODY$
DECLARE
    v_ref refcursor;
BEGIN
    OPEN v_ref FOR 

	select * from data_bean;
	
    RETURN v_ref;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;