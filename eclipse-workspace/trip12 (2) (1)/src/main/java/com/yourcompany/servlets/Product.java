// 패키지 선언
package com.yourcompany.servlets;

// Product 클래스 정의
public class Product {
    // 인스턴스 변수 선언
    private int id; // 상품의 고유 ID
    private String theme; // 상품의 테마
    private String productImage; // 상품 이미지의 URL
    private String productCode; // 상품 코드
    private String productName; // 상품 이름
    private String departureTime; // 출발 시간
    private String arrivalTime; // 도착 시간
    private int remainingCount; // 잔여 수량
    private String productStatus; // 상품 상태
    private int price; // 상품 가격
    private String details; // 상품 상세 설명

    // 기본 생성자
    public Product() {
    }

    // 재고 수량을 감소시키는 메서드
    public void decreaseRemainingCount(int quantity) {
        this.remainingCount -= quantity;
    }

    // 상품 상태를 업데이트하는 메서드
    public void updateProductStatus() {
        if (this.remainingCount <= 0) {
            this.productStatus = "품절";
        }
    }

    // 각 인스턴스 변수에 대한 getter 및 setter 메서드
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getRemainingCount() {
        return remainingCount;
    }

    public void setRemainingCount(int remainingCount) {
        this.remainingCount = remainingCount;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
