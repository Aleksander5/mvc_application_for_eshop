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
@RequestMapping("/notebook")
public class NotebookController extends ViewController{

	@RequestMapping("/list")
	public String listData(Model theModel) {
		
		List<Notebook> theNotebooks = new LinkedList<Notebook>();
		
		for(LocalDatabaseEntity entity: localDatabaseDAO.getDataFromDatabase("from Notebook"))
			theNotebooks.add((Notebook) entity);
		
		theModel.addAttribute("notebooks", theNotebooks);
		
		return "list-notebooks";
	}
	
	@RequestMapping("/showFormForAddNotebook")
	public String showFormForAddNotebook(Model theModel) {
		
		Notebook theNotebook = new Notebook();
		List<Manufacturer> theManufacturers = new LinkedList<Manufacturer>();
		
		for(LocalDatabaseEntity entity: localDatabaseDAO.getDataFromDatabase("from Manufacturer order by brandName"))
				theManufacturers.add((Manufacturer) entity);
		
		theModel.addAttribute("notebook", theNotebook);
		theModel.addAttribute("manufacturers", theManufacturers);
			
		return "notebook-form";
	}
	
	@PostMapping("/saveNotebook")
	public String saveNotebook(@ModelAttribute("notebook") Notebook theNotebook) {

		theNotebook.setManufacturer(localDatabaseDAO.getSingleManufacturerFromDatabase(theNotebook.getManufacturerId()));
		
		localDatabaseDAO.saveDataToDatabase(theNotebook);
		
		return "redirect:/notebook/list"; 
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("notebookId") int theId, Model theModel) {
		
		Notebook theNotebook = localDatabaseDAO.getSingleNotebookFromDatabase(theId);
		List<Manufacturer> theManufacturers = new LinkedList<Manufacturer>();
		
		for(LocalDatabaseEntity entity: localDatabaseDAO.getDataFromDatabase("from Manufacturer order by brandName"))
			theManufacturers.add((Manufacturer) entity);
		
		theModel.addAttribute("notebook",  theNotebook);
		theModel.addAttribute("manufacturers", theManufacturers);
		
		return "notebook-update-form";
	}
	
	@PostMapping("/updateNotebook")
	public String updateNotebook(@ModelAttribute("notebook") Notebook theNotebook) {

		theNotebook.setManufacturer(localDatabaseDAO.getSingleManufacturerFromDatabase(theNotebook.getManufacturerId()));

		localDatabaseDAO.updateDataFromDatabase(theNotebook);
		
		return "redirect:/notebook/list"; 
	}
	
	@GetMapping("/delete")
	public String deleteNotebook(@RequestParam("notebookId") int theId) {

		localDatabaseDAO.deleteDataFromDatabase(localDatabaseDAO.getSingleNotebookFromDatabase(theId));
		
		return "redirect:/notebook/list"; 
	}
}
