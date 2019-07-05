package gestion.stage.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EncadrantScolaire implements Serializable {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer id;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Filiere filiere;
}
