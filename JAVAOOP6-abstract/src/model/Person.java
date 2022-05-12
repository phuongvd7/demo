package model;

import java.util.Scanner;

public abstract class Person {
// khi them abstract vao thi class person khong tao duoc doi tuong
	// ma chi ke thua dc thoi
	private int age;
	private String name;

	//class abstract thi co the tao ham abstract
	public abstract void salary(); // chi co khai bao + tham so truyen vao. ko co body
// mang muc dich cho class khac ke thua
	// khi da co ham abstract ==> bat buoc phai override lai ham salary o class con => student bao loi ngay
		
	
	
	public Person() {
	}

	public Person(int Age, String name) {
		super();
		this.age = age;
		this.name = name;
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
