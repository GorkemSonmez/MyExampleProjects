/**
 * 13 Eki 2021
 */
package com.bilgeadam.example.schoolmanagementsystem.exeption;

/**
 * @author $Görkem Sönmez
 */
public class NotMarriedException extends Exception {
	
	private static final long serialVersionUID = -3051097221805889189L;
	
	public NotMarriedException(String errorMessage) {
		super(errorMessage);
	}
	
	public static void main(String[] args) throws NotMarriedException {
		throw new NotMarriedException("bjdsıajdjas");
	}
	
}
