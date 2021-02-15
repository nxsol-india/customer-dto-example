package com.nxpert.customerdtoexample.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nxpert.customerdtoexample.dto.ConsultantDto;
import com.nxpert.customerdtoexample.model.Consultant;

public interface ConsultantService {

	Page<ConsultantDto> search(Pageable pageable, String searchText);

	Page<ConsultantDto> readAll(Pageable pageable);

	Consultant create(Consultant request);

	Consultant update(Consultant request);

	void delete(Integer id);

	Optional<Consultant> read(Integer id);


}
