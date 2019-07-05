package gestion.stage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import gestion.stage.entites.Contact;

@RepositoryRestResource
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
