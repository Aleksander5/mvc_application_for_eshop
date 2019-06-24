package com.achrzanowski.springboot.dao;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import com.achrzanowski.springboot.dao.DAOInterface;

class DAOInterfaceTest {

	@Test
	public void checkDAOInterfaceMethods() {
		assertThat(DAOInterface.class).
			hasPublicMethods("getDataFromDatabase", 
							 "saveDataToDatabase",
							 "updateDataFromDatabase",
							 "deleteDataFromDatabase")
			.isInterface();
	}

}
