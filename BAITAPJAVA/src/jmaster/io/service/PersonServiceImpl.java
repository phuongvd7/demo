package jmaster.io.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import jmaster.io.model.Course;
import jmaster.io.model.Person;
import jmaster.io.model.Student;
import jmaster.io.model.Teacher;

public class PersonServiceImpl implements PersonService {

	@Override
	public void input(Person p) {
		System.out.println("nhap tuoi: ");
		p.setAge(new Scanner(System.in).nextInt());

		System.out.println("nhap id: ");
		p.setId(new Scanner(System.in).nextInt());

		System.out.println("nhap  Name: ");
		p.setName(new Scanner(System.in).nextLine());

		while (true) {
			try {// dinh dang ngay thang nam thi nen try catch vi co the danh nham, con string thi dau can check =))
				System.out.println("BirthDate (dd/mm/yyyy): ");
				String sDate = new Scanner(System.in).nextLine();
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				p.setBirthDate(formatter.parse(sDate));
				break;
			} catch (ParseException e) {
				e.printStackTrace();
				System.out.println("Nhap sai, nhap lai");
			}
		}
	}

		
	@Override
	public void info(Person p) {
		System.out.println(" Id: " + p.getId());
		System.out.println(" Age: " + p.getAge());
		System.out.println(" Name: " + p.getName());
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM, yyyy HH:mm", new Locale("vi"));
		System.out.println(formatter.format(p.getBirthDate()));

		if (p instanceof Student) {// true
			System.out.println("Student INFO");
			Student st = (Student) p;

			System.out.println(st.getStudentCode());
		}
		if (p instanceof Teacher) {
			System.out.println("Teacher INFO");
			Teacher tea = (Teacher) p;

			System.out.println(tea.getMajor());

		}
	}

	// ghi ds xuong file
	public void writeListStudentFile(List<Student> mhList) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("Student.txt");

			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

			objectOutputStream.writeObject(mhList);

			objectOutputStream.close();
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeListTeacherFile(List<Teacher> mhList) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("Teacher.txt");

			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

			objectOutputStream.writeObject(mhList);

			objectOutputStream.close();
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override // them course vao file
	public void insert(Person p) {
		if (p instanceof Student) {
			Student st = (Student) p;
			// doc ra truoc
			List<Student> list = getAllStudents();
			list.add(st);
			// ghi lai
			writeListStudentFile(list);
		}

		if (p instanceof Teacher) {
			Teacher tea = (Teacher) p;
			// doc ra truoc
			List<Teacher> list = getAllTeachers();
			list.add(tea);
			// ghi lai
			writeListTeacherFile(list);
		}
	}


		@Override
		public List<Student> getAllStudents() {
			File file = new File("Student.txt");

			if (file.exists()) {
				try {
					FileInputStream fileInputStream = new FileInputStream(file);// ham doc ra gia tri

					ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

					List<Student> list = (List<Student>) objectInputStream.readObject();

					objectInputStream.close();
					fileInputStream.close();

					return list;
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			} else
				System.out.println("File ko ton tai");

			return new ArrayList<>(); // vector, array list// 2 doi tuong khac nhau
		}
	

	@Override
	public List<Teacher> getAllTeachers() {
		File file = new File("Teacher.txt");

		if (file.exists()) {
			try {
				FileInputStream fileInputStream = new FileInputStream(file);// ham doc ra gia tri

				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

				List<Teacher> list = (List<Teacher>) objectInputStream.readObject();

				objectInputStream.close();
				fileInputStream.close();

				return list;
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else
			System.out.println("File ko ton tai");

		return new ArrayList<>(); // vector, array list// 2 doi tuong khac nhau
// viet menu teacher rieng, student rieng
	}
}