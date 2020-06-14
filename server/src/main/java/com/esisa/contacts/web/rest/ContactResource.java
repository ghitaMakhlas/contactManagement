package com.esisa.contacts.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esisa.contacts.domain.Contact;
import com.esisa.contacts.service.ContactService;

/**
 * REST controller for managing {@link com.esisa.contacts.domain.Contact}.
 */
@RestController
@RequestMapping("/api")
public class ContactResource {

    private final Logger log = LoggerFactory.getLogger(ContactResource.class);

    private final ContactService contactService;

    public ContactResource(ContactService contactService) {
        this.contactService = contactService;
    }

 
    @PostMapping("/contacts")
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) throws URISyntaxException {
        log.debug("REST request to save Contact : {}", contact);
      
        Contact result = contactService.save(contact);
        return ResponseEntity.created(new URI("/api/contacts/" + result.getId()))
            .body(result);
    }

 
    @PutMapping("/contacts")
    public ResponseEntity<Contact> updateContact(@RequestBody Contact contact) throws URISyntaxException {
        log.debug("REST request to update Contact : {}", contact);
        Contact result = contactService.save(contact);
        return ResponseEntity.ok()
            .body(result);
    }

   
    @GetMapping("/contacts")
    public ResponseEntity<List<Contact>> getAllContacts(Pageable pageable) {
        log.debug("REST request to get a page of Contacts");
        Page<Contact> page = contactService.findAll(pageable);
        //HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().body(page.getContent());
    }

    
    @GetMapping("/contacts/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable Long id) {
        log.debug("REST request to get Contact : {}", id);
        Optional<Contact> contact = contactService.findOne(id);
        if(!contact.isPresent()) return null;
        return ResponseEntity.ok().body(contact.get());
    }

   
    @DeleteMapping("/contacts/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        log.debug("REST request to delete Contact : {}", id);
        contactService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    
    @GetMapping("/search-contacts")
    public ResponseEntity<List<Contact>> searchContacts(
    		@RequestParam(name = "firstName", required = false) String firstName,
    		@RequestParam(name = "lastName", required = false) String lastName,
    		@RequestParam(name = "email", required = false) String email,
    		@RequestParam(name = "graduationYear", required = false) String graduationYear,
    		@RequestParam(name = "companyPosition", required = false) String companyPosition
    		) {
    	List<Contact> contacts = contactService.searchContact(firstName, lastName, email, graduationYear, companyPosition);
		return ResponseEntity.ok().body(contacts);
    }
    
}
