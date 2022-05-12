package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.CourseDAO;
import model.Course;

public class CourseServiceImpl implements CourseService {

	@Override

	public void input(Course course) {
		while (true) {
			try {
				System.out.println("ID: ");
				course.setId(new Scanner(System.in).nextInt());
				break;
			} catch (Exception e) {
				System.out.println("nhap sai, nhap lai so");

			}
		}
		System.out.println("Course Name: ");
		course.setName(new Scanner(System.in).nextLine());
	}

	@Override
	public void info(Course course) {
		System.out.println("Course Id " + course.getId());
		System.out.println("Course Name" + course.getName());
	}

//ham statuc ko goi dc doi tuong nhung ham doi tuong goi dc thoai mai
	@Override
	public List<Course> getAll() {
		CourseDAO dao = new CourseDAO();
		try {
			return dao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("xay ra loi");
		}
		return new ArrayList<>();
	}

// ghi ds xuong file
	public void writeListFile(List<Course> mhList) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("course.txt");

			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

			objectOutputStream.writeObject(mhList);

			objectOutputStream.close();
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override // them course vao file
	public void insert(Course course) {
		CourseDAO dao = new CourseDAO();
		try {
			dao.add(course);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("khong them duoc");
		}
	}

	@Override
	public void update(Course course) {
		CourseDAO dao = new CourseDAO();
		try {
			dao.update(course);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("khong update duoc");
		}
	}

	@Override
	public void delete(int id) {
		CourseDAO dao = new CourseDAO();// co the new thang course dao o tren dau , thi ko can new trong cac ham nua
		try {
			dao.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("khong xoa duoc");
		}

	}

}