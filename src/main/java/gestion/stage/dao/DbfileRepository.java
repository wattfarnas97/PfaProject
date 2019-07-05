package gestion.stage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import gestion.stage.entites.Dbfile;

public interface DbfileRepository extends JpaRepository<Dbfile, Integer> {

}
