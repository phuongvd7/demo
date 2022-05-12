package main;

import model.Lop;
import model.MonHoc;
import model.Student;

public class MainLopHoc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MonHoc cnpm = new MonHoc();
		cnpm.setTenMonHoc("cnpm");

//		Lop cnpm1 = new Lop();
//		Lop cnpm1 = new Lop();
//		Lop cnpm1 = new Lop();
//		Lop cnpm1 = new Lop();
//		Lop cnpm1 = new Lop();
		Lop[] danhSachLop = new Lop[5];

		System.out.println("INPUT LOP");
		for (int i = 0; i < danhSachLop.length; i++) {
			danhSachLop[i] = new Lop();
			danhSachLop[i].input();
			danhSachLop[i].setMonHoc(cnpm);
		}

		System.out.println("INFO LOP");
		for (int i = 0; i < danhSachLop.length; i++) {
			danhSachLop[i].info();
			danhSachLop[i].getMonHoc().getTenMonHoc();
			System.out.println("_______");
		}

//		for(Lop loppp : danhSachLop) {
//			//lop = danhSachLop[i]
//			loppp.info();
//			System.out.println(loppp.getMonHoc().getTenMonHoc());
//		}

		// ds sinh vien
		Student[] studentArray = new Student[2];
		System.out.println("INPUT student");

		for (int i = 0; i < studentArray.length; i++) {
			studentArray[i] = new Student();
			studentArray[i].input();
		}

		/// fix cung sinh vien cho lop 0
		danhSachLop[0].setStudents(studentArray);

		System.out.println("Infor Lop kem sinh vien");
		System.out.println("_______________________");
		for (Lop lop : danhSachLop) {
			// lop = danhSachLop[i[
			lop.info();
			System.out.println(lop.getMonHoc().getTenMonHoc());

			// ktra lop co sinh vien khong?
			if (lop.getStudents() != null) { //if (lop.getStudents().length != 0) {
				for (Student st : lop.getStudents()) {
					st.info();
					
				}
			}
			System.out.println("______");

		}
	}
}
