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
public abstract class Person implements Serializable {
	private static final long serialVersionUID = -4072115255239211241L;
	private Name name;
	private LocalDate birthday;
	private Gender gender;
	private TelephoneNumber telNum;
	
	public Person(Name name, LocalDate birthday, Gender gender, TelephoneNumber telNum) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.telNum = telNum;
	}
	
	public Name getName() {
		return name;
	}
	
	public void setName(Name name) {
		this.name = name;
	}
	
	public LocalDate getBirthday() {
		return birthday;
	}
	
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public TelephoneNumber getTelNum() {
		return telNum;
	}
	
	public void setTelNum(TelephoneNumber telNum) {
		this.telNum = telNum;
	}
	
}
