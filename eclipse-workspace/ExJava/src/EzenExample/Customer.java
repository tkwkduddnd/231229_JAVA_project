package EzenExample;

public class Customer {
	/*
	 * 고객 Id : int customerID
	 * 고객 이름: String customerName
	 * 고객 등급 : String customerGrade
	 * 보너스 포인트 : int bonusPoint
	 * 보너스 적립비율: double bonusRatio
	 * 
	 *  클래스 생성
	 *  -기본 customerGrade ="silver";
	 *  -bonusRatio = 0.01 => 1% 적립
	 *  
	 *  메소드
	 *  1. 보너스 적립 계산 메소드 (메소드명: CalcPrice(int print))
	 *  =>구매 금액을 주고 적립 보너스를 계산 bonusPoint에 누적
	 *  =>보너스 적립, 할인여부를 체크해서 구매 price를 리턴
	 *  
	 *  2. 출력 메소드(메소드명 : customerInfo())
	 *  => 홍길동님 등급은 VIP 이며, 보너스 포인트는 1000입니다.
	 *  전담 상담사 번호는 1111입니다. -VIP 고객만 출력
	 *  
	 *  -silver 등급
	 *  =>제품을 구매할 때 0% 할인 / 보너스 포인트 1% 적립
	 *  
	 *  -Gold 등급
	 *  => 제품을 구매할 때 10% 할인 / 보너스 포인트 2% 적립
	 *  
	 *  -Vip 등급
	 *  => 제품을 구매할 때 10% 할인 / 보너스 포인트 5% 적립
	 *  => 전담 상담사를 멤버변수에 추가(int agentID)
	 *  
	 *  GoldCustomer extends Customer {
	 *  기본 메소드를 오버라이딩 하여 사용
	 *  }
	 *  
	 *  VIPCustomer extends Customer {
	 *  기본 메소드를 오버라이딩 하여 사용
	 *  }
	 *  
	 *  CustomerMain 클래스에서 확인
	 *  
	 *  
	 */
	
	protected int customerID;
	protected String customerName;
	protected String customerGrade;
	protected int bonusPoint;
	protected double bonusRatio;
	
	//생성자
	public Customer() {}
	
	public Customer(int customerID, String CustomerName) {
		this.customerID = customerID;
		this.customerName = customerName;
		customerGrade = "silver";
		bonusRatio = 0.01;
	}
	
	public int calcPrice(int price) {
		bonusPoint = bonusPoint+(int)(price * bonusRatio);
		return price;
	}
	
	public void customerInfo() {
		System.out.println(customerName+"님의 등급은 "+customerGrade+"이며, "+"보너스 포인트는: "+bonusPoint+"입니다.");
	}
}
