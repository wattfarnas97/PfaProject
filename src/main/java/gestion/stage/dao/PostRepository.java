package gestion.stage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import gestion.stage.entites.Post;
@RepositoryRestResource

public interface PostRepository  extends JpaRepository<Post, Integer>{
	//@Query("select p from Post p where p.libelle=:libelle" )
//	public Post findByLibelle(@Param("libelle")String libelle);
}
