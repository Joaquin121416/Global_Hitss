package com.example.demo.tdo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;

public class DataBean {

	private int id;
	private String nombre;
	
	@Column(name = "fec_registro")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date fec_registro;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFec_registro() {
		return fec_registro;
	}

	public void setFec_registro(Date fec_registro) {
		this.fec_registro = fec_registro;
	}

}