package com.training.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.training.pms.model.Appointment;
import com.training.pms.model.Doctor;
import com.training.pms.repositories.AppointmentRepository;
import com.training.pms.repositories.DoctorRepository;

public class AppointmentServiceImpl implements AppointmentService{

	@Autowired
	AppointmentRepository appointmentRepo;
	
	@Override
	public String addAppointment(Appointment appointment) {
		System.out.println("Adding appointment");
		appointmentRepo.save(appointment);
		return "Appointment was saved";
	}

	@Override
	public String updateAppointment(int appointmentId, Appointment appointment) {
		System.out.println("Adding appointment");
		appointmentRepo.save(appointment);
		return "Appointment was updated";
	}

	@Override
	public String deleteAppointment(int appointmentId) {
		appointmentRepo.deleteById(appointmentId);
		return "Appointment deleted successfully";
	}

	@Override
	public List<Appointment> getAppointments() {
		System.out.println("Getting appointments method");
		return (List<Appointment>) appointmentRepo.findAll();
	}

	@Override
	public Appointment getAppointment(int appointmentId) {
		Optional<Appointment> appointment = appointmentRepo.findById(appointmentId);
		return appointment.get();
	}

	@Override
	public boolean isAppointmentExists(int appointmentId) {
		Optional<Appointment> appointment = appointmentRepo.findById(appointmentId);
		return appointment.isPresent();
	}

	

}
