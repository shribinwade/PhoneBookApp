package com.phonebook.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phonebook.binding.Contact;
import com.phonebook.entity.contact_entity;
import com.phonebook.repo.Contact_Repository;

@RestController
public class PhoneBook_Controller{
   
	@Autowired
	public Contact_Repository service;
	
	
	@PostMapping(
			value = "/save",
			consumes = {"application/json"},
			produces = {"application/json"}
			
			)
	public ResponseEntity<contact_entity> contactSaving(@RequestBody Contact contact){
		contact_entity entity = new contact_entity();
		BeanUtils.copyProperties(contact, entity);
		entity.setDate(LocalDate.now());
		contact_entity save = service.save(entity);
		return new ResponseEntity<contact_entity>(save,HttpStatus.CREATED);
	}
	
	
	@GetMapping(
			value="/contacts",
			produces = "application/json"
			)
	public List loadContacts(){
		List<contact_entity> findAll = service.findAll();
		return findAll;
	}
	
	
	@GetMapping(
			value="/contacts/{id}",
			produces = "application/json"
			)
	public Optional<contact_entity> loadContactById(@PathVariable Integer id ){
		Optional<contact_entity> byId = service.findById(id);
		System.out.println(byId);
		return byId;
	}
	
	@GetMapping(
			value="/contacts/delete/{id}",
			produces = "application/json"
			)
     public String DeleteContactById(@PathVariable Integer id ){
		  if(id!=null) {
	       service.deleteById(id);
	       return "Contact Deleted";
	       }
		
		return "Wrong id";
	}
	
	
}
