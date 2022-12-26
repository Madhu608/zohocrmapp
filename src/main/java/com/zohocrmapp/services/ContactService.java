package com.zohocrmapp.services;


import java.util.List;

import com.zohocrmapp.entities.Contacts;

public interface ContactService {
	public void saveContact(Contacts contact);

    List<Contacts> getAllContact();

	public Contacts getContactById(long id);
}
