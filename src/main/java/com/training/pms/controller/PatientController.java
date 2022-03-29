package com.training.pms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.training.pms.model.Patient;

import com.training.pms.repositories.PatientRepository;



@RestController
//used at method or class level
@RequestMapping("patient")
public class PatientController {
	
	@Autowired
	PatientRepository patientRepo;
	
	
	@GetMapping
	public ResponseEntity<List<Patient>> getPatients() { //localhost:5050/patient   -GET
//		
		List<Patient> allPatients = (List<Patient>)patientRepo.findAll();
		return new ResponseEntity<List<Patient>>(allPatients, HttpStatus.OK);
//		List<Patient> result = patientServ.getPatients();
//		ResponseEntity<List<Patient>> responseEntity = null;
//		if(result.size()==0) {
//			responseEntity = new ResponseEntity<List<Patient>>(result, HttpStatus.NO_CONTENT);
//			
//		}else {
//			responseEntity = new ResponseEntity<List<Patient>>(result, HttpStatus.OK);
//		}
//		return responseEntity;
	}
	
	@GetMapping("{patientId}")
	public ResponseEntity<Patient> getPatient(@PathVariable("patientId") int patientId) { //localhost:5050/patient   -GET
		Optional<Patient> patient = patientRepo.findById(patientId);
		return new ResponseEntity<Patient>(patient.get(), HttpStatus.OK);
	}
	
//	@GetMapping("SearchPatientByName/{patientName}")
//	public ResponseEntity<List<Patient>> getPatientByName(@PathVariable("patientName")String pName) { //localhost:5050/patient   -GET
//		
//		
//		
////		List<Patient> result = patientServ.getPatients();
////		ResponseEntity<List<Patient>> responseEntity = null;
////		if(result.size()==0) {
////			responseEntity = new ResponseEntity<List<Patient>>(result, HttpStatus.NO_CONTENT);
////			
////		}else {
////			responseEntity = new ResponseEntity<List<Patient>>(result, HttpStatus.OK);
////		}
////		return responseEntity;
//	}
	
//	@GetMapping("filterPatientByPrice/{lowerPrice}/{higherPrice}")
//	public String getPatientByPrices(@PathVariable("lowerPrice")int price1, @PathVariable("higherPrice")int price2) { //localhost:5050/product   -GET
//		return "Searching all products between : " + price1 + " and " + price2;
//	}
	
//	@GetMapping("{productId}")
//	public ResponseEntity<Patient> getSinglePatient(@PathVariable("patientId") int patientId) {     //localhost:5050/product/single   -GET
//		ResponseEntity<Patient> responseEntity = null;
//		Patient patient = new Patient();
//		if(patientServ.isPatientExists(patientId)) {
//			patient = patientServ.getPatient(patientId);
//			responseEntity = new ResponseEntity<Patient>(patient, HttpStatus.OK);//200
//			
//		}else {
//			
//			responseEntity = new ResponseEntity<Patient>(patient, HttpStatus.NO_CONTENT);//304
//		}
//		return responseEntity;
//	}
	
	@PostMapping
	public ResponseEntity<String> savePatient(@RequestBody Patient patient) {     //localhost:5050/product   -Post
		patientRepo.save(patient);
		return new ResponseEntity<String>("Patient saved sucessfully", HttpStatus.CREATED);
		
//		ResponseEntity<String> responseEntity = null;
//		String result = null;
//		if(patientServ.isPatientExists(patient.getId())) {
//			result = "Patient with patient ID : " + patient.getId() + "Already exists";
//			responseEntity = new ResponseEntity<String>(result, HttpStatus.OK);
//		}else {
//			result = patientServ.addPatient(patient);
//			responseEntity = new ResponseEntity<String>(result, HttpStatus.CREATED);
//		}
//		return responseEntity;
	}
	
	@PutMapping("{patientId}")
	public ResponseEntity<String> updatePatient(@PathVariable("patientId") int patientId, @RequestBody Patient patient) {    //localhost:5050/product   -Put
		patientRepo.save(patient);
		return new ResponseEntity<String>("Patient updated sucessfully", HttpStatus.OK);
		
//		ResponseEntity<String> responseEntity = null;
//		String result = null;
//		if (patientServ.isPatientExists(patient.getId())) {
//			result = patientServ.updatePatient(patientId, patient);
//			responseEntity = new ResponseEntity<String>(result, HttpStatus.OK);// 200
//		} else {
//			result = "Patient with patient id :" + patient.getId() + " does not exists";
//			responseEntity = new ResponseEntity<String>(result, HttpStatus.NOT_MODIFIED); // 304
//		}
//		return responseEntity;
	}

	
	@DeleteMapping("{patientId}")
	public ResponseEntity<String> deletePatient(@PathVariable("id")int patientId) {    //localhost:5050/product   -Delete
		patientRepo.deleteById(patientId);
		return new ResponseEntity<String>("Patient deleted sucessfully", HttpStatus.OK);
	}
	
}

