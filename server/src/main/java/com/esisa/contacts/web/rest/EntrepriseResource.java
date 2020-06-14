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
import org.springframework.web.bind.annotation.RestController;

import com.esisa.contacts.domain.Entreprise;
import com.esisa.contacts.service.EntrepriseService;

/**
 * REST controller for managing {@link com.esisa.contacts.domain.Entreprise}.
 */
@RestController
@RequestMapping("/api")
public class EntrepriseResource {

    private final Logger log = LoggerFactory.getLogger(EntrepriseResource.class);

    private final EntrepriseService entrepriseService;

    public EntrepriseResource(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

   
    @PostMapping("/entreprises")
    public ResponseEntity<Entreprise> createEntreprise(@RequestBody Entreprise entreprise) throws URISyntaxException {
        log.debug("REST request to save Entreprise : {}", entreprise);
        
        Entreprise result = entrepriseService.save(entreprise);
        return ResponseEntity.created(new URI("/api/entreprises/" + result.getId()))
            .body(result);
    }

   
    
    @PutMapping("/entreprises")
    public ResponseEntity<Entreprise> updateEntreprise(@RequestBody Entreprise entreprise) throws URISyntaxException {
        log.debug("REST request to update Entreprise : {}", entreprise);
        
        Entreprise result = entrepriseService.save(entreprise);
        return ResponseEntity.ok()
            .body(result);
    }

  
    
    @GetMapping("/entreprises")
    public ResponseEntity<List<Entreprise>> getAllEntreprises(Pageable pageable) {
        log.debug("REST request to get a page of Entreprises");
        Page<Entreprise> page = entrepriseService.findAll(pageable);
        return ResponseEntity.ok().body(page.getContent());
    }

  
    
    @GetMapping("/entreprises/{id}")
    public ResponseEntity<Entreprise> getEntreprise(@PathVariable Long id) {
    	log.debug("REST request to get Contact : {}", id);
        Optional<Entreprise> entreprise = entrepriseService.findOne(id);
        if(!entreprise.isPresent()) return null;
        return ResponseEntity.ok().body(entreprise.get());
    }

  
    
    @DeleteMapping("/entreprises/{id}")
    public ResponseEntity<Void> deleteEntreprise(@PathVariable Long id) {
        log.debug("REST request to delete Entreprise : {}", id);
        entrepriseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
