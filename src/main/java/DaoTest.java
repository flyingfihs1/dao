import bean.Student;
import dao.StudentDao;
import daoImpl.StudentDaoImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DaoTest {
    @Test
    public void daoTest() {
        StudentDao studentDao = new StudentDaoImpl();

        studentDao.insertStudent(1, "tujin");
        studentDao.insertStudent(2, "tujin1");
        studentDao.insertStudent(3, "tujin2");
        List<Student> students = studentDao.queryAll();
        System.out.println(students);
        Assert.assertEquals(students.size(), 3);
    }
}
