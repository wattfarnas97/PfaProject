package gestion.stage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import gestion.stage.entites.Ville;
@RepositoryRestResource
public interface VilleRepository extends JpaRepository<Ville, Integer> 
{
	//@Query("select v from Ville v where v.libelle=:libelle" )
	//public Ville findByLibelle(@Param("libelle")String libelle);
}
