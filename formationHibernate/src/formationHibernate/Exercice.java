package formationHibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Exercice {

	public static void main(String[] args) {
		
		Configuration config= new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		
		Transaction tx = null; 
		
		//Ajout d'un nouveau employe
		try{
			tx = session.beginTransaction();
			Employe e = new Employe(null, (long) 1, "nom1", "prenom1", null);
			session.save(e);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
		
		//Ajout d'une nouvelle societe
		try{
			tx = session.beginTransaction();
			Societe s = new Societe("societe1", null);
			session.save(s);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
		
		//Affecter à la societe dont l'id = 1 un nouveau employé. 
		try{
			tx = session.beginTransaction();
			Societe s = (Societe) session.get(Societe.class, new Long(1));
			System.out.println("Nom societe: "+s.getName());
			if(s.getEmployeList()==null){
				s.setEmployeList(new ArrayList<Employe>());
			}
			Employe e = new Employe(null, (long) 1, "nom1", "prenom1", null);
			session.save(e);
			e.setSociete(s);
			s.getEmployeList().add(e);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
		
		//employe id=5 ne soit plus affecté à la societé id = 1

		try{
			tx = session.beginTransaction();
			
			Employe e = (Employe) session.load(Employe.class, new Long(5));
			Societe s = (Societe) session.load(Societe.class, new Long(1));
			boolean b = s.getEmployeList().remove(e);
			System.out.println("removed: "+b);
			e.setSociete(null);
			session.save(e);
			session.save(s);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
	}

}
