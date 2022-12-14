package com.test.sqliteuebung;

public class ShoppingMemo {

    private String product;
    private int quantity;
    private long id;

    public ShoppingMemo(String product, int quantity, long id) { // The constructor of the class ShoppingMemo takes three parameters
        this.product = product; // The first parameter is assigned to the variable product
        this.quantity = quantity; // this.quantity refers to the variable quantity of the class ShoppingMemo
        this.id = id;
    }

    public String getProduct() {
        return product;
    } // The method getProduct() returns the value of the variable product

    public void setProduct(String product) {
        this.product = product;
    } // The method setProduct() assigns the value of the parameter product to the variable product

    public int getQuantity() {
        return quantity;
    } // The method getQuantity() returns the value of the variable quantity

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }  // The method setQuantity() assigns the value of the parameter quantity to the variable quantity

    public long getId(long id) {
        return id;
    } // The method getId() returns the value of the variable id

    @Override
    public String toString() {
        String output = quantity + "x" + product;
        return output;
    } // The method toString() returns the value of the variable output
}
