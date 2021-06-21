package com.cts.ebilling.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tariff {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	private double cat1; 
    private double cat2;
    private double cat3;
    private double cat4;
	public long getId() {
		return id;
	}
	public Tariff(long id, double cat1, double cat2, double cat3, double cat4) {
		super();
		this.id = id;
		this.cat1 = cat1;
		this.cat2 = cat2;
		this.cat3 = cat3;
		this.cat4 = cat4;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getCat1() {
		return cat1;
	}
	public void setCat1(double cat1) {
		this.cat1 = cat1;
	}
	public double getCat2() {
		return cat2;
	}
	public void setCat2(double cat2) {
		this.cat2 = cat2;
	}
	public double getCat3() {
		return cat3;
	}
	public void setCat3(double cat3) {
		this.cat3 = cat3;
	}
	public double getCat4() {
		return cat4;
	}
	public void setCat4(double cat4) {
		this.cat4 = cat4;
	}
	public Tariff()
	{
		
	}
	
    
}
