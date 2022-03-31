package com.training.pms.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="patient")
public class Patient {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientId;
    private String username;
    private String password;
    private String insuranceProvider;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy="patient", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("patient")
	private List<Appointment> appointmentList = new ArrayList<>();
}
