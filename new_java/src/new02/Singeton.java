package new02;

public class Singeton {
	/*
	 * 싱글톤 패턴 : 디자인 패턴 중 하나
	 * 단 1개만 존재해야하는 객체를 생성하여 => 공유하고자 할 때 사용
	 */
		// 단 1개만 존재해야하는 객체의 인스턴스 생성
		private static Singeton instance;
		
		// 생성자를 통해 객체 생성을 막기 위해 생성자 private 설정
		private Singeton() {}
		
		// getter getInstance() 메서드를 사용하여 instance 생성
		// instance가 있으면 기존의 instance를 리턴
		// instance가 없으면 새롤 생성해서 리턴
		public static Singeton getInstance() {
			if(instance == null) {
				instance = new Singeton();
			}
			return instance;
		}

}
