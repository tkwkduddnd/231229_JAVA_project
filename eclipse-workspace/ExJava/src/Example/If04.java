package Example;

public class If04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Math.method
		 * Math.round(반올림): 소수 자리는 무조건 0
		 * Math.ceil(올림) / Math.floor(버림)
		 */
		double num = 3.1411111;
		//반올림: 3 / 올림: 4 / 내림 : 3
		
		int roundNum = (int)(Math.round(num));
		System.out.println(roundNum);
		
		int ceilNum = (int)(Math.ceil(num));
		System.out.println(ceilNum);
		
		int floorNum = (int)(Math.floor(num));
		System.out.println(floorNum);
		
		System.out.println("--------------------");
		
		//Math.max(최대값), Math.min(최소값)
		System.out.println(Math.max(5, 3));
		System.out.println(Math.min(5, 3));
		
		System.out.println("--------------------");
		
		//Math.random : 0과1 사이의 아무값을 출력
		//(int)(Math.random()*count)+start
		//start부터 count까지의 랜덤수를 얻는 공식
		System.out.println((int)(Math.random()*10)+1);
	}

}
