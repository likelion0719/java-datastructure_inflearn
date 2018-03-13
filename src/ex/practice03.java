package ex;

import java.util.Scanner;

public class practice03 {
	/*18.03.09
	 * 사용자로부터 정수의 개수 n을 입력 받는다.
	 * 크기가 n인 배열을 생성해서 정수를 담는다.
	 * 배열안에 중복된 정수 쌍을 카운트 해서  출력 
	 * ex) 2,4,2,4,5,2 이면 (2,2)쌍 3개 (4,4)쌍 1개
	   모두 4쌍이다.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int[] numbers = new int[n];
		int count = 0;
		for(int i=0; i<n; i++) {
			numbers[i]= sc.nextInt();
		}
		sc.close();
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				if(numbers[i] == numbers[j])
					count++;
			}
		}
		System.out.println(count);
	}

}
