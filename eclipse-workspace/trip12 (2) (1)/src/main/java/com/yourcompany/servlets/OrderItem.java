// 패키지 선언
package com.yourcompany.servlets;

// OrderItem 클래스 정의
public class OrderItem {
    // 인스턴스 변수 선언
    private int orderId;
    private int productId;
    private int quantity;
    private int price;

    // 생성자를 사용하여 인스턴스 변수 초기화
    public OrderItem(int orderId, int productId, int quantity, int price) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    // 주문 ID를 반환하는 getter 메서드
    public int getOrderId() {
        return orderId;
    }

    // 상품 ID를 반환하는 getter 메서드
    public int getProductId() {
        return productId;
    }

    // 수량을 반환하는 getter 메서드
    public int getQuantity() {
        return quantity;
    }

    // 가격을 반환하는 getter 메서드
    public int getPrice() {
        return price;
    }

    // 총 가격을 계산하여 반환하는 메서드
    public int getTotalPrice() {
        return quantity * price;
    }
}
