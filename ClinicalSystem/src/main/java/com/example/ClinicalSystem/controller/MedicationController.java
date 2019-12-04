package com.example.ClinicalSystem.controller;

import com.example.ClinicalSystem.model.Medication;
import com.example.ClinicalSystem.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping(value = "api/medication")
public class MedicationController {

    @Autowired
    private MedicationService medicationService;

    @RequestMapping(method = RequestMethod.POST, value = "/addmedication")
    public ResponseEntity<Medication> addMedication(@RequestBody Medication medication) {

        medicationService.addMedication(medication);
        return new ResponseEntity<>(medication, HttpStatus.CREATED);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/allmedications")
    public ResponseEntity<List<Medication>> getAllMedication() {

        List<Medication> medications = medicationService.findAll();

        return new ResponseEntity<>(medications, HttpStatus.OK);
    }
}