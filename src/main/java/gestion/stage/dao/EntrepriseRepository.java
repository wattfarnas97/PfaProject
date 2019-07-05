package gestion.stage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import gestion.stage.entites.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {

}
