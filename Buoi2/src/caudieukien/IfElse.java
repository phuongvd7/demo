package caudieukien;

public class IfElse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 10;
		check(x);//  a = x
	}

	public static void check(int a) {
		// > < >= == <= ==!
		// neu a > 0 == true  thi chay ben trong if
		if (a > 0) {
			System.out.println("so duong");
			System.out.println("a= " + a);
		}
		if (a < 0) 
			System.out.println("so am");
		if (a == 0) 
			System.out.println("a = 0");
	}
}
