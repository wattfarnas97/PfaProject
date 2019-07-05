package gestion.stage.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import gestion.stage.entites.Activite;

@RepositoryRestResource
public interface ActiviteRepository  extends JpaRepository<Activite, Integer>{
	//@Query("select a from Activite a where a.libelle=:libelle" )
	//public Page<Activite> findByLibelleContains(@Param("libelle")String libelle,Pageable peagable);


}
