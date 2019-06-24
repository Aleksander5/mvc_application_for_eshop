package com.achrzanowski.springboot.dao;

import java.util.List;

import com.achrzanowski.springboot.entity.LocalDatabaseEntity;

public interface DAOInterface {
	public List<LocalDatabaseEntity> getDataFromDatabase(String hqlformula);
	public void saveDataToDatabase(LocalDatabaseEntity data);
	public void updateDataFromDatabase(LocalDatabaseEntity data);
	public void deleteDataFromDatabase(LocalDatabaseEntity data);
}
