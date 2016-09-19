package com.hanbit.web.lambda;

public class InnerTest {
	public static void main(String[] args){
	Outer o = new Outer();
	Outer.InnerInsatance i = o.new InnerInsatance();
	Outer.StaticInner osi = new Outer.StaticInner();
	
	System.out.println(i.iv);
	System.out.println(i.SV);
	System.out.println(osi.cv);
	}
}
class Outer{
	class InnerInsatance{
		int iv = 100;
		static final int SV = 200;
	}
	static class StaticInner{
		int cv = 300;
	}
}
