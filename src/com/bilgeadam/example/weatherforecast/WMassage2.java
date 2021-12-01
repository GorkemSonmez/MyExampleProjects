package com.bilgeadam.example.weatherforecast;

public class WMassage2 {
	
	public static void massageWelcome(String massage) {
		
		int column = massage.length() + 4;
		int line = 9;
		System.out.print("\t\t");
		for (int i = 1; i <= column; i++) {
			System.out.print("♪");
			if (i == column) {
				System.out.println("");
			}
		}
		for (int i = 1; i <= (line - 1) / 2; i++) {
			System.out.print("\t\t♪");
			for (int j = 1; j <= massage.length() + 2; j++) {
				System.out.print(" ");
			}
			System.out.println("♪");
		}
		System.out.print("\t\t♪");
		System.out.print(" ");
		System.out.print(massage);
		System.out.print(" ");
		System.out.println("♪");
		for (int i = 1; i <= (line - 1) / 2; i++) {
			System.out.print("\t\t♪");
			for (int j = 1; j <= massage.length() + 2; j++) {
				System.out.print(" ");
			}
			System.out.println("♪");
			
		}
		System.out.print("\t\t");
		for (int i = 1; i <= column; i++) {
			System.out.print("♪");
			if (i == column) {
				System.out.println("");
			}
		}
		
	}
	
	public static void massageWelcome(String massage, int line, int plus) {
		
		int column = massage.length() + 4 + plus;
		
		System.out.print("\t\t");
		for (int i = 1; i <= column; i++) {
			System.out.print("♪");
			if (i == column) {
				System.out.println("");
			}
		}
		for (int i = 1; i <= (line - 1) / 2; i++) {
			System.out.print("\t\t♪");
			for (int j = 1; j <= massage.length() + 2 + plus; j++) {
				System.out.print(" ");
			}
			System.out.println("♪");
		}
		System.out.print("\t\t♪");
		System.out.print(" ");
		for (int l = 1; l <= plus / 2; l++) {
			System.out.print(" ");
		}
		System.out.print(massage);
		System.out.print(" ");
		for (int l = 1; l <= plus / 2; l++) {
			System.out.print(" ");
		}
		System.out.println("♪");
		for (int i = 1; i <= (line - 1) / 2; i++) {
			System.out.print("\t\t♪");
			for (int j = 1; j <= massage.length() + 2 + plus; j++) {
				System.out.print(" ");
			}
			System.out.println("♪");
			
		}
		System.out.print("\t\t");
		for (int i = 1; i <= column; i++) {
			System.out.print("♪");
			if (i == column) {
				System.out.println("");
			}
		}
		
	}
	
	public static void massageWelcome(String massage, int line, int plus, String ch) {
		
		int column = massage.length() + 4 + plus;
		
		System.out.print("\t\t");
		for (int i = 1; i <= column; i++) {
			System.out.print(ch);
			if (i == column) {
				System.out.println("");
			}
		}
		for (int i = 1; i <= (line - 1) / 2; i++) {
			System.out.print("\t\t" + ch);
			for (int j = 1; j <= massage.length() + 2 + plus; j++) {
				System.out.print(" ");
			}
			System.out.println(ch);
		}
		System.out.print("\t\t" + ch);
		System.out.print(" ");
		for (int l = 1; l <= plus / 2; l++) {
			System.out.print(" ");
		}
		System.out.print(massage);
		System.out.print(" ");
		for (int l = 1; l <= plus / 2; l++) {
			System.out.print(" ");
		}
		System.out.println(ch);
		for (int i = 1; i <= (line - 1) / 2; i++) {
			System.out.print("\t\t" + ch);
			for (int j = 1; j <= massage.length() + 2 + plus; j++) {
				System.out.print(" ");
			}
			System.out.println(ch);
			
		}
		System.out.print("\t\t");
		for (int i = 1; i <= column; i++) {
			System.out.print(ch);
			if (i == column) {
				System.out.println("");
			}
		}
		
	}
	
}
