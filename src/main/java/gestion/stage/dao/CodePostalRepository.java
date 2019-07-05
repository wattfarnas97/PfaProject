package gestion.stage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import gestion.stage.entites.CodePostal;
@RepositoryRestResource
public interface CodePostalRepository extends JpaRepository<CodePostal, Integer> {
	//@Query("select c from CodePostal c where c.libelle=:libelle" )
	//public CodePostal findByLibelle(@Param("libelle")long libelle);
}
