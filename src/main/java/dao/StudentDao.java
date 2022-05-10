package dao;

import bean.Student;

import java.util.List;

public interface StudentDao {

    List<Student> queryAll();

    void insertStudent(int id, String name);
}
