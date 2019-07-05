package gestion.stage.entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stage implements Serializable{
	
@Id @GeneratedValue(strategy=GenerationType.IDENTITY)	
@Column(unique=true)
private Integer id;
private String sujet;
private int version;
private short dureeDuStage;
private Date dateDebutStage;
private Date dateFinStage;
private String initiePar;
private boolean cloture;
private Date dateDeRemiseduRapport;
@Embedded
private SuivieDeSoutenance suivieDeSoutenance;



@ManyToOne(fetch=FetchType.EAGER)
private Entreprise entreprise;

@JsonIgnore
@OneToMany( fetch=FetchType.LAZY,mappedBy="stage")
private Collection<DetailStage>etudiants;


@ElementCollection(fetch=FetchType.LAZY)
private Collection<Seance>seanceEncadrement;

@ManyToOne(fetch=FetchType.EAGER)
private EncadrantScolaire encadrantScolaire;

@OneToOne(fetch=FetchType.EAGER)
private EncadrantEntreprise encadrantEntreprise;

@ManyToOne(fetch=FetchType.EAGER)
private TypeStage type;


}
