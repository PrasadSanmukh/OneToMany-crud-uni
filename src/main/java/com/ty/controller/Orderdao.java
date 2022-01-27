package com.ty.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetomany.AmezonOrder;
import com.ty.onetomany.Item;

public class Orderdao {

	  
		 EntityManager entityManager=null;
         EntityTransaction entityTransaction=null;
         
         public EntityManager getEntityManager() {
        	 EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Prasad");
        	 return entityManagerFactory.createEntityManager();
         }
         
         public void saveOrder(AmezonOrder amezonOrder) {
        	 entityManager=getEntityManager(); 
        	 entityTransaction= entityManager.getTransaction();
        	 entityTransaction.begin();
        	 entityManager.persist(amezonOrder);
        	 entityTransaction.commit();
         }
         public AmezonOrder getOrder(int id) {
        	 entityManager=getEntityManager(); 
        	 return   entityManager.find(AmezonOrder.class,id);
        	 
         }
         public void deleteOrder(int id) {
        	 entityManager=getEntityManager(); 
        	 entityTransaction= entityManager.getTransaction();
        	 entityTransaction.begin();
        	 AmezonOrder amezonOrder	 =entityManager.find(AmezonOrder.class,id);
        	 if(amezonOrder!=null) {
        		 entityManager.remove(amezonOrder);
        	 }
        	 entityTransaction.commit();
         }
         public void addItemsToOrder( List<Item> list,int id) {
        	 entityManager=getEntityManager(); 
        	 entityTransaction= entityManager.getTransaction();
        	 entityTransaction.begin();
        	 AmezonOrder amezonOrder =entityManager.find(AmezonOrder.class,id);
        	 List<Item> itemlist= amezonOrder.getItem();
        	 itemlist.addAll(itemlist);
        	 entityManager.merge(amezonOrder);
        	 entityTransaction.commit();
         }
	}


