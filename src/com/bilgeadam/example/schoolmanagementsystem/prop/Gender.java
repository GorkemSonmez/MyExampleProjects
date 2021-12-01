/**
 * 12 Eki 2021
 */
package com.bilgeadam.example.schoolmanagementsystem.prop;

import java.io.Serializable;

/**
 * @author $Görkem Sönmez
 *
 */
public enum Gender implements Serializable {
	E("Erkek"), B("Bayan");
	
	private final String gender;
	
	Gender(String gender) {
		this.gender = gender;
	}
	
	public String getGender() {
		return gender;
	}
	
}
