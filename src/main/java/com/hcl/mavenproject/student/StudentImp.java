package com.hcl.mavenproject.student;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class StudentImp {

	public static void main(String[] args) {
		start();
	}

	private static Set<Student> studentSet = new TreeSet<>(new Comparator<Student>() {
		public int compare(Student o1, Student o2) {
			return o1.getName().compareTo(o2.getName());
		}
	});

	public static void start() {
		Scanner scanner = new Scanner(System.in);
		studentSet.add(new Student("Serhan", 20, 1));
		studentSet.add(new Student("Alex", 21, 5));
		studentSet.add(new Student("Mary", 24, 4));
		studentSet.add(new Student("John", 22, 2));
		studentSet.add(new Student("Luci", 23, 3));

		boolean escape = true; // escape while loop
		int choice = 0;
		while (escape) {
			System.out.println(
					"Welcome. Please select from the following:\n1)Create\n2)Update\n3)Print\n4)Delete\n5)Exit ");
			choice = scanner.nextInt();
			switch (choice) {
			case 1: // Create
				createStudent(scanner);
				break;

			case 2: // Update
				updateStudent(scanner);
				break;

			case 3: // Print
				printStudents();
				break;

			case 4: // Delete
				deleteStudentByRollno(scanner);
				break;
			case 5: // Exit
				escape = false;
				break;
			default:
				invalidInput();
				break;
			}
		}
		System.out.println("Exiting now...");
	}

	private static boolean createStudent(Scanner scanner) {
		System.out.println("Creating new student...");
		System.out.print("Enter new Roll ID: ");
		int roll = scanner.nextInt();
		System.out.print("Enter new name: ");
		String name = scanner.next();
		System.out.print("Enter new age: ");
		int age = scanner.nextInt();

		Student student = checkIfStudentExist(roll);
		if (student != null) {
			System.out
					.print("Student " + student.getName() + " with Rollno " + student.getRollno() + " already exists");
			System.out.println();
			return false;
		}

		Student student1 = new Student(name, age, roll);
		studentSet.add(student1);
		System.out.println("Successfully added new student: ");
		System.out.println(
				"Name:" + student1.getName() + " Age:" + student1.getAge() + " Rollno:" + student1.getRollno());
		System.out.println();
		return true;
	}

	private static Boolean updateStudent(Scanner scanner) {
		System.out.println("Updating student...");
		System.out.print("Enter the Roll Number of the student you want to update: ");
		int rollno = scanner.nextInt();
		Student student = checkIfStudentExist(rollno);
		if (student != null) {
			System.out.println("Student is found: ");
			System.out.println(
					"Name:" + student.getName() + " Age:" + student.getAge() + " Rollno:" + student.getRollno());
			System.out.print("Enter the new name: ");
			student.setName(scanner.next());
			System.out.print("Enter the new age: ");
			student.setAge(scanner.nextInt());

			System.out.println("Successfully updated student...");
			System.out.println(
					"Name:" + student.getName() + " Age:" + student.getAge() + " Rollno:" + student.getRollno());
			return true;
		}
		System.out.println("Student with roll number " + rollno + " does not exist.");
		return false;
	}

	private static void printStudents() {
		System.out.println("Printing Students...");
		for (Student s : studentSet) {
			System.out.println(s.toString());
		}
	}

	private static boolean deleteStudentByRollno(Scanner scanner) {
		System.out.print("Enter the Roll Number of the student you want to delete: ");
		int rollno = scanner.nextInt();
		Student student = checkIfStudentExist(rollno);
		if (student != null) {
			System.out.print("Are you sure?(Y/N): ");
			char confirmation = scanner.next().charAt(0);
			if (confirmation == 'Y' || confirmation == 'y') {
				boolean isRemoved = studentSet.remove(student);
				if (isRemoved) {
					System.out.printf("Successfully removed");
					System.out.println();
					return true;
				}
			} else {
				System.out.println("No student was deleted");
				return false;
			}
		}
		System.out.println("Failed to remove student...");
		System.out.println();
		return false;
	}

	private static Student checkIfStudentExist(int rollno) {
		for (Student student : studentSet) {
			if (student.getRollno() == rollno) {
				return student;
			}
		}
		return null;
	}

	private static void invalidInput() {
		System.out.println("Invalid choice, try again");
	}
}
