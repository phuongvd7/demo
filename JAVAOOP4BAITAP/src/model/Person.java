package model;

import java.util.Scanner;

public class Person {
	private int id;
	private String name;
	private int age;
	private House[] houses; //// quan he doi tuong 	1 nhieu
	private Nation nation;

	public Person() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public House[] getHouses() {
		return houses;
	}

	public void setHouses(House[] houses) {
		this.houses = houses;
	}

	public Nation getNation() {
		return nation;
	}

	public void setNation(Nation nation) {
		this.nation = nation;
	}

	// input
	public void input() {
		System.out.println("nhap thong tin person ");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id_Person: ");
//			id = sc.nextInt();
		this.setId(sc.nextInt());

		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter name_Person: ");
//			name = sc1.nextLine();
		this.setName(sc1.nextLine());

		Scanner sc2 = new Scanner(System.in);
		System.out.println("Enter age_Person: ");
//			age = sc2.nextInt();
		this.setAge(sc2.nextInt());
	}

	// infor
	public void infor() {
		System.out.println("----------------");
		System.out.println("Thong tin nguoi");
		System.out.println("id_Person: " + id + "| " + "name_Person: " + name + "| " + "age_Person: " + age);
	}
}
