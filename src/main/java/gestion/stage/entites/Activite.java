package gestion.stage.entites;

import static org.springframework.test.web.client.response.MockRestResponseCreators.withBadRequest;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activite implements Serializable{
@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;
@Column(unique=true)
private String libelle;

}
