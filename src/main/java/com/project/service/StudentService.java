package com.project.service;

import com.project.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface StudentService {
    Optional<Student> getStudent(Integer studentId);
    Student setStudent(Student student);
    void deleteStudent(Integer studentId);
    Page<Student> getStudenci(Pageable pageable);
    Optional<Student> getStudentByNrIndeksu(String nrIndeksu);
    Page<Student> getStudenciByNrIndeksuStartsWith(String nrIndeksu, Pageable pageable);
    Page<Student> getStudenciByNazwiskoStartsWith(String nazwisko, Pageable pageable);
}
