package com.demo;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.demo.Entity;

public class jpa
{
    public static void main( String[] args )
    {
      EntityManagerFactory factory = Persistence.createEntityManagerFactory("%persistence-unit-name%");
      EntityManager entitymanager = factory.createEntityManager();
      entitymanager.getTransaction().begin();
      //TO DO
      entitymanager.getTransaction( ).commit( );
		entitymanager.close( );
		emfactory.close( );
    }
   
}
