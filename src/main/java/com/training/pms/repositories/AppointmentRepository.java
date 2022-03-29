package com.training.pms.repositories;

import org.springframework.data.repository.CrudRepository;

import com.training.pms.model.Appointment;
import com.training.pms.model.Patient;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer>{

}
