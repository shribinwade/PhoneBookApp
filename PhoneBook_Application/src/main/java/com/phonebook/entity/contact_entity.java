package com.phonebook.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class contact_entity {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    
	private String name;
	private Long phone_number;
	private Long mobile_number;
	private String email;
	private String address;
	private LocalDate date;
}
