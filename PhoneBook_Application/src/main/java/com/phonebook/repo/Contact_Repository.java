package com.phonebook.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phonebook.entity.contact_entity;

public interface Contact_Repository extends JpaRepository<contact_entity, Integer> {

}
