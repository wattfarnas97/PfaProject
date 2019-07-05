package gestion.stage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import gestion.stage.entites.Etudiant;

@RepositoryRestResource
public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {
//	@Query("select e from Etudiant e where e.matricule=:matricule" )
	public Etudiant findByMatricule(@Param("matricule")long matricule);
	
	//@Query("select e from Etudiant e where e.nom like %?1% and e.prenom  like %?2%" )
	//public List<Etudiant> findByNomAndPrenomContains(@Param("nom")String nom,@Param("prenom") String prenom) ;
}
