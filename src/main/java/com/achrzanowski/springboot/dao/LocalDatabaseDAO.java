package com.achrzanowski.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.achrzanowski.springboot.entity.*;

@Repository
public class LocalDatabaseDAO implements DAOInterface {

	private EntityManager entityManager;
	
	@Autowired
	public LocalDatabaseDAO (EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
		
	@Transactional
	public List<LocalDatabaseEntity> getDataFromDatabase(String hqlformula) {
		
		Session currentSession = entityManager.unwrap(Session.class);
	
		Query<LocalDatabaseEntity> theQuery = currentSession.createQuery(hqlformula, LocalDatabaseEntity.class);
		List<LocalDatabaseEntity> datafromdb = theQuery.getResultList();

		return datafromdb;
	}  
	
	@Transactional
	public void saveDataToDatabase(LocalDatabaseEntity theData) {
		
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(theData);
	}
	
	@Transactional
	public void updateDataFromDatabase(LocalDatabaseEntity theData) {
		
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.evict(theData);
		
		currentSession.update(theData);

	}

	@Transactional
	public void deleteDataFromDatabase(LocalDatabaseEntity theData) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.delete(theData);

	}
	
	@Transactional
	public Manufacturer getSingleManufacturerFromDatabase(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);

		Manufacturer theManufacturer = currentSession.get(Manufacturer.class, theId);
		

		return theManufacturer;
	}
	
	@Transactional
	public Notebook getSingleNotebookFromDatabase( int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Notebook theNotebook = currentSession.get(Notebook.class, theId);
		
		return theNotebook;
	}
	
	@Transactional
	public Smartphone getSingleSmartphoneFromDatabase(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);

		Smartphone theSmartphone = currentSession.get(Smartphone.class, theId);
		
		return theSmartphone;
	}

}


