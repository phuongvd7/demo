package filejava;

import java.io.Serializable;
import java.util.Scanner;

public class Lop implements Serializable {// dung de luu file nhi phan 
	// khi implenment thang nay thi se sinh ra so version ID -> khi luu xuong va doc lai => se map 2 version ID voi nhau
	private String tenLop;
	private int soLuongSV;
	
//	private MonHoc monHoc; // null //// khai bao quan he doi tuong // quan he 1 - 1
	
//	private Student[] students ;// khai bao quan he doi tuong // quan he 1 - nhieu

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public int getSoLuongSV() {
		return soLuongSV;
	}

	public void setSoLuongSV(int soLuongSV) {
		this.soLuongSV = soLuongSV;
	}

//	public MonHoc getMonHoc() {
//		return monHoc;
//	}
//
//	public void setMonHoc(MonHoc monHoc) {
//		this.monHoc = monHoc;
//	}
//
//	public Student[] getStudents() {
//		return students;
//	}
//
//	public void setStudents(Student[] students) {
//		this.students = students;
//	}
	
	public void info() {
		System.out.println(tenLop);
		System.out.println(soLuongSV);
	}
	
	public void input() {
		System.out.println("ten Lop ");
		tenLop = new Scanner(System.in).nextLine();
		
		System.out.println("So luong SV ");
		soLuongSV = new Scanner(System.in).nextInt();
	}
}
