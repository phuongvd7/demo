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
import model.Teacher;

public class TeacherDAO {
	public void add(Teacher c)  {

		String sql = "INSERT INTO teacher(teacher_id, major ) VALUE (?,?)";		
		Connection conn = JDBCConnection.getConn();// mo connection
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			//get thong tin vao ham,vao cac dau hoi cham		
			ps.setInt(1,c.getId());
			ps.setString(2, c.getMajor());		// phai co id o trong mysql bang teacher thi moi getid dc
			ps.executeUpdate();// thuc hien lenh update len
		} catch (SQLException e) {
			System.out.println("Loi insert !");
			e.printStackTrace();
		}
		
	}
	
	public void update(Teacher c) {

		String sql = "UPDATE teacher SET major = ? WHERE teacher_id = ?"; // person id la khoa chinh ======================
		Connection conn = JDBCConnection.getConn();// mo connection
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			//get thong tin vao ham,vao cac dau hoi cham			
			ps.setString(1, c.getMajor());
			ps.setInt(2,c.getId());
			ps.executeUpdate();	
		} catch (SQLException e) {
			System.out.println("Loi update !");
			e.printStackTrace();
		}	
	}
	
	
	public void delete(int  id)  {

		String sql = "DELETE FROM teacher WHERE teacher_id = ?"; // phai co id o person
		Connection conn = JDBCConnection.getConn();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);		
			ps.executeUpdate();// thuc hien lenh update len
		} catch (SQLException e) {
			System.out.println("Loi xoa !");
			e.printStackTrace();
		}	
		
		
	}
	
	public List<Teacher> selectAll() throws SQLException { // phai join bang person va student thi moi du thong so			
		String sql = "SELECT teacher_id, name, bDate,major FROM teacher INNER JOIN person ON teacher.teacher_id = person.id";
		Connection conn = JDBCConnection.getConn();// mo connection
		PreparedStatement ps = conn.prepareStatement(sql);//get thong tin vao ham,vao cac dau hoi cham	, van dung bthg dc neu khong co dau ?
		ResultSet rs = ps.executeQuery();
		
		List<Teacher> teacherList = new ArrayList<Teacher>(); // tao mot list de xuat cac phan tu ra chu khong can next tung thang mot
		while(rs.next()) {
			Teacher c = new Teacher();		
			c.setId(rs.getInt("teacher_id")); // trong dau "" phai nhap chinh xac voi cot trong mysql
			c.setName(rs.getString("name"));// van co name vi no extend cua thang person 
			// nhung thang dc get ra phai co o tren Select
			c.setBirthDate(rs.getDate("bDate"));
			c.setMajor(rs.getString("major"));
			teacherList.add(c);
		}
		return teacherList;
	}
//	public List<Teacher> search(String name) throws SQLException {
//		String sql = "SELECT person.id, name, birthdate, student_code FROM student INNER JOIN person "
//				+ "ON student.person_id = person.id WHERE name LIKE ? ORDER BY name ASC";
//		Connection conn = JDBCConnection.getConn();// mo connection
//		PreparedStatement ps = conn.prepareStatement(sql);// get thong tin vao ham,vao cac dau hoi cham
//		ps.setString(1,name);
//		ResultSet rs = ps.executeQuery();
//
//		List<Teacher> teacherList = new ArrayList<Teacher>();
//		while (rs.next()) { // rs.next => doc tung dong cua doi tuong 1, den khi nao het bang thi thoi
//			Teacher c = new Teacher();
//			c.setId(rs.getInt("id"));
//			c.setName(rs.getString("name"));
//			c.setBirthDate(rs.getDate("bDate"));
//			teacherList.add(c); // doc tung doi tuong sau do nem vao list
//		}
//	return teacherList;
//}
//	//student code la unique // khong can tra ve list, tra ve 1 thang cung dc
//	public Teacher get(String teacherCode) throws SQLException {
//		String sql = "SELECT person.id, name, birthdate, student_code FROM teacher INNER JOIN person "
//				+ "ON student.person_id = person.id WHERE student_code = ?";
//		Connection conn = JDBCConnection.getConn();// mo connection
//		PreparedStatement ps = conn.prepareStatement(sql);// get thong tin vao ham,vao cac dau hoi cham
//	
//	
//		ResultSet rs = ps.executeQuery();
//		while (rs.next()) { // rs.next => doc tung dong cua doi tuong 1, den khi nao het bang thi thoi
//			Teacher c = new Teacher();
//			c.setId(rs.getInt("id"));
//			c.setName(rs.getString("name"));
//			c.setBirthDate(rs.getDate("bDate"));
////		personList.add(c); // doc tung doi tuong sau do nem vao list
//			return c;
//		}
//	return null;
//}
}

