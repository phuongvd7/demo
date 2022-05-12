package filejava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class BinaryFile {
	public static void main(String[] args) {
//		MonHoc van = new MonHoc();
//		van.setTenMonHoc("Van");
	//	writeFile(van);
		readFile();
	}
	// dung de luu file nhi phan 
		// khi implenment thang nay thi se sinh ra so version ID -> khi luu xuong va doc lai => se map 2 version ID voi nhau
	
	public static void writeFile(MonHoc mh) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("monhoc.txt");
			
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream); 
			
			objectOutputStream.writeObject(mh);
			
			objectOutputStream.close();
			
			fileOutputStream.close(); 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void readFile() {
		File file = new File("monhoc.txt"); // dung thu vien file de check xem file co ton tai hay khong// dong vai tro kiem tra
		// doc ghi file trong java co nhieu thu vien 
		// day la file text thuan, con co file nhi phan, file doi tuong
		if(file.exists()) {
			
			try {
				FileInputStream fileInputStream = new FileInputStream(file);// bat buoc phai try catch
				//doc lan luot tung ki tu trong file
				ObjectInputStream objectInputStream  = new ObjectInputStream(fileInputStream);
					 
				MonHoc mh = (MonHoc) objectInputStream.readObject();
				
				System.out.println(mh.getTenMonHoc());
				
				fileInputStream.close();
			} catch (IOException  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		} else 
			System.out.println("File ko ton tai");
	
	}
}
