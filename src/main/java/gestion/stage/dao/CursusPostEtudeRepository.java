package gestion.stage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import gestion.stage.entites.CursusPostEtude;
import gestion.stage.entites.CursusPostEtudeId;
@RepositoryRestResource
public interface CursusPostEtudeRepository  extends JpaRepository<CursusPostEtude, CursusPostEtudeId>{

}
