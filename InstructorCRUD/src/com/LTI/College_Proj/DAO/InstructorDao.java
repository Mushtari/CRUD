 package com.LTI.College_Proj.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.LTI.College_Proj.Model.Instructor;


public class InstructorDao {
	private String jdbcURL="jdbc:oracle:thin:@localhost:1521:xe";
	private String jdbcUsername ="system";
	private String jdbcPassword ="tiger";

	private static final String INSERT_USER_SQL="INSERT INTO Instructor1 VALUES(ourseq1.NEXTVAL,?,?,?,?)";
	private static final String SELECT_USER_BY_ID="select id,name,phno,rmno,deptno from Instructor1 where id=?";
	private static final String SELECT_ALL_USER="select * from Instructor1";
	private static final String DELETE_USER_SQL="delete from Instructor1 where id=?";
	private static final String UPDATE_USERS_SQL="update Instructor1 set name=?,phno=?,rmno=?,deptno=? where id=?";
	
	public InstructorDao() {
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
	public void insertUser(Instructor user) throws SQLException {
		System.out.println(INSERT_USER_SQL);
		try{
			Connection connection =getConnection();
			PreparedStatement ps=connection.prepareStatement(INSERT_USER_SQL);
			
			ps.setString(1, user.getName());
	        ps.setInt(2, user.getPhno());
	        ps.setInt(3, user.getRmno());
	        ps.setInt(4, user.getDeptno());
			System.out.println(ps);
			ps.executeUpdate();
		}catch(SQLException e) {
			printSQLException(e);
		}
	}
	
	public Instructor selectUser(int id) {
		Instructor user=null;
		try{
			Connection connection =getConnection();
			PreparedStatement pd=connection.prepareStatement(SELECT_USER_BY_ID);
			pd.setInt(1, id);
			System.out.println(pd);
			ResultSet rs=pd.executeQuery();
			while(rs.next()) {
				String name=rs.getString("name");
				int phno=rs.getInt("phno");
				int rmno=rs.getInt("rmno");
				int deptno=rs.getInt("deptno");
				user=new Instructor(id,name,phno,rmno,deptno);
			}
		}catch(SQLException e) {
			printSQLException(e);
		}
		return user;
	}
	public List<Instructor> selectAllUsers() {
		List<Instructor> users=new ArrayList<>();
		try{
			Connection connection=getConnection();
			PreparedStatement pd=connection.prepareStatement(SELECT_ALL_USER);
			System.out.println(pd.toString());
			ResultSet rs=pd.executeQuery();
			
			while(rs.next()) 
			{
				int id=rs.getInt("id");
				String name=rs.getString("name");
				int phno=rs.getInt("phno");
				int rmno=rs.getInt("rmno");
				int deptno=rs.getInt("deptno");
				users.add(new Instructor(id,name,phno,rmno,deptno));
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
	
	public boolean updateUser(Instructor user) throws SQLException {
		boolean rowUpdated;
		try(Connection connection=getConnection();
			PreparedStatement ps=connection.prepareStatement(UPDATE_USERS_SQL);) {
			
			ps.setString(1, user.getName());
	        ps.setInt(2, user.getPhno());
	        ps.setInt(3, user.getRmno());
	        ps.setInt(4, user.getDeptno());
			ps.setInt(5, user.getId());
			rowUpdated=ps.executeUpdate() > 0;
			
		}
		return rowUpdated;
	}
	private void printSQLException(SQLException ex) {
		ex.printStackTrace();
	}
}



