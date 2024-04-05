package day10;

import day09.*;
import java.util.Scanner;

public class BaseballGame {

    public static void main(String[] args) {
    	/* TODO Auto-generated method stub
    	 * 야구게임
    	 * 사용자 번호 직접입력
    	 * 번호 랜덤 생성(1부터9까지 중복 안되게)
    	 * 중복 안되게 하는 메소드 isContain 호출해서 사용
    	 * Method07.isContain
    	 */
        Scanner scan = new Scanner(System.in);
        int computer[] = new int[3];
        int user[] = new int[3];

        for(int i=0; i<3;i++) {
            while(true) {
                int random = (int)(Math.random()*9)+1;
                if(!Hi.check(computer,random)) {
                    computer[i] = random;
                    break;
                }
            }
        }

        while (true) {
            System.out.println("공 3개 던져");
            int[] user1 = new int[3];
            for (int i = 0; i < 3; i++) {
                user1[i] = scan.nextInt();
            }

            int strike = 0, ball = 0;
            for (int i = 0; i < 3; i++) {
                if (user1[i] == computer[i]) {
                    strike++;
                } else if (Hi.check(computer, user1[i])) {
                    ball++;
}
}

            if (strike == 0 && ball == 0) {
                System.out.println("아웃!");
            } else {
                System.out.println(strike + " 스트라이크, " + ball + " 볼");
                if (strike == 3) {
                	System.out.println("컴퓨터가 선택한 숫자: " + computer[0] + " " + computer[1] + " " + computer[2]);
                    System.out.println("3개의 숫자를 모두 맞히셨습니다!");
                    break;
                }
            }
        }
    }

    
    
    /*랜덤으로 배열 중복되지 않게 생성
     * Method07의 isContain 여기 위치에서 사용
     * 
     * 두 번째 메소드는 스트라이크 개수를 카운트 하는 메소드
     * computer과 user 주고 번호와 위치가 일치하면 count 세는 메소드
     * 리턴타입: int count 를 리턴
     * 볼 개수 카운트 하는 메소드 생성
     * computer과 user 번호만 일치하면 됨
     * 리턴타입: int count 리턴
     * */
    public static int strikecheck(int[] computer, int[] user) {
        int count = 0;
        for(int i=0; i<computer.length; i++) {
            if(computer[i] == user[i]) {
                count++;
            }
        }
        return count;
    }

    public static int ballcheck(int[] computer, int[] user) {
        int count = 0;
        for(int i=0; i<computer.length; i++) {
            if(Hi.check(user, computer[i]) && computer[i] != user[i]) {
                count++;
            }
        }
        return count;
    }
    
    //랜덤 범위 상관 없이 랜덤수 채우는 메소드
    // 범위를 매개변수로 받아옴
    //(int)(Math.random)*개수
}