package com.esisa.contacts.web.rest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.esisa.contacts.domain.Contact;
import com.esisa.contacts.service.ContactService;

@Controller
@RequestMapping(value="/api")
public class ContactResource {
	
	private final Logger log = LoggerFactory.getLogger(ContactResource.class);
	
	private final ContactService contactService;
	
	public ContactResource(ContactService contactService) {
		this.contactService = contactService;
	}
	
	@GetMapping("/search-contacts")
    public ModelAndView searchContacts(
    		@RequestParam(name = "firstName", required = false) String firstName,
    		@RequestParam(name = "lastName", required = false) String lastName,
    		@RequestParam(name = "email", required = false) String email,
    		@RequestParam(name = "graduationYear", required = false) String graduationYear,
    		@RequestParam(name = "companyPosition", required = false) String companyPosition
    		) {

		ModelAndView contactModel = new ModelAndView();
		List<Contact> contacts = contactService.searchContact(firstName, lastName, email, graduationYear, companyPosition);
		contactModel.addObject("contacts", contacts);
		contactModel.setViewName("contact_list");
		return contactModel;
	}
	
	
	@RequestMapping(value="/contacts", method=RequestMethod.GET)
	public ModelAndView getAllContacts() {
		ModelAndView contactModel = new ModelAndView();
		List<Contact> contacts = contactService.findAll();
		contactModel.addObject("contacts", contacts);
		contactModel.setViewName("contact_list");
		return contactModel;
	}
	
	
	@RequestMapping(value="/contacts/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteEmployee(@PathVariable("id") Long id) {
		contactService.delete(id);
		return new ModelAndView("redirect:/api/contacts");
	}
	
	@RequestMapping(value="/insertPage", method=RequestMethod.GET)
	 public ModelAndView addArticle() {
	  ModelAndView model = new ModelAndView();
	  Contact contact = new Contact();
	  model.addObject("contactForm", contact);
	  model.setViewName("contact");
	  return model;
	 }
	
	@RequestMapping(value="/contacts/insert", method=RequestMethod.POST)
	public ModelAndView insertEmployee(@ModelAttribute("contactForm") Contact contact) {
		contactService.save(contact);
		return new ModelAndView("redirect:/api/contacts");
	}
	
	@RequestMapping(value="/contacts/update/{id}", method=RequestMethod.GET)
	 public ModelAndView addArticle(@PathVariable("id") Long id) {
	  ModelAndView model = new ModelAndView();
	  Optional<Contact> contact = contactService.findOne(id);
	  if(!contact.isPresent()) return new ModelAndView("redirect:/api/contacts");
	  model.addObject("contactForm", contact);
	  model.setViewName("contact");
	  return model;
	 }
    	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView goIndex() {
		ModelAndView indexModel = new ModelAndView();
		indexModel.setViewName("index");
		return indexModel;
	}
	
	@RequestMapping(value="/cancelInsertOrUpdate", method=RequestMethod.GET)
	public ModelAndView cancelInsertOrUpdate() {
		return new ModelAndView("redirect:/api/contacts");
	}
	
}
