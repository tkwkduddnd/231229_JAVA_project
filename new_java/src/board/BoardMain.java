package board;

import java.util.Scanner;

public class BoardMain {

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
    			/*
    			 * Board class 생성
    			 * 번호, 제목, 내용, 작성자, 작성일
    			 * 작성일은 오늘날짜 기준으로 자동생성
    			 * 번호 : 내용 생성시 자동으로 번호가 올라가게 생성
    			 * - 번호가 일치하면 같은 게시물로 인지함
    			 * 게시글 검색, 게시글 수정, 게시글 삭제는 번호를 기준으로 한다.
    			 * equlas 추가
    			 * 
    			 * 
    			 * -menu
    			 * 1. 게시글 추가
    			 * 2. 게시글 검색
    			 * 3. 게시글 수정
    			 * 4. 게시글 삭제
    			 * 5. 게시글 출력
    			 * 6. 종료
    			 */
        Scanner scan = new Scanner(System.in);
        BoardManager boardManager = new BoardManager();

        while (true) {
            boardManager.printMenu();
            int choice = scan.nextInt();
            scan.nextLine(); 

            switch (choice) {
                case 1:
                    boardManager.addBoard(scan);
                    break;
                case 2:
                    boardManager.searchBoard(scan);
                    break;
                case 3:
                    boardManager.modifyBoard(scan);
                    break;
                case 4:
                    boardManager.removeBoard(scan);
                    break;
                case 5:
                    boardManager.printBoard();
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    scan.close();
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }
}

