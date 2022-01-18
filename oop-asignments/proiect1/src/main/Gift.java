package main;

import enums.Category;

public class Gift {
    private String productName;
    private Double price;
    private Category category;
    /**
     * Setter for the name of the product
     */
    public void setProductName(final String productName) {
        this.productName = productName;
    }
    /**
     * Setter for the price
     */
    public void setPrice(final Double price) {
        this.price = price;
    }
    /**
     * Setter for the category of the gift
     */
    public void setCategory(final Category category) {
        this.category = category;
    }
    /**
     * Getter for the name of the product
     */
    public String getProductName() {
        return productName;
    }
    /**
     * Getter for the price
     */
    public Double getPrice() {
        return price;
    }
    /**
     * Getter for the category of the gift
     */
    public Category getCategory() {
        return category;
    }
}
