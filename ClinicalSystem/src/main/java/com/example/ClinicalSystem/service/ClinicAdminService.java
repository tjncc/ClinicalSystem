package com.example.ClinicalSystem.service;

import java.util.ArrayList;
import java.util.List;

import com.example.ClinicalSystem.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ClinicalSystem.DTO.ClinicAdminDTO;
import com.example.ClinicalSystem.DTO.ClinicDTO;
import com.example.ClinicalSystem.repository.ClinicAdminRepository;

@Service
public class ClinicAdminService {


	@Autowired
	private ClinicAdminRepository clinicAdminRepository;
	
	@Autowired 
	private ModelMapper modelMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthorityService authorityService;

	public List<ClinicAdminDTO> findAll() {
		List<ClinicAdmin> clinicAdmins = clinicAdminRepository.findAll();

		List<ClinicAdminDTO> clinicAdminsDTO = new ArrayList<>();
		for (ClinicAdmin c : clinicAdmins) {
			clinicAdminsDTO.add(new ClinicAdminDTO(c));
		}
		
		return clinicAdminsDTO;
	}

	public ClinicAdmin save(ClinicAdminDTO clinicAdminDto) {
		
		ClinicAdmin clinicAdmin = modelMapper.map(clinicAdminDto, ClinicAdmin.class);
		clinicAdmin.setPassword(passwordEncoder.encode(clinicAdmin.getPassword()));

		Authority authoritie = authorityService.findByname("CLINICADMIN");
		List<Authority> authorities = new ArrayList<>();
		authorities.add(authoritie);
		clinicAdmin.setAuthorities(authorities);
		
		return clinicAdminRepository.save(clinicAdmin);
	}

	public ClinicAdmin findByEmail(String email) {
		return clinicAdminRepository.findByEmail(email);
	}
	
	

}
