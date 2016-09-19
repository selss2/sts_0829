package com.hanbit.web.lambda;

import java.util.Arrays;
import java.util.List;

public class PreLambdaList {
	public static void main(String[] args){
		PreLambdaList p = new PreLambdaList();
		p.printElem();			
		System.out.println();
		System.out.println("합계 : "+ p.sumAll());
	}
	List<Integer> numbers = Arrays.asList(1,2,3,4,5);
	public void printElem(){
		for(int num : numbers){
		}
	}
	
	public int sumAll(){
		int sum = 0;
		for (int num : numbers){
			sum = sum+num;
	}
	return sum;
	}


	public void sumEven(){
		int sum = 0;
		for (int num : numbers)
			if (num%2 ==0) {
				sum=sum+num;
			}
		System.out.println("짝수 합계 : "+sum);
	}
	public void sumOdd(){
		int sum = 0;
		for (int num : numbers)
			if (num%2 !=0) {
				sum=sum+num;
			}
		System.out.println("홀수 합계 : "+sum);
	}
}