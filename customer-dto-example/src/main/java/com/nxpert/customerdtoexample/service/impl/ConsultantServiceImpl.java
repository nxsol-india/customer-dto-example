package com.nxpert.customerdtoexample.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nxpert.customerdtoexample.dto.ConsultantDto;
import com.nxpert.customerdtoexample.mapper.ModelToDto;
import com.nxpert.customerdtoexample.model.Consultant;
import com.nxpert.customerdtoexample.repository.ConsultantRepository;
import com.nxpert.customerdtoexample.service.ConsultantService;

@Service
public class ConsultantServiceImpl implements ConsultantService {

	@Autowired
	ConsultantRepository repository;

	@Override
	public Page<ConsultantDto> search(Pageable pageable, String searchText) {
		String queriableText = new StringBuilder("%").append(searchText).append("%").toString();
		Page<Consultant> consultant = repository.search(pageable, queriableText);
		ModelToDto modelToDto = new ModelToDto();
		return modelToDto.convertModelToDtoConsultatn_PageCounsultantDto(consultant);
	}

	@Override
	public Page<ConsultantDto> readAll(Pageable pageable) {
		Page<Consultant> listOfCustomer = repository.findAll(pageable);
		ModelToDto modelToDto = new ModelToDto();
		return modelToDto.convertModelToDtoConsultatn_PageCounsultantDto(listOfCustomer);

	}

	@Override
	public Optional<Consultant> read(Integer id) {
		return repository.findById(id);
	}

	@Override
	public Consultant create(Consultant request) {
		return repository.save(request);
	}

	@Override
	public Consultant update(Consultant request) {
		return repository.save(request);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		
		repository.deleteById(id);
	}

}
