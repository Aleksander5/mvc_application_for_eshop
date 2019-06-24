package com.achrzanowski.springboot.mvccontrollers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.achrzanowski.springboot.entity.*;

@Controller
@RequestMapping("/smartphone")
public class SmartphoneController extends ViewController {
	
	@RequestMapping("/list")
	public String listData(Model theModel) {
		
		List<Smartphone> theSmartphones = new LinkedList<Smartphone>();
		
		for(LocalDatabaseEntity entity: localDatabaseDAO.getDataFromDatabase("from Smartphone"))
			theSmartphones.add((Smartphone) entity);
		
		theModel.addAttribute("smartphones", theSmartphones);
		
		return "list-smartphones";
	}
	
	@RequestMapping("/showFormForAddSmartphone")
	public String showFormForAddSmartphone(Model theModel) {
		
		Smartphone theSmartphone = new Smartphone();
		List<Manufacturer> theManufacturers = new LinkedList<Manufacturer>();
		
		for(LocalDatabaseEntity entity: localDatabaseDAO.getDataFromDatabase("from Manufacturer order by brandName"))
				theManufacturers.add((Manufacturer) entity);
		
		theModel.addAttribute("smartphone", theSmartphone);
		theModel.addAttribute("manufacturers", theManufacturers);
			
		return "smartphone-form";
	}
	
	@PostMapping("/saveSmartphone")
	public String saveSmartphone(@ModelAttribute("smartphone") Smartphone theSmartphone) {

		theSmartphone.setManufacturer(localDatabaseDAO.getSingleManufacturerFromDatabase(theSmartphone.getManufacturerId()));
		
		localDatabaseDAO.saveDataToDatabase(theSmartphone);
		
		return "redirect:/smartphone/list"; 
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("smartphoneId") int theId, Model theModel) {
		
		Smartphone theSmartphone = localDatabaseDAO.getSingleSmartphoneFromDatabase(theId);
		List<Manufacturer> theManufacturers = new LinkedList<Manufacturer>();
		
		for(LocalDatabaseEntity entity: localDatabaseDAO.getDataFromDatabase("from Manufacturer order by brandName"))
			theManufacturers.add((Manufacturer) entity);
		
		theModel.addAttribute("smartphone",  theSmartphone);
		theModel.addAttribute("manufacturers", theManufacturers);
		
		return "smartphone-update-form";
	}
	
	@PostMapping("/updateSmartphone")
	public String updateSmartphone(@ModelAttribute("smartphone") Smartphone theSmartphone) {

		theSmartphone.setManufacturer(localDatabaseDAO.getSingleManufacturerFromDatabase(theSmartphone.getManufacturerId()));

		localDatabaseDAO.updateDataFromDatabase(theSmartphone);
		
		return "redirect:/smartphone/list"; 
	}
	
	@GetMapping("/delete")
	public String deleteSmartphone(@RequestParam("smartphoneId") int theId) {

		localDatabaseDAO.deleteDataFromDatabase(localDatabaseDAO.getSingleSmartphoneFromDatabase(theId));
		
		return "redirect:/smartphone/list"; 
	}
}
