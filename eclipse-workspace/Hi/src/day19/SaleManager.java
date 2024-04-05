package day19;

import java.util.ArrayList;
import java.util.Scanner;


/* 제네릭 클래스 처리
 * 
 */

		// 입력받는 값은 제품명, 수량
		// 제품명 가격*수량 (지불금액)을 order 추가
		// ex) 햄버거 5 => 햄버거 25000
		// sale = menu ,Price
		// order 클래스 => Sale 클래스를 상속받아 사용
		// order => (menu price) count total
		

	
public class SaleManager {
	   
	   private ArrayList<Sale<String, Integer>> menu = new ArrayList<>();
	   private ArrayList<Sale<String, Integer>> order = new ArrayList<>();
	   
	   
	   //제품추가
	   public void add(Scanner scan) {
	      System.out.println("추가할 제품명");
	      String product = scan.next();
	      System.out.println("추가할 제품가격");
	      int price = scan.nextInt();
	      Sale<String,Integer> s= new Sale<String, Integer>(product,price);
	      this.menu.add(s);
	   }
	   
	   //메뉴와 가격 출력
	   public void menuPrint() {
	      for(Sale<String, Integer> sale : menu) {
	            System.out.println(sale);
	        }
	   }
	   
	   //주문내역
	   public void orderPick(String name, int count) {
	      for(int i=0;i<menu.size();i++) {
	    	  String ProductMenu = menu.get(i).getProduct();
	    	  int ProductPrice = menu.get(i).getPrice();
	    	  if(ProductMenu.equals(name)) {
	    		  int index = orderSearch(name);
	    		  if(index !=-1) {
	    			  int price = order.get(index).getPrice();
	    			  order.get(index).setPrice(price+(ProductPrice*count));
	    			  return;
	    		  }
	    		  Sale p = new Sale(ProductMenu, (ProductPrice*count));
	    		  order.add(p);
	    	  }
	      }
	   }
	   public int orderSearch(String product) {
		   int index = -1;
		   for(int i=0;i<order.size();i++) {
			   if(order.get(i).getProduct().equals(product)) {
				   index = i;
				   System.out.println(index);
				   return index;
			   }
		   }
		   return index;
	   }

	   //영수증
	   public void orderPrint() {
	      int total = 0;
	      int count = 0;
	      for(Sale<String, Integer> sale : order) {
	         System.out.println(sale);
	         total += sale.getPrice();
	         count++;
	      }
	      System.out.println("총 지불금액 : " + total);
	      System.out.println("전체 수량: "+ count);
	   }

	public void menuDelete(Scanner scan) {
		System.out.println("삭제할 메뉴 이름을 입력하세요.");
        String name = scan.next();
        int index = -1;
        for (int i = 0; i < menu.size(); i++) {
            if (menu.get(i).getProduct().equals(name)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            menu.remove(index);
            System.out.println("메뉴가 삭제되었습니다.");
        } else {
            System.out.println("해당 메뉴는 존재하지 않습니다.");
        }
	}

	public void menuModify(Scanner scan) {
        System.out.println("수정할 가격의 메뉴를 정해주세요.");
		String name = scan.next();
        System.out.println("새로운 가격을 입력하세요.");
        int newPrice = scan.nextInt();
        for (Sale<String, Integer> sale : menu) {
            if (sale.getProduct().equals(name)) {
                sale.setPrice(newPrice);
                System.out.println("메뉴 가격이 수정되었습니다.");
                return;
            }
        }
        System.out.println("해당 메뉴는 존재하지 않습니다.");
	}
	}



    

    

