package bai2;

public class Main {

	public static void main(String[] args) {

		/*
		 * Employee emp = new Employee() { // phai new truoc roi moi anomynous dc
		 * 
		 * @Override public void salary() { // doi voi anomynous thi khai bao duoc thuoc
		 * tinh moi, nhung khong goi dc, chi override ham //anomunous chi dung cho TH
		 * can khai bao 1 class con ma dung lai 1 lan duy nhat // 
		 * //anomynous dung dc cho ca interface va class // cu phap new 1 interface moi roi viet ham
		  super.salary();
		  System.out.println("Luong: 10.000.000 VND anomynous"); 
		  } 
		  };
//		 emp.salary();
		 
		  }
		 */
		Employee e = new Employee() {

			public void salary() {
				System.out.println("Luong 10 cu");
				super.salary();

				

			}
		};// chu y phai co dau phay
		e.salary();
	}
}