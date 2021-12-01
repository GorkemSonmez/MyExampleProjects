/**
 * 18 Eki 2021
 */
package com.bilgeadam.example.schoolmanagementsystem.prop;

import java.io.Serializable;
import java.util.ArrayList;

import com.bilgeadam.example.schoolmanagementsystem.model.Student;
import com.bilgeadam.example.schoolmanagementsystem.model.Teacher;

/**
 * @author $Görkem Sönmez
 */
public class Class implements Serializable {
	private static final long serialVersionUID = 48104058639643817L;
	private String name;
	private Teacher teacher;
	private Teacher assistant;
	ArrayList<Name> students;
	
	public Class(String name, Teacher teacher, Teacher assistant) {
		super();
		students = new ArrayList<Name>();
		this.name = name;
		this.teacher = teacher;
		this.assistant = assistant;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public Teacher getAssistant() {
		return assistant;
	}
	
	public void setAssistant(Teacher assistant) {
		this.assistant = assistant;
	}
	
	public String getStudents() {
		return this.name + " sınıfı öğrenci listesi \n " + students;
	}
	
	public void setStudents(ArrayList<Name> students) {
		this.students = students;
	}
	
	public void addStudents(Student student) {
		this.students.add(student.getName());
	}
	
	@Override
	public String toString() {
		return "Class [name=" + name + ", teacher=" + teacher.getName() + ", assistant=" + assistant.getName() + getStudents() + "]";
	}
	
}
