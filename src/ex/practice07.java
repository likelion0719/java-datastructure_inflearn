package ex;

import java.util.Scanner;

public class practice07 {
	/*
	 * 사용자로부터 n개의 정수를 입력받는다.
	 * 정수가 하나씩 입력받을때마다  현재까지 입력된
	 * 정수들을 오름차순으로 정렬
	 * orderedlist에 insert 할때
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] numbers = new int[num];
		/* 정렬은 되지만 연산이 많아짐 여기선 버블정렬 어울리지 않음
		for(int i=0; i<num; i++) {
			numbers[i] = sc.nextInt();
			for(int j=i;j>0;j--) {
				if(numbers[j]<numbers[j-1]) {
					int temp = numbers[j];
					numbers[j] =numbers[j-1];
					numbers[j-1] = temp;
				}
			}
		}
		*/
		for(int i=0; i<num; i++) {
			int temp = sc.nextInt();
			int j = i-1;
			while(j>=0 && numbers[j] > temp) {
				numbers[j+1] = numbers[j];
				j--;
			}
			numbers[j+1] = temp;
		}
		
		for(int i=0; i<num; i++) {
			System.out.println(numbers[i]);
		}
	}

}
