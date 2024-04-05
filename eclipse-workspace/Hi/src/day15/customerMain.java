package day15;



public class customerMain {
    public static void main(String[] args) {
        Customer customer1 = new Customer(1000, "홍길동");
        System.out.println(customer1.customerInfo());

        GoldCustomer customer2 = new GoldCustomer(2000, "홍길동1");
        System.out.println(customer2.customerInfo());

        VipCustomer customer3 = new VipCustomer(3000, "홍길동2", 1111);
        System.out.println(customer3.customerInfo());

        int price = 10000;

        int hong1Price = customer1.calcPrice(price);
        int hong2Price = customer2.calcPrice(price);
        int hong3Price = customer3.calcPrice(price);

        System.out.println(customer1+"님의 긁은 금액은: " + hong1Price + "원, 보너스 포인트: " + customer1.getBonusPoint() + "점입니다.");
        
        System.out.println(customer2+"님의 긁은 금액은: " + hong2Price + "원, 보너스 포인트는 " + customer2.getBonusPoint() + "점입니다.");
        
        System.out.println(customer3+"님의 긁은 금액은: " + hong3Price + "원, 보너스 포인트는 " + customer3.getBonusPoint() + "점입니다.");
        
        
        
        
        
    }
}