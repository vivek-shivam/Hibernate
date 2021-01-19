package com.vivek.HibRelations;

import java.util.Collection;

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
        Laptop laptop = new Laptop();
        laptop.setLid(101);
        laptop.setLname("Dell");
        
        
        Student s = new Student();
        s.setName("vivek");
        s.setRollno(1);
        s.setMarks(50);
        
        
//        //one to one
//        s.setLaptop(laptop);
//        
        //one to many & many to many
        s.getLaptop().add(laptop);
        
        //many to many
        //laptop.getStudent().add(s);
        
        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sf = config.buildSessionFactory(registry);
        Session session = sf.openSession();
        
        session.beginTransaction();
//        
        session.save(laptop);
        session.save(s);
//        
        
//        Student s2 = (Student)session.get(Student.class,1);
//        System.out.println(s2.getName());
//        
//        Collection<Laptop> lops = s2.getLaptop();
//        for(Laptop l:lops){
//        	System.out.println(l.getLname());
//        	System.out.println("jgfj");
//        }
        
        
        session.getTransaction().commit();
        
        
        
        
        
    }
}
