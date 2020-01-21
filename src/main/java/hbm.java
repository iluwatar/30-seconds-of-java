package com.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;

import com.demo.Entity;

public class hbm
{

    public static void main( String[] args )
    {
        SessionFactory _factory = null;
          try {
                     _factory = new Configuration()
                                                .configure("hibernate.cfg.xml")
                                                .addAnnotatedClass(Entity.class)
                                                .buildSessionFactory();
              } catch (Throwable ex) {
                 System.err.println("Failed to create sessionFactory!" + ex);
                 throw new ExceptionInInitializerError(ex);
              }

        Session _session = _factory.openSession();
        //Session session = _factory.getCurrentSession();

        Transaction _tx = null;
        try {

            _tx = _session.beginTransaction();
            //TO DO
            Entity _entity = new Entity();

            _session.save(_entity);

            Entity _read = _session.get(Entity.class,_entity.getId());

            //_session.getTransaction().commit();
            _tx.commit();

        }

        catch (Exception e) {
           if (_tx!=null) _tx.rollback();
           e.printStackTrace();
        } finally {
           _session.close();
           //_factory.close();

        }
    }
}
