package studentwithhtmle2.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import studentwithhtmle2.dao.StudentDao;
import studentwithhtmle2.dto.Student;

public class SignUpServlet  extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		long phone=Long.parseLong(req.getParameter("phone"));
		
		
		Student student=new Student();
		student.setAddress(address);
		student.setEmail(email);
		student.setName(name);
		student.setPassword(password);
		student.setPhone(phone);
		
		
		StudentDao studentDao=new StudentDao();
		Student dbStudent=studentDao.saveStudent(student);
		
		if(dbStudent!=null) {
//			its saved successfully
			
			PrintWriter printWriter=res.getWriter();
			printWriter.print("STUDENT SIGNEDIN SUCCESSFULLY");
			
			
		}
		
		
		
		
		
		
		
	}

}
