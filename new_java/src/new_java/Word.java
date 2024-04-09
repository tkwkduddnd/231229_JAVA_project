package new_java;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Word {
    private Map<String, String> wordMap;

    public Word() {
        this.wordMap = new HashMap<>();
    }

    public void registerWord(Scanner scan) {
        System.out.println("단어를 입력하세요:");
        String word = scan.nextLine();
        System.out.println("의미를 입력하세요:");
        String mean = scan.nextLine();
        wordMap.put(word, mean);
        System.out.println("단어가 등록되었습니다.");
    }

    public void searchWord(Scanner scan) {
        System.out.println("검색할 단어를 입력하세요:");
        String searchWord = scan.nextLine();
        String mean = wordMap.get(searchWord);
        if (mean != null) {
            System.out.println("의미: " + mean);
        } else {
            System.out.println("단어를 찾을 수 없습니다.");
        }
    }

    public void modifyWord(Scanner scan) {
        System.out.println("수정할 단어를 입력하세요:");
        String modifyWord = scan.nextLine();
        String mean = wordMap.get(modifyWord);
        if (mean != null) {
            System.out.println("새로운 의미를 입력하세요:");
            String newmean = scan.nextLine();
            wordMap.put(modifyWord, newmean);
            System.out.println("단어가 수정되었습니다.");
        } else {
            System.out.println("수정할 단어를 찾을 수 없습니다.");
        }
    }

    public void printWords() {
        if (wordMap.isEmpty()) {
            System.out.println("등록된 단어가 없습니다.");
        } else {
            System.out.println("등록된 단어 목록:");
            for (Map.Entry<String, String> entry : wordMap.entrySet()) {
                System.out.println("단어: " + entry.getKey() + ", 의미: " + entry.getValue());
            }
        }
    }

    public void exportToFile() {
        try {
            FileWriter writer = new FileWriter("words.txt");
            for (Map.Entry<String, String> entry : wordMap.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
            writer.close();
            System.out.println("단어가 파일로 내보내기 되었습니다.");
        } catch (IOException e) {
            System.out.println("파일로 내보내기를 실패했습니다: " + e.getMessage());
        }
    }
}