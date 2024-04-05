// 패키지 정의
package com.yourcompany.servlets;

// 장바구니 항목을 표현하는 클래스
public class CartItem {
    // 장바구니에 들어갈 상품
    private Product product;
    // 해당 상품의 수량
    private int quantity;

    // 생성자
    public CartItem(Product product, int quantity) {
        // 상품과 수량을 초기화
        this.product = product;
        this.quantity = quantity;
    }

    // 상품을 반환하는 메소드
    public Product getProduct() {
        return product;
    }

    // 수량을 반환하는 메소드
    public int getQuantity() {
        return quantity;
    }
}
