/**
 * 18 Eki 2021
 */
package com.bilgeadam.example.schoolmanagementsystem.prop;

import java.io.Serializable;

/**
 * @author $Görkem Sönmez
 */
public class Name implements Serializable {
	private static final long serialVersionUID = -1794356898036246163L;
	private String firstName;
	private String middleName;
	private String lastName;
	
	public Name(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = "";
	}
	
	public Name(String firstName, String middleName, String lastName) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		if (middleName.equals("")) {
			return "[" + firstName + " " + lastName + "]";
		} else {
			return "[" + firstName + " " + middleName + " " + lastName + "]";
		}
		
	}
	
	public String getFirstname() {
		return firstName;
	}
	
	public String getMiddlename() {
		return middleName;
	}
	
	public String getLastname() {
		return lastName;
	}
	
}
