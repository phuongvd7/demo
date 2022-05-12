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
import dao.TeacherDAO;
import model.Person;
import model.Student;
import model.Teacher;

public class TeacherServiceImpl implements TeacherService {
	PersonService personService = new PersonServiceImpl();
	TeacherDAO teacherDAO = new TeacherDAO();
	PersonDAO personDAO = new PersonDAO();

	@Override
	public void info(Teacher p) {
		personService.info(p);
		System.out.println("Teacher major : " + p.getMajor());

	}

	@Override
	public void input(Teacher p) {
		personService.input(p);
		System.out.println("Teacher major: ");
		p.setMajor(new Scanner(System.in).nextLine());
	}

	@Override
	public void insert(Teacher p) {
		try {
			personDAO.add(p);
			teacherDAO.add(p);
		} catch (Exception e) {
			System.out.println("khong nhap duoc teacher");
			e.printStackTrace();
		}
	}

	@Override
	public void update(Teacher p) {
		try {
			teacherDAO.update(p);
			personDAO.update(p);
		} catch (Exception e) {
			System.out.println("khong update duoc teacher");
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) { // phai xoa thang foreign key truoc, thang PK xoa sau
		try {
			teacherDAO.delete(id);
			personDAO.delete(id); // rieng delete thi xoa thang phu truoc => xoa student
		} catch (SQLException e) {
			System.out.println("khong xoa duoc teacher");
			e.printStackTrace();
		}
	}

	@Override
	public List<Teacher> getAll() {
		TeacherDAO dao = new TeacherDAO();
		try {
			return teacherDAO.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}