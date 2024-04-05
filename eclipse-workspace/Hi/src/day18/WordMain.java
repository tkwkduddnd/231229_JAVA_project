package day18;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import day18.WordManager;

public class WordMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		 * 단어장 프로그램 작성
		 * 1. 단어 등록 | 2. 단어 검색 | 3. 단어 수정 | 4. 단어 출력 | 5. 단어 삭제 | 6. 종료
		 * WordManager 클래스 생성하여 메소드 구현
		 * map을 이용하여 단어 등록
		 * 기본적으로 단어 등록(5가지 등록)
		 * main에서는 메뉴가 반복 실행되도록 설정
		 */
		
		Scanner scan = new Scanner(System.in);
		WordManager wordmanager= new WordManager();
		
		int choose;
		wordmanager.word.put("dog", "개");
		wordmanager.word.put("cat", "고양이");
		wordmanager.word.put("bird", "새");

        do {
        	System.out.println("----단어장----");
            System.out.println("-------------------------------");
            System.out.println("1.단어 등록 | 2. 단어 검색 | 3. 단어 수정");
            System.out.println("4. 단어 출력 | 5. 단어 삭제 | 6. 현재 단어 파일출력 | 7. 종료");
            System.out.println("-------------------------------");

            System.out.print("선택: ");
            choose = scan.nextInt();

            switch(choose) {
                case 1:
                    wordmanager.insertWord(scan);
                    break;
                case 2:
                    wordmanager.searchWord(scan);
                    break;
                case 3:
                    wordmanager.correctWord(scan);
                    break;
                case 4:
                    wordmanager.printWord(scan);
                    break;
                case 5:
                    wordmanager.deleteWord(scan);
                    break;
                case 6:
                    wordmanager.printfile(scan);
                    break;
                case 7:
                	System.out.println("프로그램을 종료합니다.");
                	break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해 주세요.");
            }
        } while (choose != 7);

        scan.close();
    }
}
