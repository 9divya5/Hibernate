package com.telusko.DemoHib;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class)
        												   .addAnnotatedClass(Phone.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        //TO SAVE AN OBJECT
        /*
         * Alien obj = new Alien();
        obj.setAid(105);
        obj.setAname("Divya");
        obj.setColor("White");
        session.save(obj);
         */
        
        //TO FETCH AN OBJECT
        /*Alien obj = null;
         * obj = (Alien) session.get(Alien.class, 104);
        System.out.println(obj);*/
        
        //TO SAVE EMBEDDABLE OBJECTS
        PhoneName pname = new PhoneName();
        pname.setFname("Apple");
        pname.setMname("iphone");
        pname.setLname("10X");
        
        Phone phone = new Phone();
        phone.setPid(101);
        phone.setPcolor("White");
        phone.setPname(pname);
        session.save(phone);
        
        
        
        tx.commit();
        
    }
}
