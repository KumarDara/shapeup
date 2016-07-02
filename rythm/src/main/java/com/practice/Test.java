package com.practice;

public class Test implements Cloneable{
	int x;
	int y;
	TestA ta = new TestA();
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	public static void main(String[] args) {
		Test t = new Test();
		t.x = 5;
		t.y = 6;
		t.ta.a = 5;
		t.ta.b = 6;
		try {
			Test t2 = (Test) t.clone();
			t2.ta.a = 7;
			System.out.println(t.ta.a);
			System.out.println(t2.ta.a);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

class TestA implements Cloneable{
	int a;
	int b;
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}