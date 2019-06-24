package com.achrzanowski.springboot.mvccontrollers;

import org.springframework.beans.factory.annotation.Autowired;

import com.achrzanowski.springboot.dao.*;

public abstract class ViewController {

	@Autowired
	LocalDatabaseDAO localDatabaseDAO;
}
