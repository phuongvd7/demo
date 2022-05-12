package jmaster.io.model;

import java.util.List;

public class Clazz {
	private int classId;
	private String className;

	// 1 lop cho 1 mon hoc

	private Course course;
	
	// 1 lop co 1 giao vien
	private Teacher teacher;
	//1 lop co nhieu hs
	private List<Student> students;

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
		
	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
}
