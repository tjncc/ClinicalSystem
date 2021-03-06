package com.example.ClinicalSystem.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.ClinicalSystem.model.Clinic;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic, Long> {

	Clinic save(Clinic clinic);
	List<Clinic> findAllByOrderByNameAsc();
	List<Clinic> findAll();
	Clinic findByName(String name);
	List<Clinic> findByAdress(String adress);



}
