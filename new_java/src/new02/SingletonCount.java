package new02;

class Counter {
    // 싱글톤 인스턴스
    private static Counter instance;
    private int count;

    // 외부에서의 인스턴스 생성을 방지하기 위한 비공개 생성자
    private Counter() {
        count = 0;
    }

    // 싱글톤 인스턴스를 얻기 위한 정적 메서드
    public static Counter getInstance() {
        if (instance == null) {
            instance = new Counter();
        }
        return instance;
    }

    
    public int countMethod() {
        return ++count;
    }
}

public class SingletonCount {

    public static void main(String[] args) {
        
        Counter counter1 = Counter.getInstance();
        
        System.out.println("counter1에서의 count: " + counter1.countMethod());

       
        Counter counter2 = Counter.getInstance();
        
        System.out.println("counter2에서의 count: " + counter2.countMethod());
    }
}