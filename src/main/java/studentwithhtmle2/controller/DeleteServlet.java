package studentwithhtmle2.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentwithhtmle2.dao.StudentDao;
import studentwithhtmle2.dto.Student;

public class DeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		StudentDao dao=new StudentDao();
		Student student=dao.deleteStudentById(id);
		PrintWriter printWriter=resp.getWriter();
		if(student!=null) {
//			we deleted successfully
			printWriter.print("Student data deleted successfully");
		}else {
//			when that id is not present
			printWriter.print("Sorry that id is not present in the db");
		}
		
	}
}
