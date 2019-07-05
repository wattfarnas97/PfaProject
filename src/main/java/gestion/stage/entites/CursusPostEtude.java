package gestion.stage.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursusPostEtude implements Serializable {

	@EmbeddedId
	private CursusPostEtudeId id;

	@JsonManagedReference
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("entrepriseId")
	private Entreprise entreprise;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("etudiantId")
	private Etudiant etudiant;

	private Date dateDePriseDeFonction;
	private String niveauDeSatisfaction;
	private String observation;
	private double salaire;

	// post occuperactuellement tout non
	private boolean statut;

	@ManyToOne(fetch = FetchType.EAGER)
	private Post post;

}
