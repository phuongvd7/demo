import java.util.Scanner;

public class EmailCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(" moi nhap vao mang ");
			String s = new Scanner(System.in).nextLine(); // cach nhap vao 1 mang tu ban phim
//		String s = "J@J";
//		String [] papa = s.split("@");
//		System.out.println(papa.length);
		checkMail(s);
			String a = "java";
			String b = "hello";
			String c = "master";
//			String a1 = a.concat(b).concat(c);
//			System.out.println(a1);
			
		
	}
	
	public static void checkMail(String mail) {
		// test@jmaster.io
		// chua 2 phan string truoc va sau @
		// chua 1 cai @ va dau .
		// sau @ co dau .
		// trc @ phai co string > 0
		
		String[] parts =  mail.split("@");
		if (parts.length == 2 ) {
			if(parts[0].trim().length() > 0 && parts[1].trim().length() > 0) {
				if (parts[1].trim().contains(".")) {
					System.out.println("email hop le");
//					return true;
				}
			}
			
		}
//		else return false;
		else System.out.println("email ko hop le");
	}
}
