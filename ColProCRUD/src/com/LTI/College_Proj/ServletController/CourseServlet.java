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

import com.LTI.College_Proj.DAO.CourseDao;

import com.LTI.College_Proj.Model.Course;

@WebServlet("/")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CourseDao userDao;
	   
    public void init() {
       userDao=new CourseDao();
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
		List<Course> listuser=userDao.selectAllUsers();
		request.setAttribute("listuser", listuser);
		RequestDispatcher dispatcher=request.getRequestDispatcher("coulist.jsp");
		dispatcher.forward(request, response);
	}


	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		String preq=request.getParameter("preq");
		int dur=Integer.parseInt(request.getParameter("dur"));
		String name=request.getParameter("name");
		int deptno=Integer.parseInt(request.getParameter("deptno"));
		int instrid=Integer.parseInt(request.getParameter("instrid"));
		Course book =new Course(id,preq,dur,name,deptno,instrid);
		userDao.updateUser(book);
		response.sendRedirect("list");
	}


	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		Course existingUser=userDao.selectUser(id);
		RequestDispatcher dispatcher=request.getRequestDispatcher("couform.jsp");
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
		String preq=request.getParameter("preq");
		int dur=Integer.parseInt(request.getParameter("dur"));
		String name=request.getParameter("name");
		int deptno=Integer.parseInt(request.getParameter("deptno"));
		int instrid=Integer.parseInt(request.getParameter("instrid"));
		Course newUser=new Course(preq,dur,name,deptno,instrid);
		userDao.insertUser(newUser);
		response.sendRedirect("list");
	}


	private void showNewForm1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher=request.getRequestDispatcher("couform.jsp");
		dispatcher.forward(request, response);
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
