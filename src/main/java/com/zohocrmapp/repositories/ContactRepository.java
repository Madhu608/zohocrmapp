package com.zohocrmapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;



import com.zohocrmapp.entities.Contacts;

public interface ContactRepository extends JpaRepository<Contacts, Long> {

}
