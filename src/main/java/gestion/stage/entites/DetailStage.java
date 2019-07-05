package gestion.stage.entites;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class DetailStage implements Serializable {
	
	@EmbeddedId
	@GeneratedValue(strategy=GenerationType.AUTO)
	private DetailStageId id;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@MapsId("etudiantId")
	private Etudiant etudiant;

	//@JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER)
	@MapsId("stageId")
	private Stage stage;
	//permet renvoyer seuleument la liste des stages de l année en cours
	private long anneeUniversitaire;
	@Lob
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)
	private Dbfile demandeStage;
	@Lob
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)
	private Dbfile conventionStage; 
	@Lob
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)
	private Dbfile reglementStage; 
	@Lob
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)
	private Dbfile ficheAppreciation;
	

}
