package com.LTI.College_Proj.DAO;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

import com.LTI.College_Proj.Model.CustomerBean;

public class CustomersDao {
		private String jdbcURL="jdbc:oracle:thin:@localhost:1521:xe";
		private String jdbcUsername ="system";
		private String jdbcPassword ="tiger";
		private static final String INSERT_USER_SQL="INSERT INTO customers1 VALUES(id_customer.NEXTVAL,?,?,?,?,?,?,?)";
		private static final String SELECT_USER_BY_ID="select id,fname,lname,address,city,state,zipcode,email from customers1 where id=?";
		private static final String SELECT_ALL_USER="select * from customers1";
		private static final String DELETE_USER_SQL="delete from customers1 where id=?";
		private static final String UPDATE_USERS_SQL="update customers1 set fname=?,lname=?,address=?,city=?,state=?,zipcode=?,email=? where id=?";
		
		public CustomersDao() {
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
		public void insertUser(CustomerBean user) throws SQLException {
			System.out.println(INSERT_USER_SQL);
			try{
				Connection connection =getConnection();
				PreparedStatement ps=connection.prepareStatement(INSERT_USER_SQL);
				
				ps.setString(1, user.getFname());
		        ps.setString(2, user.getLname());
		        ps.setString(3, user.getAddress());
		        ps.setString(4, user.getCity());
		        ps.setString(5, user.getState());
		        ps.setString(6, user.getZipcode());
		        ps.setString(7, user.getEmail());
				System.out.println(ps);
				ps.executeUpdate();
			}catch(SQLException e) {
				printSQLException(e);
			}
		}
		
		public CustomerBean selectUser(int id) {
			CustomerBean user=null;
			try{
				Connection connection =getConnection();
				PreparedStatement pd=connection.prepareStatement(SELECT_USER_BY_ID);
				pd.setInt(1, id);
				System.out.println(pd);
				ResultSet rs=pd.executeQuery();
				while(rs.next()) {
					String fname=rs.getString("fname");
					String lname=rs.getString("lname");
					String address=rs.getString("address");
					String city=rs.getString("city");
					String state=rs.getString("state");
					String zipcode=rs.getString("zipcode");
					String email=rs.getString("email");
					user=new CustomerBean(id,fname,lname,address,city,state,zipcode,email);
				}
			}catch(SQLException e) {
				printSQLException(e);
			}
			return user;
		}
		public List<CustomerBean> selectAllUsers() {
			List<CustomerBean> users=new ArrayList<>();
			try{
				Connection connection=getConnection();
				PreparedStatement pd=connection.prepareStatement(SELECT_ALL_USER);
				System.out.println(pd.toString());
				ResultSet rs=pd.executeQuery();
				
				while(rs.next()) 
				{
					int id=rs.getInt("id");
					String fname=rs.getString("fname");
					String lname=rs.getString("lname");
					String address=rs.getString("address");
					String city=rs.getString("city");
					String state=rs.getString("state");
					String zipcode=rs.getString("zipcode");
					String email=rs.getString("email");
					users.add(new CustomerBean(id,fname,lname,address,city,state,zipcode,email));
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
		
		public boolean updateUser(CustomerBean user) throws SQLException {
			boolean rowUpdated;
			try(Connection connection=getConnection();
				PreparedStatement ps=connection.prepareStatement(UPDATE_USERS_SQL);) {
				
				ps.setString(1, user.getFname());
		        ps.setString(2, user.getLname());
		        ps.setString(3, user.getAddress());
		        ps.setString(4, user.getCity());
		        ps.setString(5, user.getState());
		        ps.setString(6, user.getZipcode());
		        ps.setString(7, user.getEmail());
				ps.setInt(8,    user.getId());
				rowUpdated=ps.executeUpdate() > 0;
				
			}
			return rowUpdated;
		}
		private void printSQLException(SQLException ex) {
			ex.printStackTrace();
		}
	}



