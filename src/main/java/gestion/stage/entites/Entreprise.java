package gestion.stage.entites;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entreprise {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer id;
	private String raisonSocial;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Secteur secteur;
	
	private String adresse;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private CodePostal codePostale;
	private String telephone;
	private String fax;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Ville ville;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Activite activite;
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	private Collection<Contact> contacts;
	
	@JsonIgnore
	@OneToMany(mappedBy="entreprise",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	private Collection<CursusPostEtude> laureatEmsi;

	
}
