package dao;

import java.util.List;

import model.Course;
import service.CourseService;
import service.CourseServiceImpl;

public class test {
	public static void main(String[] args) {
		CourseService courseService = new CourseServiceImpl();
		List<Course> list = courseService.getAll();
		System.out.println(list);
	}
}
