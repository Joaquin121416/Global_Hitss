package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DataService;
import com.example.demo.tdo.DataBean;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private DataService dataService;

	@PostMapping("/registrar")
	public Long registrar(@RequestBody DataBean bean) {
		return dataService.registrar(bean);
	}

	@GetMapping("/buscar")
	public List<DataBean> buscar() {
		return dataService.buscar();
	}
}