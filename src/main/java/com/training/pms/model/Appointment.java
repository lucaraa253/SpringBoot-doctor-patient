package com.training.pms.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="appointment")
public class Appointment {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appointmentId;
	
    private String typeOfAppointment;
    
    private Date date;
    
    private String time;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="patient_id")
    private Patient patient;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="doctor_id")
    private Doctor doctor;
}