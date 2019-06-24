package com.achrzanowski.springboot.entity;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NotebookTest {

	private Notebook notebook;
	
	@BeforeEach
	public void before() {
		notebook = new Notebook();
	}
	
	@Test
	public void createNewNotebookWithParameters() {
		notebook = new Notebook("3440", "Latitude", 14.1, "Intel Core i5-4200U", 4, "320 GB HDD");
		assertThat(notebook.getModel()).isEqualTo("3440");
		assertThat(notebook.getSeries()).isEqualTo("Latitude");
		assertThat(notebook.getScreenSize()).isEqualTo(14.1);
		assertThat(notebook.getProcessorModel()).isEqualTo("Intel Core i5-4200U");
		assertThat(notebook.getRam()).isEqualTo(4);
		assertThat(notebook.getHardDrive()).isEqualTo("320 GB HDD");
	}
	
	@Test
	public void createNewNotebook() {
		notebook = new Notebook();
		assertThat(notebook).isInstanceOf(Notebook.class);
	}
	
	@Test
	public void checkModelLengthConstraint() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> notebook.setModel(""));
	}
	
	@Test
	public void checkModelNotNullConstraint() {
		Assertions.assertThrows(NullPointerException.class, () -> notebook.setModel(null));
	}
	
	@Test
	public void checkFieldCompleteness() {
		assertThat(notebook).hasFieldOrProperty("id")
							.hasFieldOrProperty("model")
							.hasFieldOrProperty("series")
							.hasFieldOrProperty("screenSize")
							.hasFieldOrProperty("processorModel")
							.hasFieldOrProperty("ram")
							.hasFieldOrProperty("hardDrive")
							.hasFieldOrProperty("manufacturer");
	}
	
	@Test
	public void checkSetMethods() {
		notebook.setId(1);
		notebook.setModel("L470");
		notebook.setSeries("ThinkPad");
		notebook.setScreenSize(14.1);
		notebook.setProcessorModel("Intel Core i5-7100");
		notebook.setRam(8);
		notebook.setHardDrive("256 GB SSD");
		notebook.setManufacturer(new Manufacturer());
		
		assertThat(notebook.getId()).isEqualTo(1);
		assertThat(notebook.getModel()).isEqualTo("L470");
		assertThat(notebook.getScreenSize()).isEqualTo(14.1);
		assertThat(notebook.getProcessorModel()).isEqualTo("Intel Core i5-7100");
		assertThat(notebook.getRam()).isEqualTo(8);
		assertThat(notebook.getHardDrive()).isEqualTo("256 GB SSD");
		assertThat(notebook.getManufacturer()).isExactlyInstanceOf(Manufacturer.class);
	}
	
	@Test
	public void checkFieldType() {
		assertThat(notebook.getId()).isExactlyInstanceOf(java.lang.Integer.class);
		assertThat(notebook.getModel()).isExactlyInstanceOf(java.lang.String.class);
		assertThat(notebook.getSeries()).isExactlyInstanceOf(java.lang.String.class);
		assertThat(notebook.getScreenSize()).isExactlyInstanceOf(java.lang.Double.class);
		assertThat(notebook.getRam()).isExactlyInstanceOf(java.lang.Integer.class);
		assertThat(notebook.getHardDrive()).isExactlyInstanceOf(java.lang.String.class);
		assertThat(notebook.getManufacturer()).isExactlyInstanceOf(Manufacturer.class);
	}
	
	@Test
	public void checkClassInheritance() {
		assertThat(notebook).isInstanceOf(LocalDatabaseEntity.class);
	}

}











