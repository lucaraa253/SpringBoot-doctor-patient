package com.training.pms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="newpatients")
public class Patient {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientId;
    private String username;
    private String password;
    private String insuranceProvider;
}
