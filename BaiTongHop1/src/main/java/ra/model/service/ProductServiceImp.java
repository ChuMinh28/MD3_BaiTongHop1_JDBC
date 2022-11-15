package ra.model.service;

import java.util.List;

public interface ProductServiceImp<T,V> {
    List<T> searchProductByName(String name);
    List<T> searchProductByPrice(Float price);
}
