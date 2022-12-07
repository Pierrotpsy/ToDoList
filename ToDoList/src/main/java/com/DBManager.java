package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import javax.sql.DataSource;

public class DBManager {
	private DataSource dataSource;
	public DBManager(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<ToDo> getToDo() throws Exception {
		List<ToDo> todos= new ArrayList<ToDo>();
		Connection myConn=null;
		Statement myStmt = null;
		ResultSet myRs= null;
		try {
			myConn = dataSource.getConnection();
			myStmt= myConn.createStatement();
			String sql= "select * from todos order by id";
			myRs = myStmt.executeQuery(sql);
			while(myRs.next()){
				int id = myRs.getInt("id");
				String description=myRs.getString("description");
				ToDo tempStudent= new ToDo(id,description);
				todos.add(tempStudent);
			}
			return todos;
		} finally{
			close(myConn,myStmt,myRs);
		}
	}
	
	public String getRole(String user) throws Exception {
		String role = "";
		Connection myConn=null;
		PreparedStatement myStmt = null;
		ResultSet myRs= null;
		try {
			myConn = dataSource.getConnection();
			String sql= "select role from roles where name = ?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, user);
			myRs= myStmt.executeQuery();
			
			while(myRs.next()){
				role = myRs.getString("role");
			}
			return role;
		} finally{
			close(myConn,myStmt,myRs);
		}
	}
	
	public void updateTodo(ToDo todo) {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			myConn = dataSource.getConnection();
			String sql = "update todos set description=? where id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, todo.getDescription());
			myStmt.setInt(2, todo.getId());
			myStmt.execute();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			close(myConn,myStmt,null);
		}
	}
	
	public void addTodo(String description) {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			myConn = dataSource.getConnection();
			String sql = "insert into todos (description) values (?)";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1,description);
			myStmt.execute();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			close(myConn,myStmt,null);
		}
	}
	
	public void deleteTodo(ToDo todo) {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			myConn = dataSource.getConnection();
			String sql = "delete from todos where id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, todo.getId());
			myStmt.execute();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			close(myConn,myStmt,null);
		}
	}

	
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try{
			if(myStmt!=null)
			myStmt.close();
			if(myRs!=null)
			myRs.close();
			if(myConn!=null)
			myConn.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
