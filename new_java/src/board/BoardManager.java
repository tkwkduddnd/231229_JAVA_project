package board;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BoardManager implements BoardInterface {
    private List<Board> boardList = new ArrayList<>();
    private int boardCount = 1;

    @Override
    public void addBoard(Scanner scan) {
        System.out.print("제목을 입력하세요: ");
        String title = scan.nextLine();
        System.out.print("내용을 입력하세요: ");
        String content = scan.nextLine();
        System.out.print("작성자 이름을 입력하세요: ");
        String name = scan.nextLine();

        String dateString = new Date().toString();

        Board board = new Board(title, content, name, boardCount++, dateString);
        boardList.add(board);
        System.out.println("게시글이 추가되었습니다.");
    }

    @Override
    public void searchBoard(Scanner scan) {
        System.out.print("검색할 게시글 번호를 입력하세요: ");
        int number = scan.nextInt();
        for (Board board : boardList) {
            if (board.getNumber() == number) {
                System.out.println("번호: " + board.getNumber() + ", 제목: " + board.getTitle() + ", 내용: " + board.getContent() + ", 작성자: " + board.getName() + ", 작성일: " + board.getDate());
                return;
            }
        }
        System.out.println("해당 번호의 게시글을 찾을 수 없습니다.");
    }

    @Override
    public void modifyBoard(Scanner scan) {
        System.out.print("수정할 게시글 번호를 입력하세요: ");
        int number = scan.nextInt();
        scan.nextLine(); // 버퍼 비우기
        for (Board board : boardList) {
            if (board.getNumber() == number) {
                System.out.print("새 제목을 입력하세요: ");
                board.setTitle(scan.nextLine());
                System.out.print("새 내용을 입력하세요: ");
                board.setContent(scan.nextLine());
                System.out.println("게시글이 수정되었습니다.");
                return;
            }
        }
        System.out.println("해당 번호의 게시글을 찾을 수 없습니다.");
    }

    @Override
    public void removeBoard(Scanner scan) {
        System.out.print("삭제할 게시글 번호를 입력하세요: ");
        int number = scan.nextInt();
        for (int i = 0; i < boardList.size(); i++) {
            if (boardList.get(i).getNumber() == number) {
                boardList.remove(i);
                System.out.println("게시글이 삭제되었습니다.");
                return;
            }
        }
        System.out.println("해당 번호의 게시글을 찾을 수 없습니다.");
    }

    @Override
    public void printBoard() {
        for (Board board : boardList) {
            System.out.println("번호: " + board.getNumber() + ", 제목: " + board.getTitle() + ", 내용: " + board.getContent() + ", 작성자: " + board.getName() + ", 작성일: " + board.getDate());
        }
    }

    @Override
    public void printMenu() {
        System.out.println("\n--- 메뉴 ---");
        System.out.println("1. 게시글 추가");
        System.out.println("2. 게시글 검색");
        System.out.println("3. 게시글 수정");
        System.out.println("4. 게시글 삭제");
        System.out.println("5. 게시글 출력");
        System.out.println("6. 종료");
        System.out.print("선택: ");
    }
}
