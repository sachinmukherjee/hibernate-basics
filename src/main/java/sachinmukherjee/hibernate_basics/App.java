package sachinmukherjee.hibernate_basics;
import java.util.List;

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
    	   
    	   /*****************Saving Data****************************/
    	   /*
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
    	   */
    	   
    	   /****************Retrive Data*************************/
    	   
    	   /*
    	   session = factory.getCurrentSession();
    	   System.out.println("Fetching Data!!!!!!!!!!!");
    	   
    	   System.out.println("Transaction Started....");
    	   session.beginTransaction();
    	   
    	   OwnerCompany company = session.get(OwnerCompany.class, 1);
    	   System.out.println(company);
    	   
    	   session.getTransaction().commit();
    	   */
    	   
    	   /***************HQL*******************************/
    	   /*
    	   session = factory.getCurrentSession();
    	   session.beginTransaction();
    	   
    	   List<OwnerCompany> ownerCompanies = session
    			   						.createQuery("from OwnerCompany")
    			   						.getResultList();
    	   
    	   
    	   for(int i=0;i<ownerCompanies.size();i++) {
    		   System.out.println(ownerCompanies.get(i));
    	   }
    	   
    	   session.getTransaction().commit();
    	   */
    	   
    	   /*******************Update*****************************/
    	   /*
    	   session = factory.getCurrentSession();
    	   session.beginTransaction();
    	   int ownerCompanyId = 9;
    	   OwnerCompany ownerCompany = session.get(OwnerCompany.class, ownerCompanyId);
    	   ownerCompany.setName("Innovae 3D Printing");
    	   session.getTransaction().commit();
    	   */
    	   
    	   /****************HQL Update**************************/
    	   /*
    	   session = factory.getCurrentSession();
    	   session.beginTransaction();
    	   session.createQuery("update OwnerCompany set name='Innovae 3D Prining' where short_name='I3D'")
    	   			.executeUpdate();
    	   session.getTransaction().commit();
    	   */
    	   
    	   /****************Delete************************/
    	   /*
    	   session = factory.getCurrentSession();
    	   int ownerCompanyId = 9;
    	   session.beginTransaction();
    	   OwnerCompany ownerCompany = session.get(OwnerCompany.class, ownerCompanyId);
    	   session.delete(ownerCompany);
    	   session.getTransaction().commit();
    	   */
    	
       }catch(Exception e) {
    	   e.printStackTrace();
    	   System.out.println("Unable to Connect");
       }finally {
		 factory.close();
	   }
       
    
        
    }
}
