package jmaster.io.model;

public class MainStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Student st1 = new Student();
//		Student st2 = new Student();
//		//// n student
//		int [] numbers =  new int[3];
		// numbers[0] .... 3-1
		Student[] studentArray = new Student[5]; // tao doi tuong mang chua student
		
//		studentArray[0] = st1;
//		studentArray[1] = new Student();
		
		//input
		for ( int i = 0 ; i < studentArray.length ; i++ ) {
			studentArray[i] = new Student();
			studentArray[i].input();
		}
		//info
		for (int i=0 ;  i < studentArray.length; i++) {
			studentArray[i].info();
		}
		//sap xep tang dan theo gia
		for( int i=0 ; i < studentArray.length-1 ; i++) {
			for ( int j = i + 1; j < studentArray.length ; j++) {
//				if ()
				
			}
			
		}
	}

}
