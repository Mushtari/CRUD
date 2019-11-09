package com.LTI.College_Proj.ServletController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LTI.College_Proj.DAO.InstructorDao;
import com.LTI.College_Proj.Model.Instructor;

@WebServlet("/")
public class InstructorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InstructorDao userDao;
	   
    public void init() {
       userDao=new InstructorDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
		
		String action=request.getServletPath();
		try{
			switch(action) {
			case "/new":
				showNewForm1(request,response);
				break;
			case "/insert":
				insertUser(request,response);
				break;
			case "/delete":
				deleteUser(request,response);
				break;
			case "/edit":
				showEditForm(request,response);
				break;
			case "/update":
				updateUser(request,response);
				break;
				
				default:
					listUser(request,response);
			
			}
		}catch(Exception e){e.printStackTrace();}
	}

	
	private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Instructor> listuser=userDao.selectAllUsers();
		request.setAttribute("listuser", listuser);
		RequestDispatcher dispatcher=request.getRequestDispatcher("inslist.jsp");
		dispatcher.forward(request, response);
	}


	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		int phno=Integer.parseInt(request.getParameter("phno"));
		int rmno=Integer.parseInt(request.getParameter("rmno"));
		int deptno=Integer.parseInt(request.getParameter("deptno"));
		Instructor book =new Instructor(id,name,phno,rmno,deptno);
		userDao.updateUser(book);
		response.sendRedirect("list");
	}


	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		Instructor existingUser=userDao.selectUser(id);
		RequestDispatcher dispatcher=request.getRequestDispatcher("insform.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
	}


	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		userDao.deleteUser(id);
		response.sendRedirect("list");
	}


	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		int phno=Integer.parseInt(request.getParameter("phno"));
		int rmno=Integer.parseInt(request.getParameter("rmno"));
		int deptno=Integer.parseInt(request.getParameter("deptno"));
		Instructor newUser=new Instructor(name,phno,rmno,deptno);
		userDao.insertUser(newUser);
		response.sendRedirect("list");
	}


	private void showNewForm1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher=request.getRequestDispatcher("insform.jsp");
		dispatcher.forward(request, response);
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
