package com.esisa.contacts.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.esisa.contacts.domain.Contact;

public interface ContactService {

	/**
     * Save a contact.
    *
    * @param contactDTO the entity to save.
    * @return the persisted entity.
    */
   Contact save(Contact contact);

   /**
    * Get all the contacts.
    *
    * @param pageable the pagination information.
    * @return the list of entities.
    */
   Page<Contact> findAll(Pageable pageable);

   /**
    * Get the "id" contact.
    *
    * @param id the id of the entity.
    * @return the entity.
    */
   Optional<Contact> findOne(Long id);

   /**
    * Delete the "id" contact.
    *
    * @param id the id of the entity.
    */
   void delete(Long id);
}
