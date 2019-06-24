package com.achrzanowski.springboot.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="manufacturer")
public class Manufacturer extends LocalDatabaseEntity{

	//-------------------------Fields-----------------------------

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="brand_name")
	private String brandName;
	
	@Column(name="importer")
	private String importer;
	
	@OneToMany(fetch=FetchType.LAZY,
			mappedBy="manufacturer",
			cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Smartphone> smartphones;
	
	@OneToMany(fetch=FetchType.LAZY,
			mappedBy="manufacturer",
			cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Notebook> notebooks;

	//-------------------------Constructors-----------------------
	
	public Manufacturer() {}


	public Manufacturer(String brandName, String importer) {
		this.brandName = brandName;
		this.importer = importer;
	}

	//-------------------------Getters/Setters--------------------
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getImporter() {
		return importer;
	}

	public void setImporter(String importer) {
		this.importer = importer;
	}
	

	//-------------------------ToString---------------------------
	
	@Override
	public String toString() {
		return "manufacturer [id=" + id + ", brandName=" + brandName + ", importer=" + importer + "]";
	}
	
}
