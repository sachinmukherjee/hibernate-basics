package sachinmukherjee.hibernate_basics;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

import org.hibernate.Session;

import sachinmukherjee.entity.JobCard;
import sachinmukherjee.entity.JobCardProducts;

public class OnetoMany {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(JobCard.class)
								.addAnnotatedClass(JobCardProducts.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			/***********Saving Data*****************/
			/*
				System.out.println("Creating Entity");
				JobCard jobCard = new JobCard("JB102", "Sumeet");
				JobCardProducts jobCardProducts1 = new JobCardProducts("PIN 4", 15.5);
				JobCardProducts jobCardProducts2 = new JobCardProducts("PIN 9", 15.5);
				JobCardProducts jobCardProducts3 = new JobCardProducts("PIN 15", 15.5);
				
				jobCard.add(jobCardProducts1);
				jobCard.add(jobCardProducts2);
				jobCard.add(jobCardProducts3);
				//jobCardProducts.setJobCard(jobCard);
				System.out.println("Starting Transaction");
				session.beginTransaction();
				System.out.println("Saving!!!!");
				session.save(jobCard);
				session.getTransaction().commit();
				System.out.println("Done");
			*/
			/****************From Job Card to Job Card Product*****************/
			/*
				int jobCardId = 2;
				session = factory.getCurrentSession();
				session.beginTransaction();
				JobCard jobCard = session.get(JobCard.class, jobCardId);
				System.out.println(jobCard.getJob_no());
				List<JobCardProducts> joCardProducts = jobCard.getJob_card_products();
				for(int i=0;i<joCardProducts.size();i++) {
					System.out.println(joCardProducts.get(i).getName());
				}
				session.getTransaction().commit();
			*/
			/*******Job Card Product to Job Card *****************************/
			int jobCardProductId = 2;
			session = factory.getCurrentSession();
			session.beginTransaction();
			JobCardProducts jobCardProduct = session.get(JobCardProducts.class, jobCardProductId);
			System.out.println(jobCardProduct.getName());
			System.out.println(jobCardProduct.getJobCard().getJob_no());
			session.getTransaction().commit();
			/****************/
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
		}
	}
}
