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

import com.training.pms.model.Appointment;
import com.training.pms.model.Doctor;
import com.training.pms.repositories.AppointmentRepository;
import com.training.pms.repositories.DoctorRepository;

@RestController
//used at method or class level
@RequestMapping("appointment")
public class AppointmentController {
	
	@Autowired
	AppointmentRepository appRepo;
	
	@GetMapping
	public ResponseEntity<List<Appointment>> getAppointments() { //localhost:5050/patient   -GET
//		
		List<Appointment> allAppointments = (List<Appointment>)appRepo.findAll();
		return new ResponseEntity<List<Appointment>>(allAppointments, HttpStatus.OK);

	}
	
	@GetMapping("{appointmentId}")
	public ResponseEntity<Appointment> getAppointment(@PathVariable("appointmentId") int appointmentId) { //localhost:5050/patient   -GET
		Optional<Appointment> appointment = appRepo.findById(appointmentId);
		return new ResponseEntity<Appointment>(appointment.get(), HttpStatus.OK);
	}

	
	@PostMapping
	public ResponseEntity<String> saveAppointment(@RequestBody Appointment appointment) {     //localhost:5050/product   -Post
		appRepo.save(appointment);
		return new ResponseEntity<String>("Appointment saved sucessfully", HttpStatus.CREATED);
		
	}
	
	@PutMapping("{appointmentId}")
	public ResponseEntity<String> updateAppointment(@PathVariable("patientId") int appointmentId, @RequestBody Appointment appointment) {    //localhost:5050/product   -Put
		appRepo.save(appointment);
		return new ResponseEntity<String>("Appointment updated sucessfully", HttpStatus.OK);
		

	}

	
	@DeleteMapping("{appointmentId}")
	public ResponseEntity<String> deleteAppointment(@PathVariable("appointmentId")int appointmentId) {    //localhost:5050/product   -Delete
		appRepo.deleteById(appointmentId);
		return new ResponseEntity<String>("Appointment deleted sucessfully", HttpStatus.OK);
	}

}

