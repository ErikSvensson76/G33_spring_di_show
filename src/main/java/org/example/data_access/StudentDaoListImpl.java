package org.example.data_access;

import org.example.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDaoListImpl implements StudentDao{

    private List<Student> students;
    private final StudentIdSequencer sequencer;

    @Autowired
    public StudentDaoListImpl(StudentIdSequencer sequencer) {
        this.sequencer = sequencer;
        students = new ArrayList<>();
    }

    @Override
    public Student save(Student student) {
        if(student == null) throw new NullPointerException("Student was null");
        if(student.getId() != 0){
            return student;
        }

        student.setId(sequencer.nextId());
        students.add(student);

        return student;
    }

    @Override
    public Student find(int id) {
        for(Student student : students){
            if(student.getId() == id){
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    @Override
    public void delete(int id) {
        Student student = find(id);
        if(student != null){
            students.remove(student);
        }
    }

    public void clearAll(){
        students = new ArrayList<>();
    }
}
