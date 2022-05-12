package jmaster.io.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jmaster.io.model.Course;

public class CourseServiceImpl implements CourseService {

	@Override
	public void input(Course course) {
		// TODO Auto-generated method stub
		System.out.println("ID: ");
		course.setId(new Scanner(System.in).nextInt());

		System.out.println("Course Name: ");
		course.setName(new Scanner(System.in).nextLine());
	}

	@Override
	public void info(Course course) {
		System.out.println("Course Id " + course.getId());
		System.out.println("Course Name" + course.getName());
	}

	@Override // them course vao file
	public void insert(Course course) {
		// doc ra truoc
		List<Course> courseList = getAll();
		courseList.add(course);
		// ghi lai
		writeListFile(courseList);
	}
//ham statuc ko goi dc doi tuong nhung ham doi tuong goi dc thoai mai
	@Override
	public List<Course> getAll() {
		File file = new File("course.txt");

		if (file.exists()) {
			try {
				FileInputStream fileInputStream = new FileInputStream(file);// ham doc ra gia tri

				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

				List<Course> list = (List<Course>) objectInputStream.readObject();

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

}