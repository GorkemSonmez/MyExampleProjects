
package com.bilgeadam.example.schoolmanagementsystem.util;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author $Görkem Sönmez
 */
public class Menu {
	static Scanner scan = new Scanner(System.in);
	
	public static int menu(TreeMap<Integer, String> menuItems) {
		boolean correctAnswer = true;
		int selection = -1;
		do {
			if (!correctAnswer) {
				System.err.println("\n\n\tLütfen doğru değer girin!\n\n");
			}
			showMenuItems(menuItems);
			selection = getUserSelection();
			correctAnswer = evaluateAnswer(menuItems, selection);
		} while (!correctAnswer);
		return selection;
	}
	
	private static boolean evaluateAnswer(TreeMap<Integer, String> menuItems, int selection) {
		return menuItems.containsKey(selection);
	}
	
	private static int getUserSelection() {
		return readInt("Lütfen Seçiminizi Yapın");
	}
	
	private static void showMenuItems(TreeMap<Integer, String> menuItems) { // en do�ru veri yap�s�
		Set<Entry<Integer, String>> items = menuItems.entrySet();
		for (Entry<Integer, String> entry : items) {
			System.out.println("\t(" + entry.getKey() + ") .... " + entry.getValue().trim());
		}
	}
	
	public static int readInt(String query) {
		System.out.print("\t" + query + ": ");
		do {
			boolean isDigit = true;
			String input = scan.next().trim();
			scan.nextLine();
			for (int i = 0; i < input.length(); i++) {
				if (!Character.isDigit(input.charAt(i))) {
					isDigit = false;
				}
			}
			if (isDigit)
				return Integer.parseInt(input + "");
			
		} while (true);
	}
	
}
