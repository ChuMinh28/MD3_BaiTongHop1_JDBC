package ra.model.entity;

import java.util.Date;

public class Product {
    private String productID;
    private String productName;
    private float price;
    private Date created;
    private String descriptions;
    private boolean productStatus;

    public Product() {
    }

    public Product(String productID, String productName, float price, Date created, String descriptions, boolean productStatus) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.created = created;
        this.descriptions = descriptions;
        this.productStatus = productStatus;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }
}
