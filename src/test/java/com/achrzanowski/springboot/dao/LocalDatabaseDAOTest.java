package com.achrzanowski.springboot.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.achrzanowski.springboot.entity.*;



class LocalDatabaseDAOTest {

	private static final String PERSISTENCE_UNIT_NAME = "Manufacturer";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	
	EntityManager entityManager = factory.createEntityManager();
	
	static LocalDatabaseDAO dao;
	
	@BeforeEach
	public void before() {
		dao = new LocalDatabaseDAO(entityManager);
	}
	
	@Test
	public void checkFieldCompleteness() {
		assertThat(dao).hasFieldOrProperty("entityManager");
	}
	
	@Test
	public void checkDAOInterfaceImplementation() {
		assertThat(LocalDatabaseDAO.class)
						.hasDeclaredMethods("getDataFromDatabase", 
											"saveDataToDatabase", 
											"updateDataFromDatabase", 
											"deleteDataFromDatabase");
	}
	
	@Test
	public void getDataFromDatabaseTest() {
		List<LocalDatabaseEntity> dataList = dao.getDataFromDatabase("from Manufacturer");

		assertThat(dataList).isNotEmpty();
		
		assertThat(dataList).extracting("brandName", "importer")
							.contains(tuple("Samsung", "Samsung Polska"),
									  tuple("Huawei", "Huawei Polska"),
									  tuple("Alienware", "Dell Inc."));
	}
	 
	@Test
	public void saveDataTest() {
		
		Manufacturer manufacturer = new Manufacturer("Apple", "Apple (Polska)");
		
		dao.saveDataToDatabase(manufacturer);
		
		List<LocalDatabaseEntity> dataList = dao.getDataFromDatabase("from Manufacturer");
		
		assertThat(dataList).extracting("brandName", "importer")
							.contains(tuple("Apple", "Apple (Polska)"));
		
	}
	
	@Test
	public void deleteDataTest() {
		Manufacturer manufacturer = new Manufacturer("Sony", "Sony sp. z.o.o.");
		dao.saveDataToDatabase(manufacturer);
		
		List<LocalDatabaseEntity> dataList = dao.getDataFromDatabase("from Manufacturer");
		assertThat(dataList).extracting("brandName", "importer")
							.contains(tuple("Sony", "Sony sp. z.o.o."));
		
		dao.deleteDataFromDatabase(manufacturer);
		
							dataList = dao.getDataFromDatabase("from Manufacturer");
		assertThat(dataList).extracting("brandName", "importer")
							.doesNotContain(tuple("Sony", "Sony sp. z.o.o."));
	}
	
	@Test
	public void updateDataTest() {
		Manufacturer manufacturer = new Manufacturer("Logitech", "Logitech Europe");
		dao.saveDataToDatabase(manufacturer);
		
		List<LocalDatabaseEntity> dataList = dao.getDataFromDatabase("from Manufacturer");
		assertThat(dataList).extracting("brandName", "importer")
							.contains(tuple("Logitech", "Logitech Europe"));
		
		manufacturer.setImporter("Logitech Polska");
		dao.updateDataFromDatabase(manufacturer);
		
							dataList = dao.getDataFromDatabase("from Manufacturer");
		assertThat(dataList).extracting("brandName", "importer")
							.contains(tuple("Logitech", "Logitech Polska"));
	}
	
	@AfterAll
	public static void after() {
		List<LocalDatabaseEntity> dataList = dao.getDataFromDatabase("from Manufacturer where brand_name = 'Apple'");
		dao.deleteDataFromDatabase(dataList.get(0));
		
							dataList = dao.getDataFromDatabase("from Manufacturer where brand_name = 'Logitech'");
		dao.deleteDataFromDatabase(dataList.get(0));
	} 
	
}
