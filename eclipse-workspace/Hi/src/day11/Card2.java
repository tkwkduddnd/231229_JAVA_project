package day11;

/*1장의 카드를 생성하기 위한 클래스
* 숫자: 1부터 10까지, j q k
* 모양: ♥ ◆ ♠ ♣
* 
* 한장의 카드를 출력하는 기능 print() => ♥1
* 내가 값을 입력하면 모양과 숫자로 출력하는 방식
* ex) ◆12 => ◆Q, ♠13 => ♠K, 
* 없는모양에 숫자가 나오면 무조건 ♥에 나온숫자 ex) #2 => ♥2
* 모양과 숫자 둘다 없는게 나온다면 무조건 ♥1 ex) #15=>♥1 
* 
* 클래스 구성은
* 멤버변수: 모양(shape), 숫자(num) => private 선언
* getter/setter 생성
* 메소드 : print()만 사용
* 생성자: 기본 생성자만 생성 =>  ♥1
* 
*/

public class Card2 {
	private int num;
	private char shape;
	
	public void print() {
		char shape1;
		if(num>10 && num<14) {
			switch(num) {
			case 11:
				shape1= 'J';
				break;
			case 12:
				shape1 = 'Q';
				break;
			default:
				shape1 = 'K';
				break;
			}
			System.out.println(shape+String.valueOf(shape1));
		}
		else if(num>=1 && num<=10) {
			System.out.println(shape+String.valueOf(num));
		}
		else {
			System.out.println("♥1");
		}
		
		
	}
	
	public  Card2() {
		this.shape='♥';
		this.num=1;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		if(num>=1 && num<=13) {
			this.num = num;
		}
		else {
			this.num = 1;
		}
		
	}

	public char getShape() {
		return shape;
	}

	public void setShape(char shape) {
		if(shape=='♥' || shape=='◆' || shape=='♠' || shape=='♣') {
			this.shape = shape;
		}
		else {
			this.shape = '♥';
		}
		
	}

}

