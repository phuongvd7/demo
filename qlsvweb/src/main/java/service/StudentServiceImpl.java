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

import dao.PersonDAO;
import dao.StudentDAO;
import model.Person;
import model.Student;
import model.Teacher;

public class StudentServiceImpl implements StudentService {
	PersonService personService = new PersonServiceImpl();
	StudentDAO studentDAO = new StudentDAO();
	PersonDAO personDAO = new PersonDAO();
	@Override
	public void info(Student p) {
		personService.info(p);
		System.out.println("Student code : " + p.getStudentCode());
	
	}
	@Override
	public void input(Student p) {
		personService.input(p);
		System.out.println("Student code: ");
		p.setStudentCode(new Scanner(System.in).nextLine());
	}
	@Override
	public void insert(Student p) {
		try {
		personService.insert(p);
		studentDAO.add(p);
	} catch (Exception e) {
		System.out.println("khong nhap duoc student");
	}
		}
	
	@Override
	public void update(Student p) {
		try {
		personDAO.update(p);
		studentDAO.update(p);
	} catch (Exception e) {
		System.out.println("khong update duoc student");
	}
	}

	@Override
	public void delete(int id) { // phai xoa thang foreign key truoc, thang PK xoa sau
		try {
		studentDAO.delete(id);
		personDAO.delete(id);   // rieng delete thi xoa thang phu truoc => xoa student
	} catch (Exception e) {
		System.out.println("khong nhap duoc student");
	}
	}

	
	@Override
	public List<Student> getAll() {
		StudentDAO dao = new StudentDAO();
		try {
			return dao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("xay ra loi");
		}
		return new ArrayList<>();
	}



}