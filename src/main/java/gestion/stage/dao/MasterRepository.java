package gestion.stage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import gestion.stage.entites.Master;

@RepositoryRestResource
public interface MasterRepository extends JpaRepository<Master, Integer> {
//	@Query("select m from Master m where m.libelle=:libelle" )
	//public Master findByLibelle(@Param("libelle")String libelle);
}
