package day16;

import java.util.Random;

public class Exception06 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /*
         * 메소드에서 생성된 배열 출력
         */
        int start = -1;
        int cnt = 5;
        int size = 5;
        
        try {
            int[] arr = randomArray(size, start, cnt);
            nullArray(arr, start, cnt);
            for(int i : arr) {
                System.out.println(i);
            }
        }
        catch(NullPointerException e) {
            System.out.println("null값 입니다");
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("배열 인덱스가 범위를 초과했습니다.");
        }
        catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

  //메소드 생성
    /*
    * 기능: size를 매개변수로 입력받아
    * 해당하는 size만큼의 길이를 가지는 배열을 생성하여
    * 랜덤값을 채워 배열을 리턴해주는 기능
    * ex) size가 10이면 10만큼의 배열을 생성하여 랜덤값을 채워 배열을 리턴
    * 랜덤값의 범위는 매개변수로 입력 start(시작값), cnt(개수)
    *
    * ex) size가 0보다 작다면 예외발생
    * ex) cnt 개수가 0보다 작다면 예외발생
    */
    
    public static int[] randomArray(int size, int start, int cnt) {
        if(size < 0 || cnt < 0) {
            throw new RuntimeException("size와 cnt는 0보다 커야 합니다.");
        }
        
        int[] arr = new int[size];
        Random rand = new Random();
        
        for(int i = 0; i < size; i++) {
            arr[i]= start + rand.nextInt(cnt);
        }
        
        return arr;
    }

    
  //메소드 생성
    /*
    * 기능: 매개변수로 배열을 받아서 랜덤값을 채우는 메소드
    * 랜덤값의 범위는 매개변수로 입력 start(시작값), cnt(개수)
    *
    * ex) 배열이 null이면 예외발생
    * ex) 배열의 길이가 0보다 작다면 예외발생 0일 때는 상관없음
    */

    
    public static void nullArray(int[] arr, int start, int cnt) {
        if(arr == null || arr.length < 0) {
            throw new RuntimeException("배열이 null이거나,길이가 0보다 작을 수 없습니다.");
        }
        
        Random rand = new Random();
        
        for(int i = 0; i < arr.length; i++) {
            arr[i]= start + rand.nextInt(cnt);
        }
    }
}
