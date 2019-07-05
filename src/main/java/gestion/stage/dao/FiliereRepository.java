package gestion.stage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import gestion.stage.entites.Filiere;

@RepositoryRestResource
public interface FiliereRepository extends JpaRepository<Filiere, Integer> {
	@Query("select f from Filiere f where f.libelle=:libelle" )
	public Filiere findByLibelle(@Param("libelle")String libelle);
}
