package gestion.stage.dao;



import org.springframework.data.jpa.repository.JpaRepository;


import gestion.stage.entites.Stage;

public interface StageRepository extends JpaRepository<Stage, Integer> {
	
	
}
