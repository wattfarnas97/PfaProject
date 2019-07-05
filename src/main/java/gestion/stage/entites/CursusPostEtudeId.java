package gestion.stage.entites;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursusPostEtudeId implements Serializable{
private Integer entrepriseId;
private Integer etudiantId;
}
