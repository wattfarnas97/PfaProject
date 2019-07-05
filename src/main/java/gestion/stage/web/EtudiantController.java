package gestion.stage.web;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import gestion.stage.dao.DbfileRepository;
import gestion.stage.dao.EtudiantRepository;
import gestion.stage.dao.FiliereRepository;
import gestion.stage.dao.MasterRepository;
import gestion.stage.dao.SiteRepository;
import gestion.stage.entites.CursusPostEtude;
import gestion.stage.entites.CustomErrorType;
import gestion.stage.entites.Dbfile;
import gestion.stage.entites.DetailStage;
import gestion.stage.entites.Etudiant;
import gestion.stage.entites.Filiere;
import gestion.stage.entites.Master;
import gestion.stage.entites.Site;
import gestion.stage.entites.Stage;


@CrossOrigin("*")
@RestController
public class EtudiantController {
	
	@Autowired
	private EtudiantRepository etudiantDao;
	@Autowired
	private SiteRepository siteDao;
	@Autowired
	private FiliereRepository filiereDao;
	@Autowired
	private MasterRepository masterDao;
	@Autowired
	private DbfileRepository fileDao;
	
	/*
	 * Cette fonction nous retourne le liste de tous les etudiants de la base de donnée.
	 * les données renvoyer sont: le nom,prenom,filiere,groupe,année,master,cv,site,matricule,telephone,email,id.
	 * Bref les propritétés de l'entité sans l annotation jsonIgnore 
	 * */

	/*
	 * Cette fonction retourne  un etudiant par rapport a son id qui se trouve dans la pathvariable
	 * */
/*
	@RequestMapping(method = RequestMethod.GET, value = "/Etudiants/{id}")
	public ResponseEntity<?> getEtudiant(@PathVariable("id") Integer id) 
	{
		Optional<Etudiant> etudiant = etudiantDao.findById(id);
		
		if (etudiant.isPresent()) 
		{
			return new ResponseEntity<Etudiant>(etudiant.get(), HttpStatus.OK);

		} 
		else 
		{
			return new ResponseEntity<CustomErrorType>(new CustomErrorType("Aucun étudiant n'a été trouver avec cet identifiant"), HttpStatus.NOT_FOUND);
		} 
	}
	
*/
	/*
	 * Retourne la liste des details des stages   réaliser par l'etudiant dont l'id se trouve dans le pathVariable
	 * les propriétés renvoyer sont la demande de stage,convention de stage,reglement de stage,fiche d appréciation,Année Universitaire,et l identifiant 
	 * */
	
	@RequestMapping(method = RequestMethod.GET, value = "/etudiants/{id}/detailstages")
	public ResponseEntity<?> getEtudiantStage(@PathVariable("id") Integer id) {

		Optional<Etudiant> etudiant = etudiantDao.findById(id);
		if (etudiant.isPresent())
		{
			Collection<DetailStage> listStage = etudiant.get().getStages();

			if (listStage.isEmpty())
			{
				return new ResponseEntity<CustomErrorType>(new CustomErrorType("Aucun stage trouver pour cet étudiant"),HttpStatus.NO_CONTENT);
			}
			

			return new ResponseEntity<Collection<DetailStage>>(listStage, HttpStatus.OK);

		} 
		else
		{
			return new ResponseEntity<CustomErrorType>(new CustomErrorType("Aucun étudiant n'a été trouver avec cet identifiant"), HttpStatus.NOT_FOUND);
		}

	}
	/*
	 * Cette fonction permet de mettre a jour l'étudiant dont l'id se trouve dans le path variable.
	 * les informations concernant l'identifiant du site, de la filiere,master sont passer comme requestparam.Les autres informations se trouve dans 
	 * le request body
	 * 
	 */

	@RequestMapping(method = RequestMethod.PUT, value = "/etudiants/{id}")
	public ResponseEntity<?> updateEtudiant(@PathVariable("id") Integer id, @RequestBody Etudiant etudiant,
			@RequestParam(name = "idFiliere", defaultValue = "-1") Integer idfiliere,
			@RequestParam(name = "idSite", defaultValue = "-1") Integer idSite,
			@RequestParam(name = "idMaster", defaultValue = "-1") Integer idMaster) 
	
	{
		Optional<Etudiant> etudiantCourrant = etudiantDao.findById(id);

		if (etudiantCourrant.isPresent())
		{
			if(etudiant.getMatricule()!=0)
				etudiantCourrant.get().setMatricule(etudiant.getMatricule());
			if(etudiant.getAnnee()!=0)
				etudiantCourrant.get().setAnnee(etudiant.getAnnee());
			if(etudiant.getEmail()!=null)
				etudiantCourrant.get().setEmail(etudiant.getEmail());
			if(etudiant.getGroupe()!=0)
				etudiantCourrant.get().setGroupe(etudiant.getGroupe());
			if(etudiant.getPrenom()!=null)
				etudiantCourrant.get().setPrenom(etudiant.getPrenom());
			if(etudiant.getNom()!=null)
				etudiantCourrant.get().setNom(etudiant.getNom());
			if(etudiant.getTelephone()!=null)
				etudiantCourrant.get().setTelephone(etudiant.getTelephone());
			
			if (idfiliere != -1) 
			{
				Optional<Filiere> filiere = filiereDao.findById(idfiliere);
				if (filiere.isPresent())
					etudiantCourrant.get().setFiliere(filiere.get());

			}
			if (idSite != -1) 
			{
				Optional<Site> site = siteDao.findById(idSite);
				if (site.isPresent())
					etudiantCourrant.get().setSite(site.get());

			}
			
			if (idMaster != -1) {
				Optional<Master> master = masterDao.findById(idMaster);
				if (master.isPresent())
					etudiantCourrant.get().setMaster(master.get());

			}
			etudiantDao.save(etudiantCourrant.get());
			
			return new ResponseEntity<Etudiant>(etudiantCourrant.get(), HttpStatus.OK);
			
		} 
		else
		{
			return new ResponseEntity<CustomErrorType>(new CustomErrorType("Mise à jour impossible.Aucun étudiant n'a été trouver avec cet identifiant"),
					HttpStatus.NOT_FOUND);
		}

	}

	/*
	 * Cette fonction permet de charger le cv d'un étudiant.
	 * L'identifiant de l'etudiant  se trouve dans le path variable.
	 * Le fichier a charger se trouve dans  le request param
	 * !!!!!!!!!!!Mais je doit chercher a gerer la taille des fichiers!!!!!!!!!!!!!!!!!
	 * */
	@RequestMapping(method = RequestMethod.POST, value = "/etudiants/{id}/uploadCv")
	public ResponseEntity<?> chargerCv(@PathVariable("id") Integer id, @RequestParam("cv") MultipartFile file)
	{

		if (file.isEmpty())
		{
			return new ResponseEntity<CustomErrorType>(new CustomErrorType("le fichier a été mal charger"), HttpStatus.BAD_REQUEST);
		}

		else

		{
			Optional<Etudiant> etudiant = etudiantDao.findById(id);

			if (etudiant.isPresent()) 
			{
				Dbfile cv = new Dbfile();
				String filename = etudiant.get().getNom() + etudiant.get().getPrenom() + "cv";
				cv.setFileName(filename);
				
				try {
					
					cv.setData(file.getBytes());
					cv.setFileType(file.getContentType());
					fileDao.save(cv);
					etudiant.get().setCv(cv);
					etudiantDao.save(etudiant.get());
					
					return new ResponseEntity<Etudiant>(etudiant.get(), HttpStatus.OK);
				}
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					return new ResponseEntity<CustomErrorType>(new CustomErrorType("le fichier a été mal charger"), HttpStatus.BAD_REQUEST);
				}

				
			} 
			else 
			{
				return new ResponseEntity<CustomErrorType>(new CustomErrorType("Aucun n'etudiant ne possede ce id"),
						HttpStatus.NOT_FOUND);
			}

		}

	}
	/*
	 * Cette fonction permet de telecharger le cv de l'etudiant dont l'identifiant est dans le pathVariable
	 * */

	@RequestMapping(method = RequestMethod.GET, value = "/etudiants/{id}/downloadCv")
	public ResponseEntity<?> telechargerCv(@PathVariable("id") Integer id) {

		Optional<Etudiant> etudiant = etudiantDao.findById(id);

		if (etudiant.isPresent()) 
		{
			Dbfile cv = etudiant.get().getCv();

			if (cv == null)
			{
				return new ResponseEntity<CustomErrorType>(new CustomErrorType("Ce etudiant ne dispose pas de cv"),
						HttpStatus.NOT_FOUND);
				
			}
			   return ResponseEntity.ok()
		                .contentType(MediaType.parseMediaType(cv.getFileType()))
		                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + cv.getFileName() + "\"")
		                .body(new ByteArrayResource(cv.getData()));
		}

		else 
		{
			return new ResponseEntity<CustomErrorType>(new CustomErrorType("Aucun n'etudiant ne possede ce id"), HttpStatus.NOT_FOUND);
		}

	}
	
	/*
	 *Fonctionalite qui permet de chercher un etudiant par son nom et prenom
	 * */
	
	/*@RequestMapping(method=RequestMethod.GET,value="/Etudiants")
	public ResponseEntity<?> chercherEtudiantParNomEtPrenom(@RequestParam(name="nom",defaultValue="")String nom,@RequestParam(name="prenom",defaultValue="")String prenom)
	{
		
		List<Etudiant>listEtudiant=etudiantDao.findByNomAndPrenomContains(nom, prenom);
	
		
		if(listEtudiant.isEmpty())
			
		{
		
			return  new ResponseEntity<CustomErrorType>(new CustomErrorType("Aucun etudiant ne possede ce nom et prenom"),HttpStatus.NOT_FOUND);
		}
		
		else
			
		{
			
			return new ResponseEntity<List<Etudiant>>(listEtudiant,HttpStatus.OK);
			
		}
		
		
		
	}
	
	*/
/*
 * Cette permet d'ajouter un nouvel etudiant.Pour plus d'information se referer a la fonction modifier un etudiant 
 * */
	@RequestMapping(method = RequestMethod.POST, value = "/etudiants")
	public ResponseEntity<?> AjouterEtudiant( @RequestBody Etudiant etudiant,
			@RequestParam(name = "idFiliere", defaultValue = "-1") Integer idfiliere,
			@RequestParam(name = "idSite", defaultValue = "-1") Integer idSite,
			@RequestParam(name = "idMaster", defaultValue = "-1") Integer idMaster)
	{
		
		Etudiant etudianttest = etudiantDao.findByMatricule(etudiant.getMatricule());
		if (etudianttest!=null)
		{
			return new ResponseEntity<Etudiant>(etudianttest,
					HttpStatus.ALREADY_REPORTED);
		} 
		
		else {
			
			Etudiant nouveauEtudiant =new Etudiant();
			nouveauEtudiant.setMatricule(etudiant.getMatricule());
		 
			if(etudiant.getAnnee()!=0)
				nouveauEtudiant.setAnnee(etudiant.getAnnee());
			if(etudiant.getEmail()!=null)
				nouveauEtudiant.setEmail(etudiant.getEmail());
			if(etudiant.getGroupe()!=0)
				nouveauEtudiant.setGroupe(etudiant.getGroupe());
			if(etudiant.getPrenom()!=null)
				nouveauEtudiant.setPrenom(etudiant.getPrenom());
			if(etudiant.getNom()!=null)
				nouveauEtudiant.setNom(etudiant.getNom());
			if(etudiant.getTelephone()!=null)
				nouveauEtudiant.setTelephone(etudiant.getTelephone());
			

			if (idfiliere != -1) {
				Optional<Filiere> filiere = filiereDao.findById(idfiliere);
				if (filiere.isPresent())
					nouveauEtudiant.setFiliere(filiere.get());

			}
			if (idSite != -1) {
				Optional<Site> site = siteDao.findById(idSite);
				if (site.isPresent())
					nouveauEtudiant.setSite(site.get());

			}
			
			if (idMaster != -1) {
				Optional<Master> master = masterDao.findById(idMaster);
				if (master.isPresent())
					nouveauEtudiant.setMaster(master.get());

			}
			etudiantDao.save(nouveauEtudiant);
			return new ResponseEntity<Etudiant>(nouveauEtudiant, HttpStatus.OK);
			
		}

	}
	
	/*cette fonctionnalite retourne la liste du cursus postScolaire. ce dernier contient toute les infos necessaires*/
	@RequestMapping(method=RequestMethod.GET,value="etudiants/{id}/cursus")
	public ResponseEntity<?>listCursus(@PathVariable("id") Integer id)
	{
		

		Optional<Etudiant> etudiant = etudiantDao.findById(id);
		if (etudiant.isPresent())
		{
			Collection<CursusPostEtude> listStage = etudiant.get().getEntreprise();

			if (listStage.isEmpty())
			{
				return new ResponseEntity<CustomErrorType>(new CustomErrorType("Aucun cursus trouver pour cet étudiant"),HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<Collection<CursusPostEtude>>(listStage, HttpStatus.OK);

		} 
		else
		{
			return new ResponseEntity<CustomErrorType>(new CustomErrorType("Aucun étudiant n'a été trouver avec cet identifiant"), HttpStatus.NOT_FOUND);
		}


		
		
	}

}
