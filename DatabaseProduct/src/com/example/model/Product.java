package com.example.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name="products_table") //edw eixe instructor
public class Product{
	
	@Id
	
	@Column(name="barcode")
	protected int barcode;
	
	@Column(name="name")
	protected String name;
	
	@Column(name="color")
	protected String color;
	
	@Column(name="description")
	protected String description;
	
	public Product() {
	}
	
	public Product(int barcode, String name, String color, String description) {
		this.barcode = barcode;
		this.name = name;
		this.color = color;
		this.description = description;
	}

	public int getBarcode() {
		return barcode;
	}
	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDescription() {
		return description;
	}
	public String toString(){ 
		  return barcode+" "+name+" "+color+""+description;  
	}  
}