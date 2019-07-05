package gestion.stage.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dbfile implements Serializable {

	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	private String fileName;
	 private String fileType;
	@Lob
	private byte[] data;
}
