package ra.model.service;

import java.util.List;

public interface StudentManagementService<T,E> {
    List<T> getAll();
    boolean save(T t);
    boolean delete(E id);
    T getById(E id);
}
