package studentwithhtmle2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import studentwithhtmle2.dto.Student;

public class StudentDao {

	public Student saveStudent(Student student) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("pooji");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		return student;
	}

	public List<Student> getAllStudents() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("pooji");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select u from Student u");
		return query.getResultList();
	}
	
	
	
}
