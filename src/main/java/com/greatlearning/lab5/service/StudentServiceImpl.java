package com.greatlearning.lab5.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.lab5.entity.Student;

@Repository
public class StudentServiceImpl implements StudentService{

	private SessionFactory sessionFactory;

	// create session
	private Session session;
	
	@Autowired
	StudentServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
	}
	
	@Transactional
	public List<Student> findAll() {
		Transaction tx = session.beginTransaction();
		
		List<Student> students = session.createQuery("from Student", Student.class).list();
		tx.commit();
		
		return students;
	}

	@Transactional
	public Student findById(int theId) {
		Transaction tx = session.beginTransaction();
		Student student = session.get(Student.class, theId);
		tx.commit();
		return student;
	}

	@Transactional
	public void save(Student student) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(student);
		tx.commit();
		
	}

	@Transactional
	public void deleteById(int theId) {
		Transaction tx = session.beginTransaction();
		Student student = session.get(Student.class, theId);
		if (student != null) {
		session.delete(student);
		}
		tx.commit();
	}
}
