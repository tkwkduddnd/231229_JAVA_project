package day13;

import java.util.Scanner;

//TODO Auto-generated method stub
		/* Product 클래스 생성 : 상품을 등록하는 클래스
		 * 상품명, 가격을 멤버변수로 생성
		 * 생성자는 알아서
		 * 상품 추가 메소드
		 * 추가한 상품을 출력하는 메소드(toString으로 생성가능)
		 * 
		 */

abstract class Product{ //부모
    public String productName;
    public String productDate;
    public int price;

    public Product(String productName, String productDate, int price) {
        this.productName = productName;
        this.productDate = productDate;
        this.price = price;
    }
    
    public void printInfo() {
        System.out.println("제품명: "+productName+", 제품 기한:"+productDate+", 제품 가격: "+price);
    }
    abstract public void productInfo();
}

class Product1 extends Product{ //자식
    public Product1(String productName, String productDate, int price) {
        super(productName, productDate, price);
    }

    @Override
    public void productInfo() {
        System.out.println("제품 명: "+productName+", 제품 기한: "+productDate+", 제품 가격: "+price);
    }
}


public class 과제 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        Product1[] product = new Product1[10];
        int cnt = 0;
        while(true) {
           System.out.println("상품을 등록하시겠습니까? Y/N");
           String scan1 = scan.nextLine();
           if(scan1.equals("Y")) {
               if(cnt < product.length) {
                    System.out.println("등록할 제품명 입력: ");
                    String productName = scan.nextLine();
                    System.out.println("등록할 제품 기한 입력: ");
                    String productDate = scan.nextLine();
                    System.out.println("등록할 제품 가격 입력: ");
                    int price = Integer.parseInt(scan.nextLine());

                    product[cnt] = new Product1(productName, productDate, price);
                    cnt++;
               } 
           } else if(scan1.equals("N")) {
             System.out.println("선택창 밖으로 나왔습니다.");
             break;
          } else {
             System.out.println("잘못된 입력입니다, 다시 입력해주세요.");
          }
        }
        
        for(int i = 0; i<cnt;i++) {
           product[i].productInfo();
        }
    }
}





