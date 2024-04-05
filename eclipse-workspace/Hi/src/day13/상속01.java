package day13;

public class 상속01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* 상속 : 부모것을 자식에게 물려줌
		 * 상속 : 멤버변수와 멤버메소드만 물려줌
		 * 클래스의 확장 개념
		 * 상속하는 이유: 재사용을 해서 중복 최소화
		 * private 은 상속 불가능
		 * protected : 상속받는 자식에게 허용하는 제어자
		 * 
		 */
		
		A a = new A();
		a.setA(10);
		a.setB(20);
		a.setC(30);
		a.setNum(100);
		a.print();
		System.out.println("----------------------------------");
		B b = new B();
		b.setA(100);
		b.setB(200);
		b.setC(300);
		b.num=1000; // 접근제한자가 protected여서 직접 접근 가능
		b.print();
		System.out.println("----------------------------------");
		b.setD(100);
		b.setE(200);
		b.setF(300);
		b.print();
		

	}

}


class A {  //부모 클래스
	private int a,b,c;
	protected int num;
	
	public void print() {
		System.out.println("a: "+a+", b: "+b+", c: "+c);
		System.out.println("num: "+num);
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}

class B extends A{ //자식 클래스
	private int d,e,f;
	
	
	

	@Override // 부모의 메소드를 재정의 하는 것
	public void print() {
		// TODO Auto-generated method stub
		super.print();//부모의 값을 가져올 때 사용 , 부모의 print() 메소드를 호출하여 출력
		System.out.println("d:"+d+", e: "+e+", f: "+f);
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getE() {
		return e;
	}

	public void setE(int e) {
		this.e = e;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}
}