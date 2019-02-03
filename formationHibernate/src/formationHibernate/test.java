package formationHibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class test {

	public static void main(String args[]) throws Exception {
		
		Configuration config= new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		System.out.println("sessionFactory OK...");
		
		Session session = sessionFactory.openSession();
		
		Transaction tx = null; 
		try{
			tx = session.beginTransaction();
			System.out.println("begin transaction OK...");
			Personnes personne = new Personnes("nom3", "prenom3", new Date());
			session.save(personne);
			tx.commit();
			System.out.println("End transaction OK...");
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
		
		try{
			tx = session.beginTransaction();
			System.out.println("begin transaction OK...");
			Personnes personne = (Personnes) session.get(Personnes.class, new Integer(1)); 
			System.out.println("nom = " + personne.getNomPersonne()); 
			tx.commit();
			System.out.println("End transaction OK...");
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
		
		try{
			tx = session.beginTransaction();
			System.out.println("begin transaction OK...");
			Query query = session.createQuery("select pers from Personnes as pers");
			List <Personnes>result = (List<Personnes>) query.list();
			for(int i = 0; i < result.size(); i++){
				Personnes p = (Personnes) result.get(i);
				System.out.println("nom: "+p.getNomPersonne());
			}
			tx.commit();
			System.out.println("End transaction OK...");
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}

		
		session.close();
		sessionFactory.close();
	}
}
