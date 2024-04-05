package day09;

import java.util.Scanner;

public class Hi {
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


/* TODO Auto-generated method stub
 * 야구게임
 * 사용자 번호 직접입력
 * 번호 랜덤 생성(1부터9까지 중복 안되게)
 * 중복 안되게 하는 메소드 isContain 호출해서 사용
 * Method07.isContain
 */







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
