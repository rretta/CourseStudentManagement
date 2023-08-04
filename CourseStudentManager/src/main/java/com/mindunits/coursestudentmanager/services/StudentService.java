package com.mindunits.coursestudentmanager.services;
import com.mindunits.coursestudentmanager.repository.StudentRepository;
import com.mindunits.coursestudentmanager.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student updateStudent(Long id, String name, String email, String phone) {
        Student existingStudent = studentRepository.findById(id).orElse(null);

        if (existingStudent == null) {
            throw new NoSuchElementException("Student with ID " + id + " not found");
        }

        existingStudent.setName(name);
        existingStudent.setEmail(email);
        existingStudent.setPhone(phone);

        return studentRepository.save(existingStudent);
    }
}
