package day22;

class MyThread2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<=200;i++) {
			System.out.println(i+"번째 쓰레드"+Thread.currentThread().getName());
		}
	}
	
}

public class Thread02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Runnable로 구현한 스레드 객체 생성
		//Thread 객체를 생성하여 Runnable 구현체를 생성자로 제공
		System.out.println("main start");
		MyThread2 mth = new MyThread2();
		Thread th = new Thread(mth);
		
		//join(): 동시에 2개ㅢ 스레드가 실행될 때 다른 쓰레드의 결과를 참조하여
		// 실행되어야 하는 경우 join() 메소드 사용
		
		th.start();
		Thread th2 = new Thread(new MyThread2());
		th2.start();
		
		
		try {
			th.join();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("main end");
		
		
//		Thread th = new MyThread();
//		th.start();
//		Thread th2 = new MyThread();
//		th2.start();

	}

}
