package com.achrzanowski.springboot.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="notebook")
public class Notebook extends LocalDatabaseEntity{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id = 0;
	
	@Column(name="model")
	private String model = "";
	
	@Column(name="series")
	private String series = "";
	
	@Column(name="screen_size")
	private double screenSize = 0.0;
	
	@Column(name="processor_model")
	private String processorModel = "";
	
	@Column(name="ram")
	private int ram = 0;
	
	@Column(name="hard_drive")
	private String hardDrive = "";
	
	@ManyToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="manufacturer_id")
	private Manufacturer manufacturer = new Manufacturer();
	
	@Transient
	private int manufacturerId = 0;

	//-------------------------Constructors-----------------------
	
	public Notebook() {}
	
	public Notebook(String model, String series, double screenSize, String processorModel, int ram, String hardDrive) {
		this.model = model;
		this.series = series;
		this.screenSize = screenSize;
		this.processorModel = processorModel;
		this.ram = ram;
		this.hardDrive = hardDrive;
	}
	
	public Notebook(String model, String series, double screenSize, String processorModel, int ram, String hardDrive, int manufacturerId) {
		this.model = model;
		this.series = series;
		this.screenSize = screenSize;
		this.processorModel = processorModel;
		this.ram = ram;
		this.hardDrive = hardDrive;
		this.manufacturerId = manufacturerId;
	}

	//-------------------------Getters/Setters--------------------
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		
		if( model != null) {
			if(model.length() <= 128 && model.length() > 0 && model != null) {
				this.model = model;
			}
			else {
				throw new IllegalArgumentException();
			}
		} else {
			throw new NullPointerException();
		}
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public double getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}

	public String getProcessorModel() {
		return processorModel;
	}

	public void setProcessorModel(String processorModel) {
		this.processorModel = processorModel;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public String getHardDrive() {
		return hardDrive;
	}

	public void setHardDrive(String hardDrive) {
		this.hardDrive = hardDrive;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId; 
	}
	
	//-------------------------ToString---------------------------
	
	@Override
	public String toString() {
		return "Notebook [id=" + id + ", model=" + model + ", series=" + series + ", screenSize=" + screenSize
				+ ", processorModel=" + processorModel + ", ram=" + ram + ", hardDrive=" + hardDrive + ", manufacturer=" + manufacturer + "]";
	}
	
	
}











