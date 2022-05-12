package com;

public class JavaVariable {
	public static void main(String[] args) {
		//co ban bien ham, cau dieu kien , vong lap
		// Number
		// so nguyen
		int a = 10;// 4byte ctrt + shif + f : format code can doi
		long b=100;//8byte
		short s = 128;//2byte
		
		byte t = 127; //1byte = 8 bit ( 0,1); 2^7 -1
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Short.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
		long tong = a+b;
		long hieu = a-b;
		long tich = a*b;
		long thuong = a / b;
		long phanDu = a % b ;
		System.out.println(thuong);
		System.out.println(phanDu);
		
		
		//ep kieu ep cao xuong thap
		int tong2 = a + (int) b;
		System.out.println(tong2);
		//chu y: kieu bien toi da co the chua dc la bao nhieu ( gia tri vuot qua kieu du lieu hay khong)
		/// so thuc
		float f = 10.4f; // F
		double d=10000.5; // mac dinh
		double tong3 = f + a;
		double ketQua = 5 / (double) 10;
		System.out.println(ketQua);
		float x = 1.25f;
		int phanNguyen = (int)x;
		System.out.println(phanNguyen);
		///dung sai
		boolean check = true; //false
		check = a > 10;///
		System.out.println(check);
		// ky tu primary
		char c = 'C';//1 nhay don
		char kyTu= '#';//1 nhay don
		//ASCII
		int cKey = (int)c;
		System.out.println(cKey);
		char dChar = (char)68;
		System.out.println(dChar);
		
		//String: ko phai kieu co ban: doi tuong
		String str = "Gia tri a "+a;
		System.out.println(str);
		
		
	}
}
