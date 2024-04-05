package day11;

public class Card1 {
    private int num;
    private char shape;

    public void print() {
        char shape1;
        if (num > 10 && num < 14) {
            switch(num) {
                case 11:
                    shape1 = 'J';
                    break;
                case 12:
                    shape1 = 'Q';
                    break;
                default:
                    shape1 = 'K';
            }
            System.out.println(shape + String.valueOf(shape1));
        } else if (num >= 1 && num <= 10) {
            System.out.println(shape + String.valueOf(num));
        } else {
            System.out.println("♥1");
        }
    }

    public Card1() {
        this.shape = '♥';
        this.num = 1;
    }

    public Card1(char shape, int num) {
        this.shape = shape;
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        if(num >= 1 && num <= 13) {
            this.num = num;
        } else {
            this.num = 1;
        }
    }

    public char getShape() {
        return shape;
    }

    public void setShape(char shape) {
        if(shape == '♥' || shape == '♠' || shape == '♣' || shape == '◆') {
            this.shape = shape;
        } else {
            this.shape = '♥';
        }
    }

    public static class Deck {
        private Card1[][] cards;

        public Deck() {
            cards = new Card1[4][13];
            char[] shapes = {'♥', '♠', '♣', '◆'};
        
            for (int i = 0; i < shapes.length; i++) {
                for (int num = 1; num <= 13; num++) {
                    cards[i][num-1] = new Card1(shapes[i], num);
                }
            }
        }

        public void printDeck() {
            for (Card1[] cardArray : cards) {
                for (Card1 card : cardArray) {
                    card.print();
                }
            }
        }
    }
}



//Card1.Deck deck = new Card1.Deck();
//deck.printDeck();


