import java.util.Scanner;

public class EmailValidation {

	public static void main(String[] args) {
		System.out.println("Nhap vao email");
		String s = new Scanner(System.in).nextLine();
		checkEmail(s);
	}

	public static void checkEmail(String email) {
		// test@gmail.com

		String parts[] = email.split("@");
		if (parts.length == 2) {
/// check part 0
			if (parts[0].length() >= 6 /* && parts[0].trim().length() == 1 && parts[1].trim().length() == 1 */) {
				if ((parts[0].split("\\s").length == 1) && parts[1].split("\\s").length == 1) {
					
					String name = parts[0].toLowerCase();
					boolean check = true;
					for(int i = 0 ; i < name.length(); i++) {
						char c = name.charAt(i);						
//						if ( c >= 'a' && c <= 'z') {
//						check = true;	
//						} else { 
//							check = false;
//								break;		
						
						if ( c < 'a' || c > 'z') {
						check = false;	
						break;
						} 
					}
					if(check ) {
					
					String subParts[] = parts[1].split("\\.");// dau . la ki tu dac biet nen can dau \\
					if (subParts.length >= 2) {
						System.out.println("email hop le");
						return;
					}
					
				}
			}
			
//ctrl + D  xoa 1 dong
// keo ca cac dong len xuong // boi den  giu phim alt + phim dieu huong		
		}System.out.println(" email khong hop le");
	}
}
	  public static void PhoneValidate(String phone) {
		  //0382192525
		  // co 10 so
		  //ky tu phai tu 0...9
		  if(phone.trim().length() == 10) {
			  if(phone.charAt(0) == '0') {
				  // ascii :
				  //
				  boolean check = true ;
				  for(int i = 1 ; i < phone.trim().length(); i++) {
					  char digit = phone.trim().charAt(i);
					  int key = (int) digit;
					  if(!(key>= 48 && key <= 57)) {
						  check = false;
					  }
				  }
			  }
		  }
	  }
}
//btvn viet ham validatephone

