package ra.model.serviceImpl;

import ra.model.entity.Student;
import ra.model.service.StudentService;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentServiceImpl();
        List<Student> studentList = studentService.pagingStudent(2);
        for (Student s : studentList) {
            System.out.println(s.getStudentId());
        }
/*        int count = studentService.getTotalStudent();
        System.out.println(count);*/
    }
}
