/**
 * 18 Eki 2021
 */
package com.bilgeadam.example.schoolmanagementsystem.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.bilgeadam.example.schoolmanagementsystem.prop.Gender;
import com.bilgeadam.example.schoolmanagementsystem.prop.ISalaryIncrease;
import com.bilgeadam.example.schoolmanagementsystem.prop.Name;
import com.bilgeadam.example.schoolmanagementsystem.prop.TelephoneNumber;

/**
 * @author $Görkem Sönmez
 */
public class Teacher extends Employee implements ISalaryIncrease, Serializable {
	
	private static final long serialVersionUID = 279712640291440396L;
	
	public Teacher(Name name, LocalDate birthday, Gender gender, LocalDate dateOfStart, boolean isMarried, double salary, TelephoneNumber telNum) {
		super(name, birthday, gender, dateOfStart, isMarried, salary, telNum);
		if (Employee.regIdNumber == 999) {
			Employee.regIdNumber = 1;
		} else {
			Employee.regIdNumber++;
		}
		
		setDateOfEnd(null);
		this.regId = "Ö" + String.format("%03d", Employee.regIdNumber);
		calculateSalary();
		
	}
	
	public Teacher(Name name, LocalDate birthday, Gender gender, LocalDate dateOfStart, LocalDate dateOfEnd, boolean isMarried, double salary, TelephoneNumber telNum) {
		super(name, birthday, gender, dateOfStart, dateOfEnd, isMarried, salary, telNum);
		if (Employee.regIdNumber == 999) {
			Employee.regIdNumber = 1;
		} else {
			Employee.regIdNumber++;
		}
		
		this.regId = "Ö" + String.format("%03d", Employee.regIdNumber);
		calculateSalary();
	}
	
	@Override
	public String toString() {
		if (getDateOfEnd() == null) {
			return "Öğretmen [getName()=" + getName() + ", getBirthday()=" + getBirthday() + ", getRegId()=" + getRegId() + ", getDateOfStart()=" + getDateOfStart() + ", isMarried()=" + isMarried() + ", getSalary()=" + getSalary() + ", getGender()="
					+ getGender().getGender() + "]";
		} else {
			return "Öğretmen [getName()=" + getName() + ", getBirthday()=" + getBirthday() + ", getRegId()=" + getRegId() + ", getDateOfStart()=" + getDateOfStart() + ", getDateOfEnd()=" + getDateOfEnd() + ", isMarried()=" + isMarried()
					+ ", getSalary()=" + getSalary() + ", getGender()=" + getGender().getGender() + "]";
			
		}
	}
	
	@Override
	public void calculateSalary() {
		double experience = (getDateOfStart().until(LocalDate.now(), ChronoUnit.MONTHS));
		int newexperience = (int) (experience / 6);
		this.setSalary(this.getSalary() + this.getSalary() * (newexperience * 0.10));
	}
	
}
