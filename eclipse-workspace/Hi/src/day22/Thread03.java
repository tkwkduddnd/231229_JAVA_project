package day22;

class MyThread3 extends Thread{
	
	int start;
	int end;
	int total;
	public MyThread3(int start, int end) {
		this.start = start;
		this.end = end;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=start;i<=end;i++) {
			this.total +=i;
			
		}
	}
	
	
}

public class Thread03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1~50, 51~100까지 합을 구하는 두개의 Thread를 생성
		 * 그 결과를 확인
		 * 
		 * 두개의 Thread가 실행되고 난 후
		 * thread1 1~50까지의 합계 출력
		 * thread2 51~100까지의 합계 출력
		 * 마지막에 thread1, thread2의 합계 출력
		 */
		
		MyThread3 mth = new MyThread3(1,50);
		MyThread3 mth1 = new MyThread3(51,100);
		mth.start();
		mth1.start();
		
		
		try {
			mth.join();
			Thread.sleep(5000);
			mth1.join();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(mth.total);
		System.out.println(mth1.total);
		int lastTotal = mth.total+mth1.total;
		System.out.println(lastTotal);
	}

}
