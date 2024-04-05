package EzenExample;


import java.util.Scanner;  

public class ex1 {  

	public static void main(String[] args) {  
		
		
		/*
		 * 야구게임
		 * 컴퓨터가 3자리의 숫자를 생성(각 자리수는 1~9까지의 수) => 배열로 랜덤저장(중복불가능)
		 * 유저는 3자리의 숫자를 맞추는 게임 => 직접 입력(중복되지 않게)
		 * 자리와 숫자가 일치하면 strike
		 * 숫자만 맞으면 ball
		 * 아무것도 안맞으면 out
		 * ex) 컴퓨터 생성번호 : 1 2 3
		 * 사용자 번호 : 1 6 7 => 1s
		 * 사용자 번호 : 1 3 2 => 1s 2b
		 * 사용자 번호 : 7 8 9 => out
		 * 사용자 번호 : 1 2 3 =>3s 정답
		 */

		Scanner scan = new Scanner(System.in);  // 사용자로부터 입력을 받기 위한 Scanner 객체를 생성합니다.

		int comNum[] = new int[3];  // 컴퓨터가 생성할 3개의 숫자를 저장할 배열을 선언합니다.
		int userNum[] = new int[3];  // 사용자가 입력할 3개의 숫자를 저장할 배열을 선언합니다.

		for(int i=0;i<comNum.length;i++) {  // 컴퓨터가 숫자를 생성하는 for문입니다.
			comNum[i] = (int)(Math.random()*9)+1;  // 1부터 9까지의 랜덤한 숫자를 생성하여 comNum 배열에 저장합니다.
			for(int j=0;j<i;j++) {  // 중복된 숫자를 체크하는 for문입니다.
				if(comNum[i]==comNum[j]) {  // 같은 숫자가 생성되었을 경우
					i--;  // i 값을 하나 줄여서 다시 같은 위치에 새로운 숫자를 생성하도록 합니다.
					break;  // 중복 체크 for문을 종료합니다.
				}
			}
		}

		while(true) {  // 게임이 끝날 때까지 계속 반복하는 while문입니다.
			int stk=0;  // 스트라이크 개수를 저장할 변수를 선언하고 0으로 초기화합니다.
			int ball=0;  // 볼 개수를 저장할 변수를 선언하고 0으로 초기화합니다.

			System.out.println("숫자 입력: ");  // 사용자에게 숫자 입력을 요청하는 메시지를 출력합니다.
			String mystr = scan.nextLine();  // 사용자로부터 입력받은 문자열을 mystr에 저장합니다.
			String[] myNumstr = mystr.split("");  // 입력받은 문자열을 한 글자씩 나누어 myNumstr 배열에 저장합니다.

			for(int i=0;i<myNumstr.length;i++) {  // 사용자가 입력한 숫자를 userNum 배열에 저장하는 for문입니다.
				userNum[i] = Integer.parseInt(myNumstr[i]);  // 문자열을 정수로 변환하여 userNum 배열에 저장합니다.
			}

			for(int i=0; i<comNum.length;i++) {  // 스트라이크를 판별하는 for문입니다.
				for(int j=0; j<userNum.length;j++) {  // 사용자가 입력한 각 숫자에 대해
					if(comNum[i]== userNum[j] && i==j) {  // 숫자와 위치가 모두 같을 경우
						stk++;  // 스트라이크 개수를 증가시킵니다.
					}
				}
			}

			for(int i=0;i<comNum.length;i++) {  // 볼을 판별하는 for문입니다.
				for(int j=0;j<userNum.length;j++) {  // 사용자가 입력한 각 숫자에 대해
					if(comNum[i]==userNum[j] && i!=j) {  // 숫자는 같지만 위치는 다를 경우
						ball++;  // 볼 개수를 증가시킵니다.
					}
				}
			}

			if(stk==0 && ball ==0) {  // 아무 것도 맞지 않았을 경우
				System.out.println("아웃");  // "아웃"을 출력합니다.
			}
			else {  // 그 외의 경우
				System.out.println(stk+"s"+" "+ball+"b");  // "Xs Yb" 형식으로 스트라이크와 볼의 개수를 출력합니다.
			}

			if(stk==3) {  // 스트라이크가 3개일 경우
				System.out.println("성공. 게임종료");  // "성공. 게임종료"를 출력하고
				break;  // 게임을 종료합니다.
			}
			
		}
		
		scan.close();  // Scanner 객체를 닫습니다.
		
	}

}

