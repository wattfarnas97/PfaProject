package gestion.stage.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@Data
@NoArgsConstructor
public class SuivieDeSoutenance implements Serializable {
	private Date dateReelle;
	private Date datePrevisionnelleReplanification;
	private Date dateReelleReplanification;
	@Column(nullable=true)
	private double note;
	private String observation;
	private Date datePrevisionnelleInitiale;
	private Dbfile quitus;

}
