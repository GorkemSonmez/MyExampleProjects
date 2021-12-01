/**
 * 18 Eki 2021
 */
package com.bilgeadam.example.schoolmanagementsystem.prop;

import java.io.Serializable;

/**
 * @author $Görkem Sönmez
 */
public class TelephoneNumber implements Serializable {
	private static final long serialVersionUID = -4088665831104734362L;
	private String homeNum;
	private String mobileNum;
	private String parentNum;
	
	public TelephoneNumber(String homeNum, String mobileNum) {
		super();
		this.homeNum = homeNum;
		this.mobileNum = mobileNum;
		this.parentNum = " ";
	}
	
	public TelephoneNumber(String homeNum, String mobileNum, String parentNum) {
		super();
		this.homeNum = homeNum;
		this.mobileNum = mobileNum;
		this.parentNum = parentNum;
	}
	
	@Override
	public String toString() {
		if (mobileNum.equals(" ")) {
			return "TelephoneNumber [homeNum=" + homeNum + ", mobileNum=" + mobileNum + "]";
		} else {
			return "TelephoneNumber [homeNum=" + homeNum + ", mobileNum=" + mobileNum + ", parentNum=" + parentNum + "]";
		}
	}
	
}
