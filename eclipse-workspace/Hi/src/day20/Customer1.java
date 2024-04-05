package day20;

import java.util.Comparator;

public class Customer1 {
	
	private String name;
	private int age;
	private int price;
	
	public Customer1() {
		
	}
	public Customer1(String name, int age, int price) {
		this.name = name;
		this.age = age;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public static class cusComparator implements Comparator<Customer1> {
		@Override
		public int compare(Customer1 o1, Customer1 o2) {
			return Integer.compare(o1.getAge(), o2.getAge());
		}
	}
}
