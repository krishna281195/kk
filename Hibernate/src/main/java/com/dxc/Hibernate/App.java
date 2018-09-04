package com.dxc.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    Address add=new Address();
    
    add.setHno(100); 
    add.setStreet("vijay");
    add.setCity("delhi");
    add.setState("Mp");
    add.setPincode(452010);

    	
    	
       Student std = new Student();
       std.setName("john");
       std.setRollno("cs2");
       std.setMarks(98.3f);
       std.setAddress(add);
       
       Configuration cfg=new Configuration().configure()
          .addAnnotatedClass(Student.class);
       
       SessionFactory sfactory =cfg.buildSessionFactory();
       
       Session session=sfactory.openSession();
       
       Transaction tx=session.beginTransaction();
       
       session.save(std);
       
       tx.commit();
    }
    
    
}
