package ra.model.daoImp;

import ra.model.dao.ProductDAO;
import ra.model.entity.Product;
import ra.model.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImp implements ProductDAO<Product,String> {
    @Override
    public List<Product> searchProductByNae(String name) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        List<Product> listProduct = null;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_getProductByName(?)}");
            callableStatement.setString(1,name);
            ResultSet resultSet = callableStatement.executeQuery();
            listProduct = new ArrayList<>();
            while (resultSet.next()){
                Product pro = new Product();
                pro.setProductID(resultSet.getString("ProductID"));
                pro.setProductName(resultSet.getString("ProductName"));
                pro.setPrice(resultSet.getFloat("Price"));
                pro.setCreated(resultSet.getDate("Created"));
                pro.setDescriptions(resultSet.getString("Descriptions"));
                pro.setProductStatus(resultSet.getBoolean("ProductStatus"));
                listProduct.add(pro);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection,callableStatement);
        }
        return listProduct;
    }

    @Override
    public List<Product> searchProductByPrice(Float price1) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        List<Product> listProduct = null;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_searchProductByPrice(?)}");
            callableStatement.setFloat(1,price1);
            ResultSet resultSet = callableStatement.executeQuery();
            listProduct = new ArrayList<>();
            while (resultSet.next()){
                Product pro = new Product();
                pro.setProductID(resultSet.getString("ProductID"));
                pro.setProductName(resultSet.getString("ProductName"));
                pro.setPrice(resultSet.getFloat("Price"));
                pro.setCreated(resultSet.getDate("Created"));
                pro.setDescriptions(resultSet.getString("Descriptions"));
                pro.setProductStatus(resultSet.getBoolean("ProductStatus"));
                listProduct.add(pro);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection,callableStatement);
        }
        return listProduct;
    }

    @Override
    public List<Product> getAll() {
        Connection connection = null;
        CallableStatement callableStatement = null;
        List<Product> listProduct = null;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_getAllProduct()}");
            ResultSet resultSet = callableStatement.executeQuery();
            listProduct = new ArrayList<>();
            while (resultSet.next()){
                Product pro = new Product();
                pro.setProductID(resultSet.getString("ProductID"));
                pro.setProductName(resultSet.getString("ProductName"));
                pro.setPrice(resultSet.getFloat("Price"));
                pro.setCreated(resultSet.getDate("Created"));
                pro.setDescriptions(resultSet.getString("Descriptions"));
                pro.setProductStatus(resultSet.getBoolean("ProductStatus"));
                listProduct.add(pro);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection,callableStatement);
        }
        return listProduct;
    }

    @Override
    public boolean save(Product product) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        boolean result = true;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_insertNewProduct(?,?,?,?,?,?)}");
            callableStatement.setString(1,product.getProductID());
            callableStatement.setString(2,product.getProductName());
            callableStatement.setFloat(3,product.getPrice());
            callableStatement.setDate(4,new Date(product.getCreated().getTime()));
            callableStatement.setString(5,product.getDescriptions());
            callableStatement.setBoolean(6,product.isProductStatus());
            callableStatement.execute();
        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection,callableStatement);
        }
        return result;
    }

    @Override
    public boolean update(Product product) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        boolean result = true;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_updateProduct(?,?,?,?,?,?)}");
            callableStatement.setString(1,product.getProductID());
            callableStatement.setString(2,product.getProductName());
            callableStatement.setFloat(3,product.getPrice());
            callableStatement.setDate(4,new Date(product.getCreated().getTime()));
            callableStatement.setString(5,product.getDescriptions());
            callableStatement.setBoolean(6,product.isProductStatus());
            callableStatement.executeUpdate();
        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection,callableStatement);
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        boolean result = true;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_deleteProduct(?)}");
            callableStatement.setString(1,id);
            callableStatement.executeUpdate();
        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection,callableStatement);
        }
        return result;
    }

    @Override
    public Product getById(String id) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        Product productInfo = new Product();
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_getProductById(?)}");
            callableStatement.setString(1,id);
            ResultSet resultSet = callableStatement.executeQuery();
            if (resultSet.next()){
                productInfo.setProductID(resultSet.getString("ProductID"));
                productInfo.setProductName(resultSet.getString("ProductName"));
                productInfo.setPrice(resultSet.getFloat("Price"));
                productInfo.setCreated(resultSet.getDate("Created"));
                productInfo.setDescriptions(resultSet.getString("Descriptions"));
                productInfo.setProductStatus(resultSet.getBoolean("ProductStatus"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection,callableStatement);
        }
        return productInfo;
    }
}
