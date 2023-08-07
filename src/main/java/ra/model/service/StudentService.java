package ra.model.service;

import java.util.List;

public interface StudentService<T,E> extends StudentManagementService<T,E> {
    List<T> searchStudentByName(String name);
}
