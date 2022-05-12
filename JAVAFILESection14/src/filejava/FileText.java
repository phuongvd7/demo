package filejava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String txt = "Hello Java";
		
		writeFile(txt);
		readFile();

	}
	public static void   writeFile(String s)  {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("text.txt");// thu vien
			
			byte[] bArr = s.getBytes();
			
			fileOutputStream.write(bArr);
			
			fileOutputStream.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public static void readFile() {
		File file = new File("text.txt"); // dung thu vien file de check xem file co ton tai hay khong// dong vai tro kiem tra
		// doc ghi file trong java co nhieu thu vien 
		// day la file text thuan, con co file nhi phan, file doi tuong
		if(file.exists()) {
			
			try {
				FileInputStream fileInputStream = new FileInputStream(file);// bat buoc phai try catch
				//doc lan luot tung ki tu trong file
				int c = fileInputStream.read();
				while(c != -1) {// boi vi khi nao doc het file thi no se tra ve -1
					 System.out.println((char) c); 
					 
					 c = fileInputStream.read(); 			
				}
				fileInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		} else 
			System.out.println("File ko ton tai");
	}
}
