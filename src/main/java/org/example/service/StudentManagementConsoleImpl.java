package org.example.service;

import org.example.data_access.StudentDao;
import org.example.models.Student;
import org.example.util.UserInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentManagementConsoleImpl implements StudentManagement{

    private final UserInputService inputService;
    private final StudentDao studentDao;

    @Autowired
    public StudentManagementConsoleImpl(UserInputService inputService, StudentDao studentDao) {
        this.inputService = inputService;
        this.studentDao = studentDao;
    }

    @Override
    public Student create() {
        System.out.println("Please enter a name: ");
        String name = inputService.getString();
        Student student = new Student();
        student.setName(name);
        return save(student);

    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student find(int id) {
        return studentDao.find(id);
    }

    @Override
    public Student remove(int id) {
        Student student = find(id);
        if(student == null) throw new RuntimeException("Couldn't find student with id " + id);
        studentDao.delete(id);
        return student;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {
        if(student == null) throw new NullPointerException("Cant edit student because it was null");

        System.out.println("Current name is " + student.getName());
        System.out.print("Enter a new name: ");
        String newName = inputService.getString().trim();
        student.setName(newName);
        return student;
    }
}
