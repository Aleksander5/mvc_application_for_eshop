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
@RequestMapping("/manufacturer")
public class ManufacturerController extends ViewController {
	
	@RequestMapping("/list")
	public String listData(Model theModel) {
		
		List<Manufacturer> theManufacturers = new LinkedList<Manufacturer>();
		
		for(LocalDatabaseEntity entity: localDatabaseDAO.getDataFromDatabase("from Manufacturer"))
			theManufacturers.add((Manufacturer) entity);
		
		theModel.addAttribute("manufacturers", theManufacturers);
		
		return "list-manufacturers";
	}
	
	@RequestMapping("/showFormForAddManufacturer")
	public String showFormForAddManufacturer(Model theModel) {
		
		Manufacturer theManufacturer = new Manufacturer();
		
		theModel.addAttribute("manufacturer", theManufacturer);
		
		return "manufacturer-form";
	}
	
	@PostMapping("/saveManufacturer")
	public String saveManufacturer(@ModelAttribute("manufacturer") Manufacturer theManufacturer) {
		
		localDatabaseDAO.saveDataToDatabase(theManufacturer);
		
		return "redirect:/manufacturer/list"; 
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("manufacturerId") int theId, Model theModel) {
		
		Manufacturer theManufacturer = localDatabaseDAO.getSingleManufacturerFromDatabase(theId);
		
		theModel.addAttribute("manufacturer",  theManufacturer);
		
		return "manufacturer-update-form";
	}
	
	@PostMapping("/updateManufacturer")
	public String updateManufacturer(@ModelAttribute("manufacturer") Manufacturer theManufacturer) {
		
		localDatabaseDAO.updateDataFromDatabase(theManufacturer);
		
		return "redirect:/manufacturer/list"; 
	}
	
	@GetMapping("/delete")
	public String deleteManufacturer(@RequestParam("manufacturerId") int theId) {

		localDatabaseDAO.deleteDataFromDatabase(localDatabaseDAO.getSingleManufacturerFromDatabase(theId));
		
		return "redirect:/manufacturer/list"; 
	}
}









