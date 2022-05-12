package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Course;
import model.Person;
import model.Student;

public class StudentDAO {
	//PersonDAO dao = new PersonDAO();

	public void add(Student c) {

		String sql = "INSERT INTO student(person_id,student_code ) VALUE (?,?)";
		Connection conn = JDBCConnection.getConn();// mo connection
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, c.getId());
			ps.setString(2, c.getStudentCode());
			ps.executeUpdate();// thuc hien lenh update len
		} catch (SQLException e) {
			System.out.println("Loi insert !");
			e.printStackTrace();
			// get thong tin vao ham,vao cac dau hoi cham

		}
	}

	public void update(Student c) throws SQLException {

		String sql = "UPDATE student SET student_code = ? WHERE person_id = ?"; // person id la khoa chinh
		Connection conn = JDBCConnection.getConn();// mo connection
		PreparedStatement ps = conn.prepareStatement(sql);// get thong tin vao ham,vao cac dau hoi cham
		ps.setString(1, c.getStudentCode());
		ps.setInt(2, c.getId());
		ps.executeUpdate();
	}

	public void delete(int id)  {

		String sql = "DELETE FROM student WHERE person_id = ?";
		Connection conn = JDBCConnection.getConn();
		try {
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Loi delete !");
			e.printStackTrace();
		}

	}

	public List<Student> selectAll() throws SQLException { // phai join bang person va student thi moi du thong so
		String sql = "SELECT person_id, name, bDate, student_code FROM student INNER JOIN person ON student.person_id = person.id";
		Connection conn = JDBCConnection.getConn();// mo connection
		PreparedStatement ps = conn.prepareStatement(sql);// get thong tin vao ham,vao cac dau hoi cham , van dung bthg
															// dc neu khong co dau ?
		ResultSet rs = ps.executeQuery();

		List<Student> studentList = new ArrayList<Student>(); // tao mot list de xuat cac phan tu ra chu khong can next
																// tung thang mot
		while (rs.next()) {
			Student c = new Student();
			c.setId(rs.getInt("person_id")); // trong dau "" phai nhap chinh xac voi cot trong mysql
			c.setName(rs.getString("name"));// van co name vi no extend cua thang person
			// nhung thang dc get ra phai co o tren Select
			c.setBirthDate(rs.getDate("bDate"));
			c.setStudentCode(rs.getString("student_code"));
			studentList.add(c);
		}
		return studentList;
	}

	public List<Student> search(String name) throws SQLException {
		String sql = "SELECT person_id, name, birthdate, student_code FROM student INNER JOIN person "
				+ "ON student.person_id = person.id WHERE name LIKE ? ORDER BY name ASC";
		Connection conn = JDBCConnection.getConn();// mo connection
		PreparedStatement ps = conn.prepareStatement(sql);// get thong tin vao ham,vao cac dau hoi cham
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();

		List<Student> studentList = new ArrayList<Student>();
		while (rs.next()) { // rs.next => doc tung dong cua doi tuong 1, den khi nao het bang thi thoi
			Student c = new Student();
			c.setId(rs.getInt("id"));
			c.setName(rs.getString("name"));
			c.setBirthDate(rs.getDate("bDate"));
			studentList.add(c); // doc tung doi tuong sau do nem vao list
		}
		return studentList;
	}

	// student code la unique // khong can tra ve list, tra ve 1 thang cung dc
	public Student get(String studentCode) throws SQLException {
		String sql = "SELECT person_id, name, birthdate, student_code FROM student INNER JOIN person "
				+ "ON student.person_id = person.id WHERE student_code = ?";
		Connection conn = JDBCConnection.getConn();// mo connection
		PreparedStatement ps = conn.prepareStatement(sql);// get thong tin vao ham,vao cac dau hoi cham

		ResultSet rs = ps.executeQuery();
		while (rs.next()) { // rs.next => doc tung dong cua doi tuong 1, den khi nao het bang thi thoi
			Student c = new Student();
			c.setId(rs.getInt("id"));
			c.setName(rs.getString("name"));
			c.setBirthDate(rs.getDate("bDate"));
//		personList.add(c); // doc tung doi tuong sau do nem vao list
			return c;
		}
		return null;
	}
}
