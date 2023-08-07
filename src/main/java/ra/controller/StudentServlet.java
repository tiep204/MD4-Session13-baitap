package ra.controller;

import ra.model.entity.Student;
import ra.model.service.StudentService;
import ra.model.serviceImpl.StudentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    private StudentService<Student,String> studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getAll(request,response);
    }

    public void getAll(HttpServletRequest request,HttpServletResponse response) throws ServletException ,IOException{
        List<Student> studentList = studentService.getAll();
        request.setAttribute("listStudent",studentList);
        request.getRequestDispatcher("/views/student.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action =  request.getParameter("action");
        if (action!=null && action.equals("create")){
            Student st = new Student();
            st.setStudentId(request.getParameter("studentId"));
            st.setStudentName(request.getParameter("studentName"));
            st.setAge(Integer.parseInt(request.getParameter("age")));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                st.setBirthDate(sdf.parse(request.getParameter("birthDate")));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            st.setStudentStatus(Boolean.parseBoolean(request.getParameter("studentStatus")));
            boolean result = studentService.save(st);
            if (result){
                getAll(request,response);
            }else {
                request.getRequestDispatcher("views/erro.jsp").forward(request,response);
            }
        }
    }
}
