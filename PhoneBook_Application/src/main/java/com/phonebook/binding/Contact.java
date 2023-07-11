package com.phonebook.binding;

import lombok.Data;

@Data
public class Contact {
	private String name;
	private Long phone_number;
	private Long mobile_number;
	private String email;
	private String address;
}
