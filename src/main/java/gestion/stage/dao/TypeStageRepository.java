package gestion.stage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import gestion.stage.entites.TypeStage;
@RepositoryRestResource
public interface TypeStageRepository  extends JpaRepository<TypeStage, Integer>{
//	@Query("select t from TypeStage t where t.libelle=:libelle" )
	//public TypeStage findByLibelle(@Param("libelle")String libelle);
}
