package day11;

public class CardPack1 {
   private Card[] pack = new Card[52];
   private int cnt = 0; //카드 배열의 index 위치를 체크하기 위한 변수
   
   public CardPack1() {
      char shape = '♥';
      for(int i=1;i<=4; i++) {
         switch(i) {
         case 1:
            shape = '♥';
            break;
         case 2:
            shape = '◆';
            break;
         case 3:
            shape = '♣';
            break;
         case 4:
            shape = '♠';
            break;
         }
      
         for(int j=1;j<=13;j++) {
            Card c= new Card();
            c.setShape(shape);
            c.setNum(j);
            pack[cnt] = c;
            cnt++;
         }
      }
   }
   
   
   
   	//카드 섞는 기능
 	// shuffle()
 	//리턴 타입: void, 매개변수 :x
 	//카드 한장 뺴내는 기능
 	//pick() : 호출하면 카드 return
   
   public void shuffle() {
      for (int i=0;i<pack.length;i++) {
         int random=(int)(Math.random()*pack.length);
         Card temp = pack[i];
         pack[i]=pack[random];
         pack[random]=temp;
      }
   }
   
   
   public Card pick() {
      if(cnt==0) {
    	  return null;
      }
      cnt--;
      return pack[cnt];
   }
   
   public void init() {
	   cnt=52;
   }
   
   public Card[] getPack() {
      return pack;
   }

   public void setPack(Card[] pack) {
      this.pack = pack;
   }
}