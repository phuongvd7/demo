package Main;

import java.util.Scanner;

import model.Nation;
import model.Person;

public class MainNation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Nation nation = new Nation();
			nation.input();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Nhap so nguoi: ");
			int n = sc.nextInt();
			
			Person[] persons = new Person[n];
			
			for(int i = 0; i < persons.length; i++) {
				persons[i] = new Person();
				persons[i].input();
				persons[i].setNation(nation);
			}
			
			for(Person person : persons) {
				person.infor();
				person.getNation().info();
			}
		}
	}

