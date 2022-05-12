package model;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Nguoi.Quoctich =  "VietNam"; //la 1 bien nen cho vao " "
		new Nguoi(); // dang sau new nay` la contructor => la` mot new class
		new Nguoi();
		Nguoi p1 = new Nguoi();// khi da khai bao contructor thi chac chan ham mat ==> phai su dung ham minh nhap vao
		Nguoi p2 = new Nguoi();
		Nguoi p3 = new Nguoi(10);
		System.out.println(p1.Quoctich);
		System.out.println(p2.Quoctich);
		p2.Quoctich = "TrungQuoc";// static =>>> thay doi 1 thang la tat ca cac bien deu thay doi theo => share cho tat ca doi tuong tao ra tu class ay
		// ==> bien static ko the mo phong doi tuong rieng , chi mo phong chung
		System.out.println(p1.Quoctich);
		System.out.println(p2.Quoctich);
		// thuoc tinh rieng
		p2.Age = 10;
		p2.Gender = "Nam";
		p2.Name = "Long";
		
		p1.Age = 5;
		p1.Gender = "Nu";
		p1.Name = "Mai";
		System.out.println(p1.Name);
		System.out.println(p2.Name);
		System.out.println(p1.Gender);
		System.out.println(p2.Gender);
		System.out.println(" Nhap thong tin p1");
		p1.input();
		
		System.out.println(" Nhap thong tin p2");
		p2.input();
		
		System.out.println(" P1 va p2 lan luot la");
		p1.info();
		p2.info();
		
	}

}
//btvn lam lai mot vai doi tuong  nhu laptop
//if else >= 8 <= 20>