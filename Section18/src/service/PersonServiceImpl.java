package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import dao.CourseDAO;
import dao.PersonDAO;
import model.Course;
import model.Person;
import model.Student;
import model.Teacher;

public class PersonServiceImpl implements PersonService {
	
	@Override
	public void input(Person p) {
		System.out.println("Person INPUT");
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
	}
	
	
	@Override // them course vao file
	public void insert(Person p) {
		PersonDAO dao = new PersonDAO();
		try {
			dao.add(p);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("khong them duoc");
		}
	}

	@Override
	public void update(Person p) {
		PersonDAO dao = new PersonDAO();
		try {
			dao.update(p);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("khong update duoc");
		}
	}

	@Override
	public void delete(int id) {
		PersonDAO dao = new PersonDAO();// co the new thang course dao o tren dau , thi ko can new trong cac ham nua
		try {
			dao.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("khong xoa duoc");
		}
	}

	
	

	// doc ds nhung khoa hoc tu file/db
	@Override
	public List<Person> getAll() {
		PersonDAO dao = new PersonDAO();
		try {
			return dao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("xay ra loi");
		}
		return new ArrayList<>();
	}





	@Override
	public Person get(String code) {
		return null;
	}
	
}