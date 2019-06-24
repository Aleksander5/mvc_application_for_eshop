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
@Table(name="smartphone")
public class Smartphone extends LocalDatabaseEntity{

	//-------------------------Fields-----------------------------
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="model")
	private String model;
	
	@Column(name="screen_size")
	private double screenSize;
	
	@Column(name="ram_rom")
	private String ramRom;
	
	@Column(name="operating_system")
	private String operatingSystem;
	
	@Column(name="Colour")
	private String colour;
	
	@ManyToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="manufacturer_id")
	private Manufacturer manufacturer;

	@Transient
	private int manufacturerId = 0;
	//-------------------------Constructors-----------------------
	
	public Smartphone() {}
	
	public Smartphone(String model, double screenSize, String ramRom, String operatingSystem, String colour, Manufacturer manufacturer) {
		this.model = model;
		this.screenSize = screenSize;
		this.ramRom = ramRom;
		this.operatingSystem = operatingSystem;
		this.colour = colour;
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
		this.model = model;
	}

	public double getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}

	public String getRamRom() {
		return ramRom;
	}

	public void setRamRom(String ramRom) {
		this.ramRom = ramRom;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
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
		return "Smartphone [id=" + id + ", model=" + model + ", screenSize=" + screenSize + ", ramRom=" + ramRom
				+ ", operatingSystem=" + operatingSystem + ", colour=" + colour + ", manufacturer=" + manufacturer + "]";
	}
	
}


















