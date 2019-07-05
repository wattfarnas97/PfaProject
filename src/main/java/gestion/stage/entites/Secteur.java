package gestion.stage.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Secteur implements Serializable {
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer id;
	@Column(unique=true)
	private String libelle;
}
