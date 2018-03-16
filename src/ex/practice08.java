package ex;

import java.util.Scanner;

public class practice08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] numbers = new int[num];
		
		for(int i=0; i<num; i++) {
			int number = sc.nextInt();
			numbers[i] = number;
		}
		sc.close();
		bubble(num,numbers);
		for(int i = 0; i<num; i++) {
			System.out.println(numbers[i]);
		}
		
	}
	//bubble sort 
	public static void bubble(int num,int[] numbers) {
		for(int i= num-1; i>0; i--) {
			for(int j= 0; j<i; j++) {
				if(numbers[j]>numbers[j+1]) {
					//swap
					int temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
			
				}
			}
		}
	}
	/*
	 * swap 함수로 바꿔도 전혀 정렬 되지 않는 이유는
	메소드에서 프리미티브 타입의 매개변수는 호출된 메서드에서
	값이 바껴도 호출한 쪽에서 영향을 받지 않음
	값에 의한 호출이기 때문이다.
	*/
	public static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}
}
