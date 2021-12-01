/**
 * 18 Eki 2021
 */
package com.bilgeadam.example.schoolmanagementsystem.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import com.bilgeadam.example.schoolmanagementsystem.exeption.NotMarriedException;
import com.bilgeadam.example.schoolmanagementsystem.prop.Class;
import com.bilgeadam.example.schoolmanagementsystem.prop.Gender;
import com.bilgeadam.example.schoolmanagementsystem.prop.Name;
import com.bilgeadam.example.schoolmanagementsystem.prop.TelephoneNumber;

/**
 * @author $Görkem Sönmez
 */
public class Student extends Person implements Serializable {
	private static final long serialVersionUID = 604980497912173096L;
	private static int regIdNumber = 0;
	private LocalDate dateOfStart;
	private LocalDate dateOfEnd;
	private ArrayList<String> classes;
	private String regId;
	private boolean isMarried;
	
	public Student(Name name, LocalDate birthday, Gender gender, TelephoneNumber telNum, LocalDate dateOfStart, boolean isMarried) throws NotMarriedException {
		super(name, birthday, gender, telNum);
		classes = new ArrayList<String>();
		if (regIdNumber == 999) {
			regIdNumber = 1;
		} else {
			regIdNumber++;
		}
		this.dateOfStart = dateOfStart;
		this.dateOfEnd = null;
		this.regId = dateOfStart.getYear() + "-" + String.format("%03d", regIdNumber);
		if (isMarried) {
			throw new NotMarriedException("Öğrenci Evlenemez");
			
		} else {
			this.isMarried = isMarried;
		}
	}
	
	public Student(Name name, LocalDate birthday, Gender gender, TelephoneNumber telNum, LocalDate dateOfStart, LocalDate dateOfEnd, boolean isMArried) throws NotMarriedException {
		super(name, birthday, gender, telNum);
		this.dateOfStart = dateOfStart;
		this.dateOfEnd = dateOfEnd;
		this.regId = dateOfStart.getYear() + "-" + String.format("%03d", regIdNumber);
		if (isMarried == true) {
			throw new NotMarriedException("Öğrenci Evlenemez");
		} else {
			this.isMarried = isMArried;
		}
	}
	
	public LocalDate getDateOfEnd() {
		return dateOfEnd;
	}
	
	public void setDateOfEnd(LocalDate dateOfEnd) {
		this.dateOfEnd = dateOfEnd;
	}
	
	public LocalDate getDateOfStart() {
		return dateOfStart;
	}
	
	public String getRegId() {
		return regId;
	}
	
	public String getClasses() {
		return this.getName() + "isimli öğrencinin sınıf listesi \n" + classes;
	}
	
	public void addClass(Class newClass) {
		this.classes.add(newClass.getName());
	}
	
	@Override
	public String toString() {
		return "Student [dateOfStart=" + dateOfStart + ", classes=" + classes + ", regId=" + regId + ", isMarried=" + isMarried + ", getName()=" + getName() + ", getBirthday()=" + getBirthday() + ", getGender()=" + getGender() + ", getTelNum()="
				+ getTelNum() + "]";
	}
	
}
