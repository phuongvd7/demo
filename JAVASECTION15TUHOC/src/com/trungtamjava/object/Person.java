package com.trungtamjava.object;

public class Person {
	private int id;
	private String ten;
	
	
	public Person(int id, String ten) {
		super();
		this.id = id;
		this.ten = ten;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	
	@Override
	public boolean equals(Object obj) {
	if(obj instanceof Person) {
		Person p2 = ((Person) obj);
		if(p2.getId() == this.id) {
			return true;
		} else {
			return false;
		}	
	} else {
		return false;
	}
	
	}
	
}
