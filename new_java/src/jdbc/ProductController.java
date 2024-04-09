package jdbc;

import java.util.List;
import java.util.Scanner;

public class ProductController {
    private Scanner scan;
    private Service svc;
    private boolean flag;

    public ProductController() {
        scan = new Scanner(System.in);
        svc = new ProductServiceImpl();
        flag = true;
        printMenu();
    }

    private void printMenu() {
        while (flag) {
            System.out.println("--상품관리프로그램--");
            System.out.println("1. 상품등록 | 2. 상품목록 | 3. 상품검색(상품상세보기)");
            System.out.println("4. 상품수정 | 5. 상품삭제 | 6. 종료");
            System.out.println("메뉴선택 -> ");

            int menu = scan.nextInt();

            switch (menu) {
                case 1:
                    register();
                    break;
                case 2:
                    list();
                    break;
                case 3:
                    detail();
                    break;
                case 4:
                    modify();
                    break;
                case 5:
                    remove();
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }

    private void remove() {
        // TODO Auto-generated method stub
    	System.out.println("삭제하려는 번호");
        int pno = scan.nextInt();

        int isDeleted = svc.remove(pno);

    }

    private void modify() {
        // 상품내용 수정 update product set pname=?, price=?, madeby=?where pno=?
        // 상품등록 
        System.out.println("수정하려는 번호");
        int pno = scan.nextInt();
        
              System.out.println("상품이름");
              scan.nextLine();
              String pname = scan.nextLine();
              
              System.out.println("상품가격");
              
              int price = scan.nextInt();
              
              System.out.println("상품상세내역");
              scan.nextLine();
              String madeby = scan.nextLine();
              ProductVO p = new ProductVO(pno,pname, price, madeby);
              
              int isOK = svc.modify(p);
              
              //잘되면 1 안되면 0
              System.out.println("상품수정 "+((isOK >0)?"성공":"실패"));
        
     }

    private void detail() {
        // TODO Auto-generated method stub
    	System.out.println("상품번호 -> ");
    	int pno = scan.nextInt();
    	ProductVO p = svc.getDetail(pno);
    	System.out.println(p);

    }

    private void list() {
        // TODO Auto-generated method stub
    	List<ProductVO> list = svc.getlist();
    	
    	//출력
    	for(ProductVO p : list) {
    		System.out.println(p);
    	}

    }

    private void register() {
        System.out.println("상품이름: ");
        scan.nextLine();
        String pname = scan.nextLine();
        System.out.println("상품가격: ");
        int price = scan.nextInt();
        System.out.println("상품상세내역: ");
        scan.nextLine();
        String madeby = scan.nextLine();
        ProductVO p = new ProductVO(pname, price, madeby);
        int isOk = svc.register(p);
        System.out.println(isOk);
        System.out.println("상품등록 "+((isOk >0)?"성공":"실패"));
    }
}
