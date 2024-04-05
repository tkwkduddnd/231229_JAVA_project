package EzenExample;

public class ex6 {

	
		// TODO Auto-generated method stub
		/*
		 * 숫자: 1~10, J(11),Q(12),K(13)
		 * 모양: ◆ ♥ ♠ ♣
		 * 한장의 카드를 출력하는 기능 print() => ♥1
		 * ex) ◆12 => ◆Q, ♠13 => ♠K, #2 => ♥2, &15 => ♥1 
		 */
	
	public class Card {
		private int num;
		private char shape;
		
		public Card() {
			this.num = 1;
			this.shape ='♥';
		}
		
		public void print() {
			System.out.println(shape);
			switch(num) {
			case 11: 
				System.out.println("J");
				break;
			case 12:
				System.out.println("Q");
				break;
			case 13:
				System.out.println("K");
				break;
				default:
					System.out.println(num);
					break;
			}
		}

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			if(num < 1 || num > 13) {
				this.num = 1;
			}
			else {
				this.num = num;
			}
			
		}

		public char getShape() {
			return shape;
		}

		public void setShape(char shape) {
			switch(shape){
			case '♥': case '◆' : case '♠' : case '♣':
				this.shape = shape;
				break;
				default:
					this.shape = '♥';
					break;
			}
			
		}
	}
}

