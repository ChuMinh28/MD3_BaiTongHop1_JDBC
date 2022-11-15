package ra.controller;

import ra.model.entity.Product;
import ra.model.service.ProductService;
import ra.model.serviceImp.ProductServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private ProductService<Product,String> productService = new ProductServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action!=null && action.equals("update")){
            String productID = request.getParameter("productID");
            Product productUpdate = productService.getById(productID);
            request.setAttribute("productUpdate",productUpdate);
            request.getRequestDispatcher("views/updateProduct.jsp").forward(request,response);
        }else if (action!=null && action.equals("delete")){
            String productID = request.getParameter("productID");
            boolean result = productService.delete(productID);
            if (result){
                getAllProduct(request,response);
            }else {
                request.getRequestDispatcher("views/error.jsp").forward(request,response);
            }
        } else if (action!=null && action.equals("search")) {
            String productName = request.getParameter("productName");
            request.setAttribute("listProduct",productService.searchProductByName(productName));
            request.getRequestDispatcher("views/product.jsp").forward(request,response);
        } else if (action!=null && action.equals("searchPrice")) {
            String productPrice = request.getParameter("searchPrice");
            if (productPrice.equals("0")){
                request.setAttribute("listProduct",productService.searchProductByPrice(Float.parseFloat(productPrice)));
                request.getRequestDispatcher("views/product.jsp").forward(request,response);
            } else if (productPrice.equals("500")) {
                request.setAttribute("listProduct",productService.searchProductByPrice(Float.parseFloat(productPrice)));
                request.getRequestDispatcher("views/product.jsp").forward(request,response);
            }else {
                request.setAttribute("listProduct",productService.searchProductByPrice(Float.parseFloat(productPrice)));
                request.getRequestDispatcher("views/product.jsp").forward(request,response);
            }
        } else {
            getAllProduct(request,response);
        }
    }
    public void getAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> listProduct = productService.getAll();
        request.setAttribute("listProduct",listProduct);
        request.getRequestDispatcher("views/product.jsp").forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        Product product = new Product();
        product.setProductID(request.getParameter("productID"));
        product.setProductName(request.getParameter("productName"));
        product.setPrice(Float.parseFloat(request.getParameter("price")));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            product.setCreated(simpleDateFormat.parse(request.getParameter("created")));
        }catch (ParseException e){
            throw new RuntimeException(e);
        }
        product.setDescriptions(request.getParameter("descriptions"));
        product.setProductStatus(Boolean.parseBoolean(request.getParameter("productStatus")));
        if (action!=null && action.equals("Create")){
            boolean result = productService.save(product);
            if (result){
                getAllProduct(request,response);
            }else {
                request.getRequestDispatcher("views/error.jsp").forward(request,response);
            }
        } else if (action!=null && action.equals("Update")) {
            boolean result = productService.update(product);
            if (result) {
                getAllProduct(request,response);
            }else {
                request.getRequestDispatcher("views/error.jsp").forward(request,response);
            }
        }
    }
}
