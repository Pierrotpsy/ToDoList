package com;

import java.io.IOException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class ViewToDoServlet
 */
public class ViewToDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBManager todoDBUtil;
	private DataSource dataSource;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewToDoServlet() {
        super();
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
		try {
			HttpSession session = request.getSession();
			session.setAttribute("username", request.getRemoteUser());
			
			Cookie cookie = new Cookie("username", (String)session.getAttribute("username"));
			cookie.setMaxAge(60*60*24) ; 
			response.addCookie(cookie) ;
			
			String role = todoDBUtil.getRole((String)session.getAttribute("username"));
			
			List<ToDo> todos = todoDBUtil.getToDo();
			request.setAttribute("TODO_LIST", todos);
			if (role.equals("Teacher")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/todos-teacher.jsp");
				dispatcher.forward(request, response);
			}
			else if (role.equals("Student")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/todos-student.jsp");
				dispatcher.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
