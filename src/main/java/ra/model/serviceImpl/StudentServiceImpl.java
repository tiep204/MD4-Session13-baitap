package ra.model.serviceImpl;

import ra.model.entity.Student;
import ra.model.service.StudentService;
import ra.model.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class StudentServiceImpl implements StudentService<Student, String> {

    @Override
    public List<Student> getAll() {
        Connection conn = null;
        CallableStatement call = null;
        List<Student> studentList = null;
        try {
            conn = ConnectionDB.openConnection();
            call = conn.prepareCall("{call proc_GetAllStudent()}");
            ResultSet rs = call.executeQuery();
            studentList = new ArrayList<>();
            while (rs.next()) {
                Student st = new Student();
                st.setStudentId(rs.getString("studentId"));
                st.setStudentName(rs.getString("studentName"));
                st.setAge(rs.getInt("age"));
                st.setBirthDate(rs.getDate("birthDate"));
                st.setStudentStatus(rs.getBoolean("studentStatus"));
                studentList.add(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, call);
        }
        return studentList;
    }

    @Override
    public boolean save(Student student) {
        Connection conn = null;
        CallableStatement call = null;
        boolean result = true;
        try {
            conn = ConnectionDB.openConnection();
            call = conn.prepareCall("{call proc_insertStudent(?,?,?,?,?)}");
            call.setString(1, student.getStudentId());
            call.setString(2, student.getStudentName());
            call.setInt(3, student.getAge());
            call.setDate(4, new Date(student.getBirthDate().getTime()));
            call.setBoolean(5,student.isStudentStatus());
            call.executeUpdate();
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, call);
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Student getById(String id) {
        return null;
    }

    @Override
    public List<Student> searchStudentByName(String name) {
        return null;
    }
}
