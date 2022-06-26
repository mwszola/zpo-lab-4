package com.project.service;

import com.project.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class ZadanieServiceImpl implements StudentService {
    @Override
    public Optional<Student> getStudent(Integer studentId) {
        return Optional.empty();
    }

    @Override
    public Student setStudent(Student student) {
        return null;
    }

    @Override
    public void deleteStudent(Integer studentId) {

    }

    @Override
    public Page<Student> getStudenci(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Student> getStudentByNrIndeksu(String nrIndeksu) {
        return Optional.empty();
    }

    @Override
    public Page<Student> getStudenciByNrIndeksuStartsWith(String nrIndeksu, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Student> getStudenciByNazwiskoStartsWith(String nazwisko, Pageable pageable) {
        return null;
    }
}
