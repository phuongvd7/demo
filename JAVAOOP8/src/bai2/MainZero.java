package bai2;

import exception.ZeroException;

public class MainZero {


	public static void main(String[] args) {
		try {
			chia(22, 3);
		} catch (ZeroException e1) {
			System.out.println(e1.getError());
		}

	}

	public static void chia(int a, int b) throws ZeroException  {
		try {
			int c = a / b;

			System.out.println("ket qua = " + c);
		} catch (Exception e) {

			throw new ZeroException("Loi chia cho 0");
		}

	}
}