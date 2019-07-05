package gestion.stage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import gestion.stage.entites.DetailStage;
import gestion.stage.entites.DetailStageId;

public interface DetailStageRepository  extends JpaRepository<DetailStage, DetailStageId>{

}
