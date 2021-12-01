/**
 * 18 Eki 2021
 */
package com.bilgeadam.example.schoolmanagementsystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

import com.bilgeadam.example.schoolmanagementsystem.exeption.NotMarriedException;
import com.bilgeadam.example.schoolmanagementsystem.model.Employee;
import com.bilgeadam.example.schoolmanagementsystem.model.Officer;
import com.bilgeadam.example.schoolmanagementsystem.model.Student;
import com.bilgeadam.example.schoolmanagementsystem.model.Teacher;
import com.bilgeadam.example.schoolmanagementsystem.model.Worker;
import com.bilgeadam.example.schoolmanagementsystem.prop.Class;
import com.bilgeadam.example.schoolmanagementsystem.prop.Gender;
import com.bilgeadam.example.schoolmanagementsystem.prop.Name;
import com.bilgeadam.example.schoolmanagementsystem.prop.TelephoneNumber;
import com.bilgeadam.example.schoolmanagementsystem.util.Menu;
import com.bilgeadam.example.schoolmanagementsystem.util.Utils;

/**
 * @author $Görkem Sönmez
 */
public class Main {
	
	public static void main(String[] args) {
		Main test = new Main();
		test.start();
		
	}
	
	ArrayList<Employee> employeeList = new ArrayList<>();
	ArrayList<Employee> oldEmployeeList = new ArrayList<>();
	HashMap<String, Class> classList = new HashMap<>();
	HashMap<Integer, Name> salaryList = new HashMap<>();
	
	public void start() {
		
		Utils.header("OKUL YÖNETİM SİSTEMİNE HOŞGELDİNİZ");
		Teacher teacher1 = new Teacher(new Name("Ali", "Öğretmen"), LocalDate.of(1980, 10, 8), Gender.E, LocalDate.of(2020, 5, 5), LocalDate.of(2020, 8, 5), true, 3000.0, new TelephoneNumber("05458088088", "02122708758"));
		Teacher teacher2 = new Teacher(new Name("Ayşe", "Öğretmen"), LocalDate.of(1980, 5, 5), Gender.B, LocalDate.of(2020, 5, 5), LocalDate.of(2020, 9, 5), true, 3000.0, new TelephoneNumber("05458088088", "02122708758"));
		oldEmployeeList.add(teacher1);
		oldEmployeeList.add(teacher2);
		Teacher teacher3 = new Teacher(new Name("Ahmet", "Öğretmen"), LocalDate.of(1980, 5, 13), Gender.E, LocalDate.now(), true, 3500.0, new TelephoneNumber("05458088088", "02122708758"));
		Teacher teacher4 = new Teacher(new Name("Fatma", "Öğretmen"), LocalDate.of(1980, 5, 5), Gender.B, LocalDate.now(), true, 3000.0, new TelephoneNumber("05458088088", "02122708758"));
		Worker worker1 = new Worker(new Name("Worker", "One"), LocalDate.of(1980, 5, 5), Gender.E, LocalDate.of(2020, 5, 5), true, 4000.0, new TelephoneNumber("05458088088", "02122708758"));
		Worker worker2 = new Worker(new Name("Worker", "Two"), LocalDate.of(1980, 5, 5), Gender.E, LocalDate.of(2020, 5, 5), true, 5000.0, new TelephoneNumber("05458088088", "02122708758"));
		Officer officer1 = new Officer(new Name("Officer", "One"), LocalDate.of(1980, 5, 5), Gender.E, LocalDate.of(2020, 5, 5), true, 6000.0, new TelephoneNumber("05458088088", "02122708758"));
		Officer officer2 = new Officer(new Name("Officer", "Two"), LocalDate.of(1980, 5, 5), Gender.E, LocalDate.of(2020, 5, 5), true, 7000.0, new TelephoneNumber("05458088088", "02122708758"));
		employeeList.add(teacher3);
		employeeList.add(teacher4);
		employeeList.add(worker1);
		employeeList.add(worker2);
		employeeList.add(officer1);
		employeeList.add(officer2);
		salaryList.put((int) teacher3.getSalary(), teacher3.getName());
		salaryList.put((int) teacher4.getSalary(), teacher4.getName());
		salaryList.put((int) worker1.getSalary(), worker1.getName());
		salaryList.put((int) worker2.getSalary(), worker2.getName());
		salaryList.put((int) officer1.getSalary(), officer1.getName());
		salaryList.put((int) officer2.getSalary(), officer2.getName());
		Student student1 = null;
		try {
			student1 = new Student(new Name("Ali", "Veli"), LocalDate.of(2005, 5, 5), Gender.E, new TelephoneNumber("111", "222", "333"), LocalDate.of(2021, 5, 5), false);
		} catch (NotMarriedException e) {
			
			e.printStackTrace();
		}
		Student student2 = null;
		try {
			student2 = new Student(new Name("Ayşe", "Fatma"), LocalDate.of(2005, 5, 5), Gender.B, new TelephoneNumber("444", "555", "666"), LocalDate.of(2021, 5, 5), false);
		} catch (NotMarriedException e) {
			
			e.printStackTrace();
		}
		
		Class mathClass1 = new Class("Matematik Sınıfı-1", teacher3, teacher4);
		Class mathClass2 = new Class("Matematik Sınıfı-2", teacher4, teacher3);
		classList.put(mathClass1.getName(), mathClass1);
		classList.put(mathClass2.getName(), mathClass2);
		
		mathClass1.addStudents(student1);
		mathClass1.addStudents(student2);
		
		student1.addClass(mathClass1);
		student1.addClass(mathClass2);
		student2.addClass(mathClass1);
		student2.addClass(mathClass2);
		
		TreeMap<Integer, String> menuItems = new TreeMap<>();
		while (true) {
			menuItems.put(1, "Yeni Çalışan");
			menuItems.put(2, "Çalışan Listesi");
			menuItems.put(3, "Eski Çalışanlar");
			menuItems.put(4, "Yeni Sınıf");
			menuItems.put(5, "Öğrenci Atama");
			menuItems.put(6, "Sınıf Listesi");
			menuItems.put(7, "Öğrencinin Katıldığı Sınıflar");
			menuItems.put(8, "Hediye Listesi");
			menuItems.put(9, "Maaş Listesi");
			menuItems.put(10, "Uygulamadan Çıkış");
			
			int selection = Menu.menu(menuItems);
			dataCreateOrRead();
			
			if (selection == 1) {
				addEmployee();
				System.out.println("\tYeni Çalışanlar Yüklendi");
			} else if (selection == 2) {
				
				employeeList.forEach(System.out::println);
			} else if (selection == 3) {
				oldEmployeeList.forEach(System.out::println);
			} else if (selection == 4) {
				Class geoClass = new Class("Coğrafya Sınıfı-1", teacher3, teacher4);
				System.out.println("Yeni Sınıf Yaratıldı: " + geoClass.getName());
				geoClass.addStudents(student1);
				geoClass.addStudents(student2);
				student1.addClass(geoClass);
				student1.addClass(geoClass);
				classList.put(geoClass.getName(), geoClass);
				System.out.println(student1.getName() + " ve " + student2.getName() + " yeni yaratılan sınıfa eklendi");
				System.out.println("Yeni Sınıf bilgileri: " + geoClass);
			} else if (selection == 5) {
				Student student3 = null;
				try {
					student3 = new Student(new Name("Nil", "Zeynep"), LocalDate.of(2005, 8, 17), Gender.B, new TelephoneNumber("444", "555", "666"), LocalDate.of(2021, 5, 5), false);
				} catch (NotMarriedException e) {
					
					e.printStackTrace();
					break;
				}
				student3.addClass(mathClass2);
				mathClass2.addStudents(student3);
				System.out.println("Yeni öğrenci " + student3.getName() + " " + mathClass2.getName() + " sınıfına eklendi");
			} else if (selection == 6) {
				Scanner scan = new Scanner(System.in);
				System.out.println("\tSınıf Adı Girin");
				String className = scan.nextLine();
				if (classList.get(className) == null) {
					System.out.println("\tBöyle bir sınıf yok");
					continue;
				}
				System.out.println(classList.get(className));
			} else if (selection == 7) {
				
			} else if (selection == 8) {
				gift();
			} else if (selection == 9) {
				System.out.println(salaryList);
			} else if (selection == 10) {
				Scanner scan = new Scanner(System.in);
				System.out.println("\tÇıkmak istiyorsanız 1 Girin");
				int select = scan.nextInt();
				if (select == 1) {
					dataWrite();
					System.out.println("Veriler C:\\bilgeadam\\dizinine kaydedildi");
					System.out.println("\tProgramdan Çıkılıyor...Görüşmek üzere");
					break;
				}
				
			}
			
		}
		
	}
	
	public void addEmployee() {
		
		Teacher teacher5 = new Teacher(new Name("Görkem", "Öğretmen"), LocalDate.of(1992, 10, 27), Gender.E, LocalDate.now(), true, 3200.0, new TelephoneNumber("05458088088", "02122708758"));
		employeeList.add(teacher5);
		Teacher teacher6 = new Teacher(new Name("Selen", "Öğretmen"), LocalDate.of(1992, 06, 24), Gender.B, LocalDate.now(), true, 3800.0, new TelephoneNumber("05458088088", "02122708758"));
		employeeList.add(teacher6);
		salaryList.put((int) teacher5.getSalary(), teacher5.getName());
		salaryList.put((int) teacher6.getSalary(), teacher6.getName());
	}
	
	public void gift() {
		System.out.println("Bugün Hediye Alacaklar Listesi\n");
		for (int i = 0; i < employeeList.size(); i++) {
			int dayOfMonth = employeeList.get(i).getBirthday().getDayOfMonth();
			int monthOfYear = employeeList.get(i).getBirthday().getMonth().getValue();
			if ((dayOfMonth == LocalDate.now().getDayOfMonth() && monthOfYear == LocalDate.now().getMonthValue()) || (LocalDate.now().getDayOfMonth() == employeeList.get(i).getDateOfStart().getDayOfMonth()
					&& LocalDate.now().getMonthValue() == employeeList.get(i).getDateOfStart().getMonthValue() && LocalDate.now().getYear() == employeeList.get(i).getDateOfStart().getYear())) {
				System.out.println(employeeList.get(i).getName());
				
			}
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void dataCreateOrRead() {
		File file = new File("C:\\bilgeadam\\OYS.data");
		FileOutputStream fos;
		if (file.exists()) {
			try {
				// ArrayList<Employee> employeeList = new ArrayList<>();
				// ArrayList<Employee> oldEmployeeList = new ArrayList<>();
				// HashMap<String, Class> classList = new HashMap<>();
				// HashMap<Integer, Name> salaryList = new HashMap<>();
				
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				employeeList = (ArrayList<Employee>) ois.readObject();
				ois.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
			try {
				fos = new FileOutputStream(file);
				fos.close();
			} catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public void dataWrite() {
		File file = new File("C:\\bilgeadam\\OYS.data");
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
			
			oos.writeObject(employeeList);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
}
