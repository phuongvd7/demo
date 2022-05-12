package service;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.PersonDAO;
import dao.TeacherDAO;
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
		}
	}

	@Override
	public void update(Teacher p) {
		try {
			personDAO.update(p);
			teacherDAO.update(p);
		} catch (Exception e) {
			System.out.println("khong update duoc teacher");
		}
	}

	@Override
	public void delete(int id) { // phai xoa thang foreign key truoc, thang PK xoa sau
		try {
			teacherDAO.delete(id);
			personDAO.delete(id); // rieng delete thi xoa thang phu truoc => xoa student
		} catch (Exception e) {
			System.out.println("khong xoa duoc teacher");
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