package ra.model.serviceImpl;

import ra.model.entity.Student;
import ra.model.service.StudentService;
import ra.model.util.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public boolean save(Map<String,Student> map) {
        Connection conn = null;
        CallableStatement call = null;
        Student student = null;
        boolean result = true;
        try {
            conn = ConnectionDB.openConnection();
            if (map.containsKey("Update")){
                student= map.get("Update");
                call = conn.prepareCall("{call proc_updateStudent(?,?,?,?,?)}");
            }else {
                student= map.get("Insert");
                call = conn.prepareCall("{call proc_insertStudent(?,?,?,?,?)}");
            }
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
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_DeleteStudentId(?)}");
            callSt.setString(1,id);
            callSt.executeUpdate();
        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }

    @Override
    public Student getById(String id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Student st = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_GetStudentById(?)}");
            callSt.setString(1,id);
            ResultSet rs = callSt.executeQuery();
            st = new Student();
            if (rs.next()){
                st.setStudentId(rs.getString("studentId"));
                st.setStudentName(rs.getString("studentName"));
                st.setAge(rs.getInt("age"));
                st.setBirthDate(rs.getDate("birthDate"));
                st.setStudentStatus(rs.getBoolean("studentStatus"));
            }
        } catch (SQLException e) {
           e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return st;
    }

    @Override
    public List<Student> searchStudentByName(String name) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Student> studentList = new ArrayList<>(); // Khởi tạo danh sách trước khi sử dụng
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_searchStudentByName(?)}");
            callSt.setString(1, name);
            ResultSet rs = callSt.executeQuery();

            while (rs.next()) {
                Student st = new Student(); // Tạo một đối tượng Student cho mỗi kết quả
                st.setStudentId(rs.getString("studentId"));
                st.setStudentName(rs.getString("studentName"));
                st.setAge(rs.getInt("age"));
                st.setBirthDate(rs.getDate("birthDate"));
                st.setStudentStatus(rs.getBoolean("studentStatus"));
                studentList.add(st);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return studentList;
    }
}