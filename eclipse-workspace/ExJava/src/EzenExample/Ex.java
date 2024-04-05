package EzenExample;

import EzenExample.ex6.Card;

public class Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ex6 outer = new ex6();
		Card c = outer.new Card();
		c.setNum(11);
		c.setShape('^');
		c.print();
		c.setNum(15);
		c.setShape('♠');
		c.print();
		
	}

}
