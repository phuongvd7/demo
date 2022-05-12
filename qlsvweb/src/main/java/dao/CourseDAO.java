package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Course;

public class CourseDAO {
	public void add(Course c) throws SQLException {

		String sql = "INSERT INTO course(id, name) VALUE (?,?)";
		
		Connection conn = JDBCConnection.getConn();// mo connection
		PreparedStatement ps = conn.prepareStatement(sql);//get thong tin vao ham,vao cac dau hoi cham
		
		ps.setInt(1,c.getId());
		ps.setString(2, c.getName());
		
		ps.executeUpdate();// thuc hien lenh update len
		
	}
	
	public void update(Course c) throws SQLException {

		String sql = "UPDATE course SET name = ? WHERE id = ?";
		//import ,xoa nhung code thua di , xoa nhung import thua di khi copy code =>>>ctrl + shift+o 
		//ctrl+D =>> xoa dong code
		Connection conn = JDBCConnection.getConn();// mo connection
		PreparedStatement ps = conn.prepareStatement(sql);//get thong tin vao ham,vao cac dau hoi cham
				
		ps.setString(1, c.getName());
		ps.setInt(2,c.getId());
		
		//ALT+ len xuong// keo dong code di chuyen	
		ps.executeUpdate();// thuc hien lenh update len
		
	}
	
	
	public void delete(int  id) throws SQLException {
//		String sql = "INSERT INTO course(id, name) VALUE (3,'Servlet')";
				
// cach 2
		String sql = "DELETE FROM course WHERE id = ?";
		//import ,xoa nhung code thua di , xoa nhung import thua di khi copy code =>>>ctrl + shift+o 
		//ctrl+D =>> xoa dong code
		Connection conn = JDBCConnection.getConn();// mo connection
		PreparedStatement ps = conn.prepareStatement(sql);//get thong tin vao ham,vao cac dau hoi cham	
		ps.setInt(1, id);		
		//ALT+ len xuong// keo dong code di chuyen	
		ps.executeUpdate();// thuc hien lenh update len
		
	}
	
	public List<Course> selectAll() throws SQLException {
				
// cach 2
		String sql = "SELECT id, name  FROM course";
		//import ,xoa nhung code thua di , xoa nhung import thua di khi copy code =>>>ctrl + shift+o 
		//ctrl+D =>> xoa dong code
		Connection conn = JDBCConnection.getConn();// mo connection
		try {
		PreparedStatement ps = conn.prepareStatement(sql);//get thong tin vao ham,vao cac dau hoi cham	
		ResultSet rs = ps.executeQuery();
		
		List<Course> courseList = new ArrayList<Course>(); // tao mot list de xuat cac phan tu ra chu khong can next tung thang mot
		while(rs.next()) {
			Course c = new Course();		
			c.setId(rs.getInt("id"));
			c.setName(rs.getString("name"));
			
			courseList.add(c);
		}
		return courseList;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Loi selectALL");
		}
		return null;
	}
}
