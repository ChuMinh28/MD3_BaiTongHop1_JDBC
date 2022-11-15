package ra.model.serviceImp;

import ra.model.dao.ProductDAO;
import ra.model.daoImp.ProductDAOImp;
import ra.model.entity.Product;
import ra.model.service.ProductService;

import java.util.List;

public class ProductServiceImp implements ProductService<Product,String> {
    private ProductDAO<Product,String> productDAO = new ProductDAOImp();
    @Override
    public List<Product> getAll() {
        return productDAO.getAll();
    }

    @Override
    public boolean save(Product product) {
        return productDAO.save(product);
    }

    @Override
    public boolean update(Product product) {
        return productDAO.update(product);
    }

    @Override
    public boolean delete(String id) {
        return productDAO.delete(id);
    }

    @Override
    public Product getById(String id) {
        return productDAO.getById(id);
    }

    @Override
    public List<Product> searchProductByName(String name) {
        return productDAO.searchProductByNae(name);
    }

    @Override
    public List searchProductByPrice(Float price) {
        return productDAO.searchProductByPrice(price);
    }
}
