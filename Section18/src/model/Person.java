package model;
import java.util.Date;
import java.util.Scanner;

public class Person { // khong can implement serializable vi ta luu vao database sql, not luu vao file
	private int id; // PK khoa chinh
	private int age;
	private String name;
	private Date birthDate;
	public Person() {
	}

	public Person(int Age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	protected void info() {
		System.out.println(name);
		System.out.println(age);
	}

	public void input() {
		System.out.println("nhap ten: ");
		name = new Scanner(System.in).nextLine();

		System.out.println("nhap tuoi: ");
		age = new Scanner(System.in).nextInt();

	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
