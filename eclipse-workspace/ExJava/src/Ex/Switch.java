package Ex;

public class Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//어떠한 범위내에 값을 구해야 할 때는 if else 문 사용
		//명확한 케이스가 있을 때 switch문 사용
		int rank = 4;
		
		if(rank == 1) {
			System.out.println("전액장학금");
		}
		else if(rank == 2) {
			System.out.println("반액장학금1");
		}
		else if(rank == 3) {
			System.out.println("반액장학금2");
		}
		else {
			System.out.println("장학금 없음");
		}
		System.out.println("조회 완료");
		
		System.out.println("--------------------------------");
		
		rank = 4;
		switch(rank) {
		case 1:
			System.out.println("전액장학금");
			break;
		case 2:
			System.out.println("반액장학금1");
			break;
		case 3:
			System.out.println("반액장학금2");
			break;
			default :
				System.out.println("장학금 없음");
				break;
			
		}
		System.out.println("조회완료");
		
		System.out.println("--------------------------------------");
		
		//중고 상품의 등급에 따른 가격 책정(1급 : 최상, 4급 : 최하)
		
		int grade = 3; //등급
		int price = 7000;  //기본 가격
		
		switch(grade) {
		case 1:
			price +=1000;
			
		case 2:
			price +=1000;
			
		case 3:
			price += 1000;
			break;
			
		}
		System.out.println(grade + "등급의 제품 자격: "+price + "원");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
