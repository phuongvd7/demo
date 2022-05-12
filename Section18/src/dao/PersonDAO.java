package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import java.util.Date;
import model.Person;

public class PersonDAO {

	public void add(Person c) throws SQLException {

		String sql = "INSERT INTO person(id, name,age,bDate) VALUE (?,?,?,?)";
		Connection conn = JDBCConnection.getConn();// mo connection
		PreparedStatement ps = conn.prepareStatement(sql);// get thong tin vao ham,vao cac dau hoi cham
		ps.setInt(1, c.getId());
		ps.setString(2, c.getName());
		ps.setInt(3, c.getAge());
//			ps.setString(4, c.getBirthDate()); rieng voi thang ngay thang thuc hien setDate
		// chi import dc 1 thang util.date neu da them o duoi thi bo import ben tren
		ps.setDate(4, new java.sql.Date(c.getBirthDate().getTime()));
		// doc ra la java uqil, set vao la` java sql
		ps.executeUpdate();// thuc hien lenh update len

	}

	public void update(Person c) throws SQLException {

		String sql = "UPDATE person SET name = ? WHERE id = ?";
		// import ,xoa nhung code thua di , xoa nhung import thua di khi copy code
		// =>>>ctrl + shift+o
		// ctrl+D =>> xoa dong code
		Connection conn = JDBCConnection.getConn();// mo connection
		PreparedStatement ps = conn.prepareStatement(sql);// get thong tin vao ham,vao cac dau hoi cham

		ps.setInt(1, c.getId());
		ps.setString(2, c.getName());
		ps.setInt(3, c.getAge());
		ps.setDate(4, new java.sql.Date(c.getBirthDate().getTime()));

		// ALT+ len xuong// keo dong code di chuyen
		ps.executeUpdate();// thuc hien lenh update len

	}

	public void delete(int id) throws SQLException {

		String sql = "DELETE FROM person WHERE id = ?";

		Connection conn = JDBCConnection.getConn();// mo connection
		PreparedStatement ps = conn.prepareStatement(sql);// get thong tin vao ham,vao cac dau hoi cham
		ps.setInt(1, id);

		ps.executeUpdate();

	}

	public List<Person> selectAll() throws SQLException {

		String sql = "SELECT id, name  FROM person";

		Connection conn = JDBCConnection.getConn();// mo connection
		PreparedStatement ps = conn.prepareStatement(sql);// get thong tin vao ham,vao cac dau hoi cham
		ResultSet rs = ps.executeQuery();

		List<Person> personList = new ArrayList<Person>();
		while (rs.next()) { // rs.next => doc tung dong cua doi tuong 1, den khi nao het bang thi thoi
			Person c = new Person();
			c.setId(rs.getInt("id"));
			c.setName(rs.getString("name"));
			c.setBirthDate(rs.getDate("bDate"));
			personList.add(c); // doc tung doi tuong sau do nem vao list
		}
		return personList;
	}

	

	public List<Person> search(String name) throws SQLException {
		String sql = "SELECT id,name ,bDate FROM person  WHERE name like ?";
		Connection conn = JDBCConnection.getConn();// mo connection
		PreparedStatement ps = conn.prepareStatement(sql);// get thong tin vao ham,vao cac dau hoi cham
		ResultSet rs = ps.executeQuery();

		List<Person> personList = new ArrayList<Person>();
		while (rs.next()) { // rs.next => doc tung dong cua doi tuong 1, den khi nao het bang thi thoi
			Person c = new Person();
			c.setId(rs.getInt("id"));
			c.setName(rs.getString("name"));
			c.setBirthDate(rs.getDate("bDate"));

		personList.add(c); // doc tung doi tuong sau do nem vao list
		}
	return personList;
}
	
	public List<Person> search(int fromYear, int toYear) throws SQLException {
		String sql = "Select id,name,bDate from person where year(bDate) >= ? and year(bDate) <= ?";
		Connection conn = JDBCConnection.getConn();// mo connection
		PreparedStatement ps = conn.prepareStatement(sql);// get thong tin vao ham,vao cac dau hoi cham
	
		
		ps.setInt(1, fromYear);
		ps.setInt(2, toYear);
		ResultSet rs = ps.executeQuery();
		List<Person> personList = new ArrayList<Person>();
		while (rs.next()) { // rs.next => doc tung dong cua doi tuong 1, den khi nao het bang thi thoi
			Person c = new Person();
			c.setId(rs.getInt("id"));
			c.setName(rs.getString("name"));
			c.setBirthDate(rs.getDate("bDate"));
		personList.add(c); // doc tung doi tuong sau do nem vao list
		}
	return personList;
}
	}