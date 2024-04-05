package day19;

import java.util.ArrayList;

public class Sale<K, V> {
    private K product;
    private V price;

    public Sale(K product, V price) {
        this.product = product;
        this.price = price;
    }

    public K getProduct() {
        return product;
    }

    public V getPrice() {
        return price;
    }

    public void setProduct(K product) {
        this.product = product;
    }

    public void setPrice(V price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Sale [product=" + product + ", price=" + price + "]";
    }
}

	
	


