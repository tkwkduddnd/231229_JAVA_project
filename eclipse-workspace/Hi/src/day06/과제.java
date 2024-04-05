package day06;

import java.util.Scanner;

public class 과제 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("값을 입력하세요: ");

        int num= scanner.nextInt();
        int num1= 0;
        int sum= 0;

        if (num != 0) {
            do {
                int num2 = num % 10;
                num1 = num1 * 10 + num2;
                sum += num2;
                num /= 10;
            } while (num != 0);
        }

        System.out.println("거꾸로 된 숫자: " + num1);
        System.out.println("각 자리 숫자의 합: " + sum);
       
    }
}
