package com;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class AddToDoServlet
 */
public class AddToDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBManager todoDBUtil;
	private DataSource dataSource;
    private String description;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
  
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			 dataSource= getDataSource();
			 todoDBUtil = new DBManager(dataSource);
		} catch (NamingException e) {
			 e.printStackTrace();
		}
	}
    
    private DataSource getDataSource() throws NamingException {
		String jndi="java:comp/env/jdbc/todolist" ;
		Context context = new InitialContext();
		DataSource dataSource = (DataSource) context.lookup(jndi);
		return dataSource;
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher dispatcher = request.getRequestDispatcher("/AddToDo.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		description = request.getParameter("description");
		todoDBUtil.addTodo(description);
		response.sendRedirect(request.getContextPath() + "/");
	}

}
