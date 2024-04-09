package new_java;
import java.util.Scanner;

public class WordMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Word wordManager = new Word();
        int choice;

        do {
            System.out.println("메뉴를 선택하세요:");
            System.out.println("1. 단어 등록");
            System.out.println("2. 단어 검색");
            System.out.println("3. 단어 수정");
            System.out.println("4. 단어 출력");
            System.out.println("5. 파일로 내보내기");
            System.out.println("6. 종료");
            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    wordManager.registerWord(scan);
                    break;
                case 2:
                    wordManager.searchWord(scan);
                    break;
                case 3:
                    wordManager.modifyWord(scan);
                    break;
                case 4:
                    wordManager.printWords();
                    break;
                case 5:
                    wordManager.exportToFile();
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("올바른 메뉴를 선택하세요.");
            }
        } while (choice != 6);
    }
}