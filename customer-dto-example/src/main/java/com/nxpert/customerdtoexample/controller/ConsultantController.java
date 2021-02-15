package com.nxpert.customerdtoexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nxpert.customerdtoexample.dto.ConsultantDto;
import com.nxpert.customerdtoexample.model.Consultant;
import com.nxpert.customerdtoexample.service.ConsultantService;

@RestController
@RequestMapping("/consultant")
public class ConsultantController {

	@Autowired
	ConsultantService service;

	@GetMapping("/search")
	public Page<ConsultantDto> search(Pageable pageable,
			@RequestParam(name = "searchText", value = "", required = false) String searchText) {
		return service.search(pageable, searchText);
	}

	@GetMapping
	public Page<ConsultantDto> readAll(Pageable pageable) {
		return service.readAll(pageable);
	}
	
	@GetMapping("/{id}")
	public Consultant read(@PathVariable Integer id) {
		return service.read(id).orElse(null);
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Consultant request) {
		return new ResponseEntity<Consultant>(service.create(request), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody Consultant request) {
		if (null == request.getId()) {
			return new ResponseEntity<Exception>(new Exception("Invalid Customer"), HttpStatus.BAD_GATEWAY);
		}
		return new ResponseEntity<Consultant>(service.update(request), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}