package formationHibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employe {
	@Id
	@GeneratedValue
	private Long id; 
	private Long Matricule; 
	private String Nom; 
	private String Prenom;
	
	@ManyToOne
	private Societe Societe; 
	
	public Employe(){}

	public Employe(Long id, Long matricule, String nom, String prenom,
			formationHibernate.Societe societe) {
		super();
		this.id = id;
		Matricule = matricule;
		Nom = nom;
		Prenom = prenom;
		Societe = societe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMatricule() {
		return Matricule;
	}

	public void setMatricule(Long matricule) {
		Matricule = matricule;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public Societe getSociete() {
		return Societe;
	}

	public void setSociete(Societe societe) {
		Societe = societe;
	}
	
	
	
}
