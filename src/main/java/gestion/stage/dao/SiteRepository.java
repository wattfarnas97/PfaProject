package gestion.stage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import gestion.stage.entites.Site;
@RepositoryRestResource
public interface SiteRepository extends JpaRepository<Site, Integer> {
	//@Query("select s from Site s where s.libelle=:libelle" )
//	public Site findByLibelle(@Param("libelle")String libelle);
}
