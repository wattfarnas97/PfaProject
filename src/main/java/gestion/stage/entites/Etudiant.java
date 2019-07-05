package gestion.stage.entites;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import lombok.Setter;

@Entity
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor

public class Etudiant implements Serializable {
	
@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;

@Column(unique=true)
private long matricule;

private String nom;
private String prenom;
private String telephone;
private String email;

@Lob
@OneToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval=true)
private Dbfile cv;
private long  annee;
private int groupe;


@ManyToOne(fetch=FetchType.EAGER)
private Filiere filiere;


@ManyToOne(fetch=FetchType.EAGER)
private Master master;

@ManyToOne(fetch=FetchType.EAGER)
private Site site;

//les detail du cursus post scolaire de l etudiant
@JsonIgnore
@OneToMany( mappedBy = "etudiant",cascade = CascadeType.ALL, orphanRemoval = true,fetch=FetchType.LAZY )
private Collection<CursusPostEtude> entreprise;

@JsonIgnore
@OneToMany( orphanRemoval = true,cascade=CascadeType.ALL,mappedBy="etudiant",fetch=FetchType.LAZY)
private Collection<DetailStage>stages;


public Etudiant() {
	super();
this.stages=new ArrayList<>();
this.entreprise=new ArrayList<>();
}


}
