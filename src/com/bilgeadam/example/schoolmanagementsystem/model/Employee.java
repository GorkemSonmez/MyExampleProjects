/**
 * 18 Eki 2021
 */
package com.bilgeadam.example.schoolmanagementsystem.model;

import java.io.Serializable;
import java.time.LocalDate;

import com.bilgeadam.example.schoolmanagementsystem.prop.Gender;
import com.bilgeadam.example.schoolmanagementsystem.prop.Name;
import com.bilgeadam.example.schoolmanagementsystem.prop.TelephoneNumber;

/**
 * @author $Görkem Sönmez
 */
public abstract class Employee extends Person implements Serializable {
	private static final long serialVersionUID = 3926617902452503891L;
	private LocalDate dateOfStart;
	private LocalDate dateOfEnd;
	private boolean isMarried;
	private double salary;
	protected String regId; // registration number
	
	protected static int regIdNumber = 0;
	
	public Employee(Name name, LocalDate birthday, Gender gender, LocalDate dateOfStart, boolean isMarried, double salary, TelephoneNumber telNum) {
		super(name, birthday, gender, telNum);
		this.dateOfStart = dateOfStart;
		this.isMarried = isMarried;
		this.salary = salary;
		
	}
	
	public Employee(Name name, LocalDate birthday, Gender gender, LocalDate dateOfStart, LocalDate dateOfEnd, boolean isMarried, double salary, TelephoneNumber telNum) {
		super(name, birthday, gender, telNum);
		this.dateOfStart = dateOfStart;
		this.dateOfEnd = dateOfEnd;
		this.isMarried = isMarried;
		this.salary = salary;
	}
	
	public LocalDate getDateOfStart() {
		return dateOfStart;
	}
	
	public LocalDate getDateOfEnd() {
		return dateOfEnd;
	}
	
	public void setDateOfEnd(LocalDate dateOfEnd) {
		this.dateOfEnd = dateOfEnd;
	}
	
	public boolean isMarried() {
		return isMarried;
	}
	
	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String getRegId() {
		return regId;
	}
	
}
