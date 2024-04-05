package day17;

import java.util.HashMap;
import java.util.Scanner;

public class Map03 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        String subject;
        int score;
        int sum = 0;
        int count = 0;
        double average;

        while (true) {
            System.out.println("과목을 입력하세요. 종료하려면 '종료' 를 입력하세요 ->");
            subject = scan.nextLine();

            
            if (subject.equals("종료")) {
                break;
            }

            System.out.println("점수를 입력하세요. 종료하려면 '0'을 입력하세요 ->");
            score = scan.nextInt();
            scan.nextLine(); 

            if(score == 0) {
                break;
            }

            map.put(subject, score);
            sum += score;
            count++;
        }

        
        for(String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }

        
        if (count > 0) {
            average = (double)sum / count;
            System.out.println("합계: " + sum);
            System.out.println("평균: " + average);
        }

        scan.close();
    }
}