package studentwithhtmle2.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
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
		List<Student> list=studentDao.getAllStudents();
		
//		first im going to fetch all the students details
		boolean value=false;
		
		for(Student st:list) {

			if(email.equals(st.getEmail())) {
//				means this  is already present in the database and i cant save this student details
				value=true;
				break;
			}
		}
		
		
		if(value) {
//			email is already present in the database
			PrintWriter printWriter=res.getWriter();
			printWriter.print("EMail already exist and i cant save this student details");
			
		}else {
//			email is not present in the database and then i can save ythis student details
			studentDao.saveStudent(student);
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
			dispatcher.forward(req, res);
		}
		
		
		
		
		
		
		
		
		
		
	}

}
