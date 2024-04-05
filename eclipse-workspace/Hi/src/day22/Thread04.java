package day22;

class Bank{
	private int money;
	
	//입금
	public synchronized void saveMoney(int save) {
		int m = this.money;
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		this.money = m+save;
		
	}
	
	//출금
	public synchronized void minusMoney(int minus) {
		int m = this.money;
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		this.money = m-minus;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
}


class Hong extends Thread{

	@Override
	public void run() {
		System.out.println("홍이 입금을 시작합니다.");
		Thread04.myBank.saveMoney(10000);
		System.out.println("savemoney(10000)"+ Thread04.myBank.getMoney());
	}
	
}

class HongWife extends Thread{

	@Override
	public void run() {
		System.out.println("홍 와이프가 출금을 시작합니다.");
		Thread04.myBank.minusMoney(10000);
		System.out.println("minusmoney(10000)"+ Thread04.myBank.getMoney());
	}
	
	
}

public class Thread04 {
	public static Bank myBank = new Bank(); //공유 영역

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*
		 * critical section은 두개 이상의 쓰레드가 
		 * 동시에 접근할 수 있는 영역(공유 영역)
		 * 동시에 여러 개의 쓰레드가 접근하게 되면 문제가 생길 수 있음
		 * 세마포어(semaphore) 기법을 사용하여 한 순간에 오직 하나의 쓰레드만 사용가능
		 * 
		 * 동기화 키워드 : synchronized
		 * 동기화가 필요한 메소드 앞에 선언
		 * 
		 * bank 클래스 생성: 은행
		 * 계좌 1개 생성(bank클래스의 객체 1개 생성)
		 * hong hongwife
		 */
		Hong h = new Hong();
		h.start();
		
		Thread.sleep(2000);
		
		HongWife hW = new HongWife();
		hW.start();
		
		

	}

}
