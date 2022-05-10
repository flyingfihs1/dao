package daoImpl;

import bean.Student;
import connection.ConnectUtil;
import dao.StudentDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> queryAll() {
        List<Student> students = new ArrayList<>();

        try {
            Connection conn = ConnectUtil.getConn();
            String sql = "SELECT * FROM student";
            PreparedStatement preSt = conn.prepareStatement(sql);
            ResultSet resultSet = preSt.executeQuery();
            while(resultSet.next()) {
                students.add(new Student(resultSet.getInt("id"), resultSet.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    @Override
    public void insertStudent(int id, String name) {
        try {
            Connection conn = ConnectUtil.getConn();
            String sql = "INSERT INTO student (id, name) VALUES (?, ?)";
            PreparedStatement preSt = conn.prepareStatement(sql);
            preSt.setInt(1, id);
            preSt.setString(2, name);
            preSt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
