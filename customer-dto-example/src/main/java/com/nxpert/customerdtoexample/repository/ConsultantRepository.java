package com.nxpert.customerdtoexample.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nxpert.customerdtoexample.model.Consultant;
import com.nxpert.customerdtoexample.model.Customer;

@Repository
public interface ConsultantRepository extends JpaRepository<Consultant, Integer>{

	@Query(value="SELECT c from Consultant c where lower(c.name) like lower(?1)")
	Page<Consultant> search(Pageable pageable, String queriableText);
	
	@Query(value="SELECT  * FROM consultant c where c.id IN (\n" + 
			"SELECT cc.consultants_id FROM  customer_consultants cc where cc.customer_id  = ?1)",nativeQuery = true)
	Page<Consultant> readAllByCustomerId(Pageable pageable,Integer id);
	
	    @Modifying 
	    @Query(value = "DELETE FROM  customer_consultants c where c.consultants_id   =?1",nativeQuery = true) 
		int deleteConsultantId(Integer id); 



}
