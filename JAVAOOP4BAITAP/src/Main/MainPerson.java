package Main;

import model.House;
import model.Person;

public class MainPerson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person(); // tao Person 
		p.input();
		
		House [] houses = new House[2]; //2 House
		for(int i = 0; i < houses.length; i++) {
			houses[i] = new House();
			houses[i].input();
			houses[i].setOwner(p); //  Set gia tri cho thuoc tinh Person trong cac doi tuong house 
			
		}
		for(House house : houses ) {
			house.infor();
			house.getOwner().infor();
		}
	//	p.getHouses()[0].getOwner().getHouses()[0].getOwner().getHouses()[0].getOwner();
	}

}
