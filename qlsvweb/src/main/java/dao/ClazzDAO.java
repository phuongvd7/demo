package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Clazz;
import model.Course;

public class ClazzDAO {
	public void add(Clazz c)  {

		String sql = "INSERT INTO clazz(idclazz, name, course_id) VALUE (?,?,?)";

		Connection conn = JDBCConnection.getConn();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, c.getId());
			ps.setString(2, c.getName());
			ps.setInt(3, c.getCourse().getId());// neu khai bao trong bang clazz co id roi thi thoi => chua co thi phai
												// get cua bang course vao de do mat cong, do trung
			// vi trong sql ko luu dc doi tuong, chi luu cot => muon lay id cua bang khac
			// thi get bang khac + get cot cua bang khac
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("loi insert");
		}
	}

	public void update(Clazz c)  {
		String sql = "UPDATE clazz SET name = ? WHERE idclazz = ?"; // khoa chinh thi thuong khong can update
		Connection conn = JDBCConnection.getConn();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, c.getId());
			ps.setString(2, c.getName());
			ps.setInt(3, c.getCourse().getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Loi update");
		}
	}

	public void delete(int id)  {
		String sql = "DELETE FROM clazz WHERE idclazz = ?";
		Connection conn = JDBCConnection.getConn();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();// de update du lieu: them/sua/xoa
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Loi delete");
		}

	}

	public List<Clazz> selectAll()  {// muon lay course name,,, cua thang khac thi inner join....

		String sql = "SELECT idclazz, name  FROM clazz";

		Connection conn = JDBCConnection.getConn();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			List<Clazz> clazzList = new ArrayList<Clazz>();
			while (rs.next()) {
				Clazz c = new Clazz();
				c.setId(rs.getInt("idclazz"));
				c.setName(rs.getString("name"));

				// new doi tuong voi goi duoc ham vi o day dung quan he doi tuong

				Course course = new Course();
				course.setId(rs.getInt("course_id"));
				c.setCourse(course);
				clazzList.add(c);
			}
			return clazzList;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Loi selectAll");
		}
		return null;
	}
	

	public List<Clazz> searchByCourseName(String Coursename) {

		String sql = "select cl.id,cl.name,cl.course_id,c.name as 'c_name' from clazz cl inner join course c on cl.course_id = c.id where c.name = ?";

		Connection conn = JDBCConnection.getConn();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Clazz> clazzList = new ArrayList<Clazz>();
	
		while (rs.next()) {
			Clazz c = new Clazz();
			c.setId(rs.getInt("idclazz"));
			c.setName(rs.getString("name"));

			// new doi tuong voi goi duoc ham vi o day dung quan he doi tuong

			Course course = new Course();
			course.setId(rs.getInt("course_id"));
			course.setName(rs.getString("name"));

			c.setCourse(course);
			clazzList.add(c);
		}
		return clazzList;
			} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("Loi search by coursename");
	}
		return null;
	}
}