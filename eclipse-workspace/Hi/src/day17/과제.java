package day17;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 과제 {

    public static void main(String[] args) {
        // 숫자를 입력받아 입력받은 숫자를 list로 구성하고, 출력
        // 합계를 출력
        // 입력값 : 45, 81, 32, 14, 63, 25 , 87, 91, 99, 100=> String
        // list에 넣고, 출력 => 합계와 인원수 같이 출력
        // 70점 이상인 점수가 몇명인지 출력
        
        List<Integer> list = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        
        int sum = 0;
        int count = 0;
        
        System.out.println("숫자를 입력하세요.");
        
        while(true) {
            int input = scan.nextInt();
            
            if(input == 0) {
            	break;
            }
            
            if(input >= 70) {
            	count++;
            }
            
            list.add(input);
            sum += input;
            
            
        }
        
        System.out.println("입력된 점수: " + list);
        System.out.println("합계: " + sum);
        System.out.println("인원 수: " + list.size());
        System.out.println("70점 이상인 인원 수: " + count);
        
        scan.close();
    }
}
