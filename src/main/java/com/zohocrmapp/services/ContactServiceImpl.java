package com.zohocrmapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.zohocrmapp.entities.Contacts;
import com.zohocrmapp.repositories.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository ContactRepo;


	@Override
	public void saveContact(Contacts contact) {
		ContactRepo.save(contact);
		
	}


	@Override
	public List<Contacts> getAllContact() {
		 List<Contacts> contacts = ContactRepo.findAll();
		return contacts;
	}


	@Override
	public Contacts getContactById(long id) {
		Optional<Contacts> findById = ContactRepo.findById(id);	
		Contacts contacts = findById.get();
		return contacts;
	}

}
