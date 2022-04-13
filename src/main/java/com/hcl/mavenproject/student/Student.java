package com.hcl.mavenproject.student;

public class Student {

	private String name;
	private int age;
	private int rollno;

	public Student(String name, int age, int rollno) {
		this.name = name;
		this.age = age;
		this.rollno = rollno;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "Student{" + "rollno=" + rollno + ", name='" + name + '\'' + ", age=" + age + '}';
	}

}
