package service;
import java.util.List;
public interface IDepartmentService<E> {
    void add(E e);
    List<E> findAll();
    void edit(int id, E e);
    void delete(int id);
    E findById(int id);
}
