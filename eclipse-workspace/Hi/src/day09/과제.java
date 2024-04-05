package day09;

import java.util.Scanner;

public class 과제 {
    public static void main(String[] args) {
    	// 야구게임
    	// 컴퓨터가 3자리 1부터9사이의 랜덤수 생성 => 배열로 저장
    	// 내가 3자리 입력해서 맞추면 됨
    	// 자리랑 숫자 같으면 stfuke
    	// 숫자만 같으면 ball
    	// 다 다르면 out
        Scanner scanner = new Scanner(System.in);
        int computer[] = new int[3];
        
        

        
        for (int i = 0; i < 3; i++) {
            while (true) {
                int random = (int)(Math.random() * 9) + 1;
                if (!check(computer, random)) {
                    computer[i] = random;
                    break;
                }
}
}

        while (true) {
            System.out.println("공 3개 던져");
            int[] user = new int[3];
            for (int i = 0; i < 3; i++) {
                user[i] = scanner.nextInt();
            }

            int strike = 0, ball = 0;
            for (int i = 0; i < 3; i++) {
                if (user[i] == computer[i]) {
                    strike++;
                } else if (check(computer, user[i])) {
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

        scanner.close();
    }

    
    public static boolean check(int array[], int value) {
        for (int i : array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }
}
