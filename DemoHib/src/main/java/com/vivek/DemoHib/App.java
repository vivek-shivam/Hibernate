package com.vivek.DemoHib;

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
        //System.out.println( "Hello World!" );
        Alien Alien1 = new Alien();
        AlienName an = new AlienName();
        an.setFname("bh");
        an.setMname("jhju");
        an.setLname("jjk");
        
        Alien1.setAid(101);
        Alien1.setAname(an);
        Alien1.setColor("blue");
        
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        
        //Transaction tx = session.beginTransaction();
        
        //saving to database
        //session.save(Alien1);
        
        //fetching from database
//        Alien Alien2;
//        Alien2 = (Alien)session.get(Alien.class, 103);
//        System.out.println(Alien2);
        //session.delete(Alien1);
        
//        session.save(Alien1);
//        
        //tx.commit();
        
        //System.out.println(Alien2);
        
        
        //caching
        Alien a;
        a=(Alien)session.get(Alien.class,101);
        System.out.println(a);
        
//        Alien b=(Alien)session.get(Alien.class,101);
//        System.out.println(b);
       
        session.beginTransaction().commit();
        session.close();
//        
        Session s2 = sf.openSession();
        
        Alien c =(Alien)s2.get(Alien.class,101);
        System.out.println(c);
        
        s2.beginTransaction().commit();
        s2.close();
//        
               
    }
}
