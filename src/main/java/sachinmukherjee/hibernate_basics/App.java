package sachinmukherjee.hibernate_basics;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import sachinmukherjee.entity.OwnerCompany;

/**
 * Hello world!
 *
 */
public class App 
{
	
	
    public static void main( String[] args ) 
    {
       SessionFactory factory = new Configuration()
				     .configure("hibernate.cfg.xml")
				     .addAnnotatedClass(OwnerCompany.class)
				     .buildSessionFactory();
       
       Session session = factory.getCurrentSession();
       
       try {
    	   
    	   //Create Object
    	   System.out.println("Creating Object");
    	   OwnerCompany owner_company = new OwnerCompany("Innovae3D","I3D",0);
    	   
    	   //Start a Transaction
    	   System.out.println("Start a Transaction");
    	   session.beginTransaction();
    	   
    	   //save the student
    	   System.out.println("Save the Object");
    	   session.save(owner_company);
    	   
    	   session.getTransaction().commit();
    	   
    	   System.out.println("Done!!!!!!!!!!!");
    	   
    	   session = factory.getCurrentSession();
    	   System.out.println("Fetching Data!!!!!!!!!!!");
    	   
    	   System.out.println("Transaction Started....");
    	   session.beginTransaction();
    	   
    	   OwnerCompany company = session.get(OwnerCompany.class, 1);
    	   System.out.println(company);
    	   
    	   session.getTransaction().commit();
    	   
    	
       }catch(Exception e) {
    	   e.printStackTrace();
    	   System.out.println("Unable to Connect");
       }finally {
		 factory.close();
	   }
       
    
        
    }
}
