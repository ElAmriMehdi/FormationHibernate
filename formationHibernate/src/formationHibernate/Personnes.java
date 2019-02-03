package formationHibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Personnes {
	
	@Id
	@GeneratedValue
	private Integer idPersonne;
	
	@Column(nullable=false)
	private String nomPersonne;
	
	@Column(nullable=false)
	private String prenomPersonne;
	
	@Column(nullable=false)
	private Date datenaissPersonne;
	
	public Personnes(String nomPersonne, String prenomPersonne, Date datenaissPersonne) {
		this.nomPersonne = nomPersonne;
		this.prenomPersonne = prenomPersonne;
		this.datenaissPersonne = datenaissPersonne;
	}
	
	//Constructeurs
	//Getters & Setters
	
	public Personnes(){}

	public Integer getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(Integer idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getNomPersonne() {
		return nomPersonne;
	}

	public void setNomPersonne(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	}

	public String getPrenomPersonne() {
		return prenomPersonne;
	}

	public void setPrenomPersonne(String prenomPersonne) {
		this.prenomPersonne = prenomPersonne;
	}

	public Date getDatenaissPersonne() {
		return datenaissPersonne;
	}

	public void setDatenaissPersonne(Date datenaissPersonne) {
		this.datenaissPersonne = datenaissPersonne;
	}
	
	
	
	

}
