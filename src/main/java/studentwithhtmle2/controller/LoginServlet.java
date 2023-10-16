package studentwithhtmle2.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentwithhtmle2.dao.StudentDao;
import studentwithhtmle2.dto.Student;

public class LoginServlet extends HttpServlet {
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		StudentDao studentDao=new StudentDao();
		List<Student> list=studentDao.getAllStudents();
		boolean value=false;
		String studentPasswordFromTheDatabase=null;
		
		for(Student student:list) {
			if(email.equals(student.getEmail())) {
//				when that email is present in my database
				value=true;
//				if that email is present means that student is present is present
//				if that student is present
				studentPasswordFromTheDatabase=student.getPassword();
				break;
			}
		}
		
		if(value) {
//			value=true
//			email is present in the database
//			now im going to check whether that password is same or not
			if(password.equals(studentPasswordFromTheDatabase)) {
//				password is crct
//				login success
				PrintWriter printWriter=resp.getWriter();
				printWriter.print("Loginn Success");
			}else {
//				invalid password
				PrintWriter printWriter=resp.getWriter();
				printWriter.print("Invalid Password");
			}
		}else {
			PrintWriter printWriter=resp.getWriter();
			printWriter.print("Invalid Email");
		}
	
		
	}

}

