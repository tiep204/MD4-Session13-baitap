package ra.model.service;

import java.util.List;
import java.util.Map;
import java.util.Vector;

public interface StudentManagementService<T,E> {
    List<T> getAll();
    boolean save(Map<String, T> map);
    boolean delete(E id);
    T getById(E id);
}
