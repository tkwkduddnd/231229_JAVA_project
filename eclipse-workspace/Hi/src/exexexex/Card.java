package exexexex;

public class Card {
    private char shape;
    private int num;

    public char getShape() {
        return shape;
    }

    public void setShape(char shape) {
        this.shape = shape;
    }

    public String getNum() {
        switch (num) {
            case 1:
                return "A";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                return Integer.toString(num);
        }
    }

    public void setNum(int num) {
        this.num = num;
    }
}