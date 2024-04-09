package jdbcboard;

import java.util.List;
import java.util.Scanner;

public class boardController {
    private Scanner scan;
    private boardService bsvc;
    private boolean flag;

    public boardController() {
        scan = new Scanner(System.in);
        bsvc = new boardServiceImpl();
        flag = true;
        printMenu();
    }

    private void printMenu() {
        while (flag) {
            System.out.println("--게시판--");
            System.out.println("1. 게시글 추가 | 2. 게시글 목록 | 3. 게시글 검색(게시글 상세보기)");
            System.out.println("4. 게시글 수정 | 5. 게시글 삭제 | 6. 종료");
            System.out.println("메뉴 선택 -> ");

            int menu = scan.nextInt();

            switch (menu) {
                case 1:
                    register();
                    break;
                case 2:
                    list();
                    break;
                case 3:
                    detail();
                    break;
                case 4:
                    modify();
                    break;
                case 5:
                    remove();
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }

    private void remove() {
        System.out.println("삭제하려는 번호");
        int bno = scan.nextInt();

        int isDeleted = bsvc.remove(bno);
        if (isDeleted > 0) {
            System.out.println("게시글 삭제 성공");
        } else {
            System.out.println("게시글 삭제 실패");
        }
    }

    private void modify() {
        System.out.println("수정하려는 번호");
        int bno = scan.nextInt();
        
        // 해당 번호의 게시글 정보를 가져옴
        boardVO existingPost = bsvc.getDetail(bno);
        
        if (existingPost != null) {
            System.out.println("수정할 내용을 입력하세요.");
            
            System.out.println("게시글 제목");
            scan.nextLine(); // 버퍼 비우기
            String title = scan.nextLine();
            
            System.out.println("게시글 내용");
            String content = scan.nextLine();
            
            // 새로운 boardVO 객체 생성하여 수정할 내용으로 초기화
            boardVO result = new boardVO(bno, title, existingPost.getWriter(), content);
            
            // 게시글 수정 메소드 호출
            int isOK = bsvc.modify(result);
            
            // 수정 성공/실패 여부 출력
            if (isOK > 0) {
                System.out.println("게시글 수정 성공");
            } else {
                System.out.println("게시글 수정 실패");
            }
        } else {
            System.out.println("해당 번호의 게시글이 존재하지 않습니다.");
        }
    }


    private void detail() {
        System.out.println("게시글번호 -> ");
        int bno = scan.nextInt();
        boardVO b = bsvc.getDetail(bno);
        if (b != null) {
            System.out.println(b);
        } else {
            System.out.println("해당 번호의 게시글이 없습니다.");
        }
    }

    private void list() {
        List<boardVO> list = bsvc.getList();
        
        for (boardVO p : list) {
            System.out.println(p);
        }
    }

    private void register() {
        System.out.println("게시글 제목: ");
        scan.nextLine();
        String title = scan.nextLine();
        System.out.println("게시글 내용: ");
        String content = scan.nextLine();
        System.out.println("게시글 작성자: ");
        String writer = scan.nextLine();
        boardVO b = new boardVO(title, writer, content);
        int isOK = bsvc.register(b);
        if (isOK > 0) {
            System.out.println("게시글 등록 성공");
        } else {
            System.out.println("게시글 등록 실패");
        }
    }
}
