package day11;

public class Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Card2 c = new Card2();
		//c.setNum(13);
		//c.setShape('♤');
		//c.print();
		/*CardPack1 cp = new CardPack1();
		cp.shuffle();
		int cnt=0;
		for(int i =0; i<4; i++) {
			for(int j=0; j<13; j++) {
				cp.getPack()[cnt].print();
				//cp.getPack() : 카드팩 클래스 안에 있는 pack배열
				//cp.getPack() [cnt] = pack[0] 번지 => Card(멤버변수, 메소드)
				cnt++;
				}
			System.out.println();
		}
		System.out.println("--------------------");
		Card player1 = cp.pick();
		Card player2 = cp.pick();
		System.out.println("플레이어1 카드: ");
		player1.print();
		System.out.println(" ");
		System.out.println("플레이어2 카드: ");
		player2.print();
		*/
			
	    
	        CardPack1 cardPack = new CardPack1();
	        for(int i = 0; i < 52; i++) {
	            Card card = cardPack.pick();
	            System.out.print(card.getShape()+":"+card.getNum());
	        
	    }
	
		
	
	
	
	}}





