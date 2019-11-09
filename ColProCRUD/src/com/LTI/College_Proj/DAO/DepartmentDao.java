package com.LTI.College_Proj.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.LTI.College_Proj.Model.Department;


public class DepartmentDao {
	private String jdbcURL="jdbc:oracle:thin:@localhost:1521:xe";
	private String jdbcUsername ="system";
	private String jdbcPassword ="tiger";

	private static final String INSERT_USER_SQL="INSERT INTO Department1 VALUES(ourseq.NEXTVAL,?,?)";
	private static final String SELECT_USER_BY_ID="select ID,NAME,LOCATION from Department1 where id=?";
	private static final String SELECT_ALL_USER="select * from Department1";
	private static final String DELETE_USER_SQL="delete from Department1 where id=?";
	private static final String UPDATE_USERS_SQL="update Department1 set NAME=?,LOCATION=? where id=?";
	
	public DepartmentDao() {
		}
	protected Connection getConnection() {
		Connection connection=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	public void insertUser(Department user) throws SQLException {
		System.out.println(INSERT_USER_SQL);
		try{
			Connection connection =getConnection();
			PreparedStatement ps=connection.prepareStatement(INSERT_USER_SQL);
			
			ps.setString(1, user.getName());
	        ps.setString(2, user.getLocation());
			System.out.println(ps);
			ps.executeUpdate();
		}catch(SQLException e) {
			printSQLException(e);
		}
	}
	
	public Department selectUser(int id) {
		Department user=null;
		try{
			Connection connection =getConnection();
			PreparedStatement pd=connection.prepareStatement(SELECT_USER_BY_ID);
			pd.setInt(1, id);
			System.out.println(pd);
			ResultSet rs=pd.executeQuery();
			while(rs.next()) {
				String name=rs.getString("name");
				String location=rs.getString("location");
				user=new Department(id,name,location);
			}
		}catch(SQLException e) {
			printSQLException(e);
		}
		return user;
	}
	public List<Department> selectAllUsers() {
		List<Department> users=new ArrayList<>();
		try{
			Connection connection=getConnection();
			PreparedStatement pd=connection.prepareStatement(SELECT_ALL_USER);
			System.out.println(pd.toString());
			ResultSet rs=pd.executeQuery();
			
			while(rs.next()) 
			{
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String location=rs.getString("location");
				users.add(new Department(id,name,location));
			}
		}catch(SQLException e) {
			printSQLException(e);
		}
		return users;
	}
	
	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try(Connection connection=getConnection();
			PreparedStatement statement=connection.prepareStatement(DELETE_USER_SQL);) {
			statement.setInt(1,id);
			rowDeleted=statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	public boolean updateUser(Department user) throws SQLException {
		boolean rowUpdated;
		try(Connection connection=getConnection();
			PreparedStatement ps=connection.prepareStatement(UPDATE_USERS_SQL);) {
			
			
	        ps.setString(1, user.getName());
	        ps.setString(2, user.getLocation());
			ps.setInt(3, user.getId());
			rowUpdated=ps.executeUpdate() > 0;
			
		}
		return rowUpdated;
	}
	private void printSQLException(SQLException ex) {
		ex.printStackTrace();
	}
}



