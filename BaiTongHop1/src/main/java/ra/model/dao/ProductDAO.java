package ra.model.dao;

import java.util.List;

public interface ProductDAO<T,V> extends ProductManagementDAO<T,V> {
    List<T> searchProductByNae(String name);
    List<T> searchProductByPrice(Float price1);
}
