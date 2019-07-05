package gestion.stage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import gestion.stage.entites.Secteur;

@RepositoryRestResource
public interface SecteurRepository extends JpaRepository<Secteur, Integer> {
	//@Query("select s from Secteur s where s.libelle=:libelle" )
	//public Secteur findByLibelle(@Param("libelle")String libelle);
}
