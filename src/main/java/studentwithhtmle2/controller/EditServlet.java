package studentwithhtmle2.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentwithhtmle2.dao.StudentDao;
import studentwithhtmle2.dto.Student;

public class EditServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
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
	Student dbStudent=studentDao.updateStudent(id,student);
	PrintWriter printWriter=resp.getWriter();
	if(dbStudent!=null) {
//		id is present and we updated the data
		printWriter.print("Student data updated successfully");
		
	}else {
		printWriter.print("sorry id is not present");
	}
	
	
	
}
}
