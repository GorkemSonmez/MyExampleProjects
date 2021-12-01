/**
 * 1 Ara 2021
 */
package com.bilgeadam.example.schoolmanagementsystem.util;

/**
 * @author $Görkem Sönmez
 */
public class Utils {
	public static void header(String title) {
		// ===========
		// ** title **
		// ===========
		int len = title.length();
		StringBuilder row = new StringBuilder("");
		
		for (int i = 0; i < (len + 6); i++) {
			row.append("=");
		}
		
		System.err.println("\n\n\t\t" + row);
		System.err.println("\t\t** " + title.toUpperCase() + " **");
		System.err.println("\t\t" + row + "\n");
	}
}
