package ra.model.service;

import java.util.List;

public interface ProductService<T,V> extends ProductServiceImp {
    List<T> getAll();
    boolean save(T t);
    boolean update(T t);
    boolean delete(V id);
    T getById(V id);
}
