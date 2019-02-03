package formationHibernate;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Societe {
	@Id
	@GeneratedValue
	private Long id; 
	private String name; 
	
	@OneToMany(fetch=FetchType.EAGER)
	Collection<Employe>EmployeList = new ArrayList<Employe>();
	
	public Societe(){}
	
	public Societe(String name, Collection<Employe>EmployeList){
		this.name = name;
		this.EmployeList = EmployeList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Employe> getEmployeList() {
		return EmployeList;
	}

	public void setEmployeList(Collection<Employe> employeList) {
		EmployeList = employeList;
	}
	
	
	
}
