package com.spring.orm.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entites.Student;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}


	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	//insert student
	@Transactional
	public int insert(Student student) {
		//save method
		Integer i = (Integer)hibernateTemplate.save(student);
		
		return i;
	}
	//get single student
	public Student getStudent(int sId) {
		Student student = hibernateTemplate.get(Student.class, sId);
		return student;
	}
	
	//get all student
	public List<Student> getAllStudents(){
		List<Student> allstudent = hibernateTemplate.loadAll(Student.class);
		return allstudent;
	}
	//delete a student data
	@Transactional
	public void deleteStudent(int sId) {
		Student student = hibernateTemplate.get(Student.class, sId);
		hibernateTemplate.delete(student);
	}
	//update student value
	@Transactional
	public void updateStudent(Student student) {
		hibernateTemplate.update(student);
	}

	
}
