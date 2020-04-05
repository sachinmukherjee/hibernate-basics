package sachinmukherjee.hibernate_basics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import sachinmukherjee.entity.OwnerCompany;
import sachinmukherjee.entity.OwnerCompanyOffices;

public class OnetoOne {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(OwnerCompany.class)
								 .addAnnotatedClass(OwnerCompanyOffices.class)
								 .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			/*******************Saving****************************/
			/*
			System.out.println("Object Created");
			OwnerCompanyOffices ownerCompanyOffices = new OwnerCompanyOffices("UEL Chakkan", "Chakkan");
			OwnerCompany ownerCompany = new OwnerCompany("Unitherm", "UEL", 1);
			ownerCompanyOffices.setOwnerCompany(ownerCompany);
			System.out.println("Transaction Started");
			session.beginTransaction();
			session.save(ownerCompanyOffices);
			System.out.println("Saved!!!!!!!!!!!!!!!");
			session.getTransaction().commit();
			*/
			
			/*****************Fetching***************************/
			/**Offices to Company*/
			int ownerCompanyOfficesId = 3;
			/*
			session = factory.getCurrentSession();
			session.beginTransaction();
			OwnerCompanyOffices ownerCompanyOffices = session.get(OwnerCompanyOffices.class, ownerCompanyOfficesId);
			OwnerCompany ownerCompany = ownerCompanyOffices.getOwnerCompany();
			System.out.println(ownerCompanyOffices.getName());
			System.out.println(ownerCompany);
			session.getTransaction().commit();
			session.close();
			*/
			/**Company to Offices**/
			int ownerCompanyId = 3;
			session = factory.getCurrentSession();
			session.beginTransaction();
			OwnerCompany ownerCompany = session.get(OwnerCompany.class, ownerCompanyId);
			OwnerCompanyOffices ownerCompanyOffices = ownerCompany.getOwnerCompanyOffices();
			System.out.println(ownerCompany.getName());
			System.out.println(ownerCompanyOffices.getName());
			session.getTransaction().commit();
			session.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			session.close();
		}
	}
}
