package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.NurseDTO;
import model.Nurse;
import service.NurseService;

@RestController
@RequestMapping(value = "api/nurses")
public class NurseController {

	@Autowired
	private NurseService nurseService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<NurseDTO>> getAllNurses(){
		List<Nurse> nurses = nurseService.findAll();
		
		List<NurseDTO> nursesDTO = new ArrayList<>();
		for(Nurse nurse : nurses) {
			nursesDTO.add(new NurseDTO(nurse));
		}
		return new ResponseEntity<>(nursesDTO, HttpStatus.OK);
	}
	
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<NurseDTO> saveNurse(@RequestBody NurseDTO nurseDTO){
		
		Nurse nurse = new Nurse();
		nurse.setId(nurseDTO.getId());
		nurse.setName(nurseDTO.getFirstName());
		nurse.setLastname(nurseDTO.getLastName());
		nurse.setEmail(nurseDTO.getEmail());
		nurse.setClinic(nurseDTO.getClinic());
		
		nurse = nurseService.save(nurse);
		return new ResponseEntity<>(new NurseDTO(nurse), HttpStatus.CREATED);
	}
}
