package com.projects.springboot.app.service;

import com.projects.springboot.app.config.exception.NotFoundException;
import com.projects.springboot.app.entity.Student;
import com.projects.springboot.app.repository.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public final Student create(final Student student) {
		Student st = studentRepository.save(student);
		return st;

	}

	public final List<Student> findAll() {
		List<Student> students = studentRepository.findAll();
		return students;
	}

	public final Student findbyId(final Long id) {
		if (!studentRepository.existsById(id)) {
			throw new NotFoundException("Not found student with id: " + id);
		}

		Student st = studentRepository.getOne(id);
		return st;
	}

	public final Student update(final Long id, final Student student) {

		if (!studentRepository.existsById(id)) {
			throw new NotFoundException("Not found student with id: " + id);
		}

		Student st = studentRepository.getOne(id);

		if (student.getGender() != null) {
			st.setGender(student.getGender());
		}

		if (student.getFirstName() != null) {
			st.setFirstName(student.getFirstName());
		}
		if (student.getMiddleName() != null) {
			st.setMiddleName(student.getMiddleName());
		}

		if (student.getLastName() != null) {
			st.setLastName(student.getLastName());
		}

		if (student.getDateOfBirth() != null) {
			st.setDateOfBirth(student.getDateOfBirth());
		}

		if (student.getOtherStudentDetails() != null) {
			st.setOtherStudentDetails(student.getOtherStudentDetails());
		}

		studentRepository.save(st);

		return st;
	}

	public final void delete(final Long id) {
		if (!studentRepository.existsById(id)) {
			throw new NotFoundException("Not found student with id: " + id);
		}
		studentRepository.deleteById(id);
	}

}
