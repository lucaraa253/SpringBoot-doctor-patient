package com.training.pms.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.pms.model.Patient;


@RestController
//used at method or class level
@RequestMapping("patient")
public class PatientController {
	
	
	@GetMapping
	public String getPatients() { //localhost:5050/patient   -GET
		return "Gettin all the patients";
	}
	
	@GetMapping("{patientId}")
	public String getPatient(@PathVariable("patientId") int patientId) { //localhost:5050/patient   -GET
		return "Getting a single patient by patient ID : " + patientId;
	}
	
	@GetMapping("SearchPatientByName/{patientName}")
	public String getPatientByName(@PathVariable("patientName")String pName) { //localhost:5050/patient   -GET
		return "Getting a single patient by patient Name : " + pName;
	}
	
//	@GetMapping("filterPatientByPrice/{lowerPrice}/{higherPrice}")
//	public String getPatientByPrices(@PathVariable("lowerPrice")int price1, @PathVariable("higherPrice")int price2) { //localhost:5050/product   -GET
//		return "Searching all products between : " + price1 + " and " + price2;
//	}
	
	@GetMapping("single")
	public String getSinglePatient() {     //localhost:5050/product/single   -GET
		return "Gettin a single patient";
	}
	
	@PostMapping
	public String savePatient(@RequestBody Patient patient) {     //localhost:5050/product   -Post
		return "saving a single patient";
	}
	
	@PutMapping
	public String updatePatient(@PathVariable("patientId") int patientId, @RequestBody Patient patient) {    //localhost:5050/product   -Put
		return "updating a single patient with patient ID : " + patientId;
	}

	
	@DeleteMapping("{id}")
	public String deletePatient(@PathVariable("id")int id) {    //localhost:5050/product   -Delete
		return "successfully deleted patient with patient ID : " + id;
	}
	@DeleteMapping("deletePatientByName/{name}")
	public String deleteProduct2(@PathVariable("name")String patientName) {    //localhost:5050/product   -Delete
		return "successfully deleted patient with patient name : " + patientName;
	}
	
	@DeleteMapping("/allPatient")
	public String deletePatient2() {    //localhost:5050/product   -Delete
		return "saving a single product";
	}
}

